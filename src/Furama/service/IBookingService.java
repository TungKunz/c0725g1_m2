package Furama.service;

import Furama.entity.Booking;

import java.util.Set;

public interface IBookingService{
    Set<Booking> getAll();
    boolean add(Booking booking);
}
