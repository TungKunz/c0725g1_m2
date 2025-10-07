package Furama.service;

import Furama.entity.Booking;
import Furama.entity.facility.Facility;
import Furama.repository.*;

import java.util.Queue;
import java.util.Set;

public class BookingService implements IBookingService {
    private static final IFacilityRepository facilityRepository = new FacilityRepository();
    private static final ICustomerRepository customerRepository = new CustomerRepository();
    private final IBookingRepository bookingRepository = new BookingRepository();


    @Override
    public Set<Booking> getAll() {
        return bookingRepository.getAll();
    }

    @Override
    public boolean add(Booking booking) {
        if (customerRepository.findById(booking.getCustomerId()) == null) {
            System.out.println("Mã khách hàng không tồn tại!");
            return false;
        }
        if (facilityRepository.findById(booking.getServiceId()) == null) {
            System.out.println("Mã dịch vụ không tồn tại!");
            return false;
        }
        boolean added = bookingRepository.add(booking);
        if (added) {
            Facility facility = facilityRepository.findById(booking.getServiceId());
            facilityRepository.increaseUsage(facility);
        }
        return added;
    }

    @Override
    public Queue<Booking> getBookingQueueByOrder() {
        return bookingRepository.getBookingQueueByOrder();
    }
    @Override
    public boolean removeBooking(Booking booking) {
        return bookingRepository.removeBooking(booking);
    }

}
