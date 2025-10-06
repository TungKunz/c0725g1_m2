package Furama.entity.facility;

public class House extends Facility {
    private String roomStandards;
    private int numberOfFloors;
    public House(){}
    public House(String idFacility, String nameFacility, double areaFacility, long costFacility, int numberMemberMaxFacility, String rentalStyleFacility, String roomStandards, int numberOfFloors) {
        super(idFacility, nameFacility, areaFacility, costFacility, numberMemberMaxFacility, rentalStyleFacility);
        this.roomStandards = roomStandards;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String roomStandards, int numberOfFloors) {
        this.roomStandards = roomStandards;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "idFacility='" + getIdFacility() + '\'' +
                ", nameFacility='" + getNameFacility() + '\'' +
                ", areaFacility=" + getAreaFacility() +
                ", costFacility=" + getCostFacility() +
                ", numberMemberMaxFacility=" + getNumberMemberMaxFacility() +
                ", rentalStyleFacility='" + getRentalStyleFacility() + '\'' +
                ", roomStandards='" + roomStandards + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }

    @Override
    public String getInforToCSV() {
        return this.getIdFacility()+","+this.getNameFacility()+","+this.getAreaFacility()+","+this.getCostFacility()+","+this.getNumberMemberMaxFacility()+","+this.getRentalStyleFacility()+","+this.getRoomStandards()+","+this.getNumberOfFloors();
    }
}
