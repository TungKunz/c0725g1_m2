package Furama.entity;

import Furama.entity.facility.Facility;
import Furama.entity.person.Customer;

public class Booking {
    private String bookingId;
    private String bookingDate;
    private String startDate;
    private String endDate;
    private Customer customerId;
    private Facility serviceId;
    private Booking(){}

    public Booking(String bookingId, String bookingDate, String startDate, String endDate, Customer customerId, Facility serviceId) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Facility getServiceId() {
        return serviceId;
    }

    public void setServiceId(Facility serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerId=" + customerId +
                ", serviceId=" + serviceId +
                '}';
    }
}
