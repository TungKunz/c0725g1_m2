package Furama.repository;
import Furama.entity.Booking;

import java.time.LocalDate;
import java.util.*;

public class BookingRepository implements IBookingRepository {
    private static final Set<Booking> bookingSet = new TreeSet<>();
    static {
        bookingSet.add(new Booking("B001", LocalDate.of(2025,10,1),
                LocalDate.of(2025,10,5), LocalDate.of(2025,10,10),
                "KH-9999", "SVVL-9999"));
        bookingSet.add(new Booking("B002", LocalDate.of(2025,10,2),
                LocalDate.of(2025,10,6), LocalDate.of(2025,10,12),
                "KH-8888", "SVHO-8888"));
        bookingSet.add(new Booking("B003", LocalDate.of(2025,10,3),
                LocalDate.of(2025,10,7), LocalDate.of(2025,10,13),
                "KH-7777", "SVRO-7777"));
    }


    @Override
    public Set<Booking> getAll() {
        return bookingSet;
    }
    @Override
    public boolean add(Booking booking) {
        if (booking == null) return false;
        bookingSet.add(booking);
        return true;
    }
    public boolean removeBooking(Booking booking) {
        return bookingSet.remove(booking);
    }
    @Override
    public Queue<Booking> getBookingQueueByOrder() {
        return new LinkedList<>(bookingSet);
    }
}
