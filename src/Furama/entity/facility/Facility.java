package Furama.entity.facility;

public abstract class Facility {
    private int idFacility; //mã dịch vụ
    private String nameFacility; //tên dịch vụ
    private double areaFacility;
    private long costFacility;
    private int numberMemberMaxFacility;
    private String rentalStyleFacility;
    Facility(){}

    public Facility(int idFacility, String nameFacility, double areaFacility, long costFacility, int numberMemberMaxFacility, String rentalStyleFacility) {
        this.idFacility = idFacility;
        this.nameFacility = nameFacility;
        this.areaFacility = areaFacility;
        this.costFacility = costFacility;
        this.numberMemberMaxFacility = numberMemberMaxFacility;
        this.rentalStyleFacility = rentalStyleFacility;
    }

    public int getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(int idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public double getAreaFacility() {
        return areaFacility;
    }

    public void setAreaFacility(double areaFacility) {
        this.areaFacility = areaFacility;
    }

    public long getCostFacility() {
        return costFacility;
    }

    public void setCostFacility(long costFacility) {
        this.costFacility = costFacility;
    }

    public int getNumberMemberMaxFacility() {
        return numberMemberMaxFacility;
    }

    public void setNumberMemberMaxFacility(int numberMemberMaxFacility) {
        this.numberMemberMaxFacility = numberMemberMaxFacility;
    }

    public String getRentalStyleFacility() {
        return rentalStyleFacility;
    }

    public void setRentalStyleFacility(String rentalStyleFacility) {
        this.rentalStyleFacility = rentalStyleFacility;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idFacility=" + idFacility +
                ", nameFacility='" + nameFacility + '\'' +
                ", areaFacility=" + areaFacility +
                ", costFacility=" + costFacility +
                ", numberMemberMaxFacility=" + numberMemberMaxFacility +
                ", rentalStyleFacility='" + rentalStyleFacility + '\'' +
                '}';
    }
}
