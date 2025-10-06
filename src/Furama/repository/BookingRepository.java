package Furama.repository;
import Furama.entity.Booking;
import java.util.*;

public class BookingRepository implements IBookingRepository {
    private static final Set<Booking> bookingSet = new TreeSet<>();


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

    public Queue<Booking> getBookingQueueByOrder() {
        return new LinkedList<>(bookingSet);
    }
}
