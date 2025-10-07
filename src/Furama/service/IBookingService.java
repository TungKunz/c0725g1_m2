package Furama.service;

import Furama.entity.Booking;

import java.util.Queue;
import java.util.Set;

public interface IBookingService{
    Set<Booking> getAll();
    boolean add(Booking booking);
    Queue<Booking> getBookingQueueByOrder();
    boolean removeBooking(Booking booking);
}
