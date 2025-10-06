package Furama.repository;
import java.util.List;
import java.util.ArrayList;


import Furama.entity.Booking;
import java.util.Set;

public interface IBookingRepository {
    Set<Booking> getAll();
    boolean add(Booking booking);
}

