package Furama.entity.facility;

public class Villa extends Facility {
    private String roomStandards;
    private double poolArea;
    private int numberOfFloors;

    Villa() {
    }

    public Villa(String roomStandards, double poolArea, int numberOfFloors) {
        this.roomStandards = roomStandards;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(int idFacility, String nameFacility, double areaFacility, long costFacility, int numberMemberMaxFacility, String rentalStyleFacility, String roomStandards, double poolArea, int numberOfFloors) {
        super(idFacility, nameFacility, areaFacility, costFacility, numberMemberMaxFacility, rentalStyleFacility);
        this.roomStandards = roomStandards;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandards='" + roomStandards + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
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
                + this.getRoomStandards() + ","
                + this.getPoolArea() + ","
                + this.getNumberOfFloors();
    }
}
