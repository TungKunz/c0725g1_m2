package Furama.entity;

import Furama.entity.person.Customer;

import java.util.List;

public class Event {
    private String eventId;
    private String eventName;
    private String eventDate;
    private List<Customer> targetCustomer;
    Event(){}

    public Event(String eventId, String eventName, String eventDate, List<Customer> targetCustomer) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.targetCustomer = targetCustomer;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public List<Customer> getTargetCustomer() {
        return targetCustomer;
    }

    public void setTargetCustomer(List<Customer> targetCustomer) {
        this.targetCustomer = targetCustomer;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", targetCustomer=" + targetCustomer +
                '}';
    }
}
