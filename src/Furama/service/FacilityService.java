package Furama.service;

import Furama.entity.facility.Facility;
import Furama.repository.FacilityRepository;
import Furama.repository.IFacilityRepository;

import java.util.Map;

public class FacilityService implements  IFacilityService{
    private static final IFacilityRepository facilityRepo = new FacilityRepository();
    @Override
    public boolean add(Facility facility) {
        return facilityRepo.add(facility);
    }

    @Override
    public boolean delete(Facility facility) {
        return facilityRepo.delete(facility);
    }

    @Override
    public boolean update(Facility facility) {
        return facilityRepo.update(facility);
    }

    @Override
    public Map<Facility, Integer> displayAll() {
        return facilityRepo.displayAll();
    }

    @Override
    public Facility findById(String idFacility) {
        return facilityRepo.findById(idFacility);
    }
}
