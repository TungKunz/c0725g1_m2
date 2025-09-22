package Furama.entity.facility;

public class Room extends Facility{
    private String freeService;
    Room(){}
    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(int idFacility, String nameFacility, double areaFacility, long costFacility, int numberMemberMaxFacility, String rentalStyleFacility, String freeService) {
        super(idFacility, nameFacility, areaFacility, costFacility, numberMemberMaxFacility, rentalStyleFacility);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
