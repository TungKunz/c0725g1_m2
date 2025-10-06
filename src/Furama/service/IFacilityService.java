package Furama.service;

import Furama.entity.facility.Facility;

import java.util.Map;

public interface IFacilityService{
    boolean add(Facility facility);
    boolean delete(Facility facility);
    boolean update(Facility facility);
    Map<Facility, Integer> displayAll();
    Facility findById(String idFacility);
}
