package Furama.repository;
import Furama.entity.facility.Facility;
import Furama.entity.facility.House;
import Furama.entity.facility.Room;
import Furama.entity.facility.Villa;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository{
    private static final Map<Facility,Integer> facilityMap = new LinkedHashMap<>();

    static {

        facilityMap.put(new Villa(
                "SVVL-9999", "Luxury Villa", 200, 5000, 10, "Daily", "Premium", 50, 2
        ), 0);


        facilityMap.put(new House(
                "SVHO-8888", "Family House", 100, 2000, 6, "Daily", "Standard", 2
        ), 0);


        facilityMap.put(new Room(
                "SVRO-7777", "Deluxe Room", 50, 1000, 2, "Daily", "Free breakfast"
        ), 0);
    }
    @Override
    public boolean add(Facility facility) {
        if (facility == null) return false;
        if (!facilityMap.containsKey(facility)) {
            facilityMap.put(facility, 0);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Facility facility) {
        Facility toRemove = null;

        for (Facility f : facilityMap.keySet()) {
            if (f.getIdFacility().equals(facility.getIdFacility())) {
                toRemove = f;
                break;
            }
        }

        if (toRemove != null) {
            facilityMap.remove(toRemove);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Facility facility) {
        for (Facility f : facilityMap.keySet()) {
            if (f.getIdFacility().equals(facility.getIdFacility())) {
                int usage = facilityMap.get(f);
                facilityMap.remove(f);
                facilityMap.put(facility, usage);
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<Facility, Integer> displayAll() {
        return new LinkedHashMap<>(facilityMap);
    }

    @Override
    public Facility findById(String idFacility) {
        for(Facility facility: facilityMap.keySet()){
            if(facility.getIdFacility().equals(idFacility)){
                return facility;
            }
        }
        return null;
    }

    public void increaseUsage(Facility facility) {
        if (facility == null) return;
        int current = facilityMap.getOrDefault(facility, 0);
        facilityMap.put(facility, current + 1);
    }

}
