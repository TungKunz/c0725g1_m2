package Furama.entity.facility;

public class Room extends Facility{
    private String freeService;
    public Room(){}
    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String idFacility, String nameFacility, double areaFacility, long costFacility, int numberMemberMaxFacility, String rentalStyleFacility, String freeService) {
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
                "idFacility='" + getIdFacility() + '\'' +
                ", nameFacility='" + getNameFacility() + '\'' +
                ", areaFacility=" + getAreaFacility() +
                ", costFacility=" + getCostFacility() +
                ", numberMemberMaxFacility=" + getNumberMemberMaxFacility() +
                ", rentalStyleFacility='" + getRentalStyleFacility() + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }


    @Override
    public String getInforToCSV() {
        return this.getIdFacility() + ","
                + this.getNameFacility() + ","
                + this.getAreaFacility() + ","
                + this.getCostFacility() + ","
                + this.getNumberMemberMaxFacility() + ","
                + this.getRentalStyleFacility() + ","
                + this.getFreeService();
    }
}
