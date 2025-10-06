package Furama.entity.facility;

import java.util.Objects;

public abstract class Facility {
    private String idFacility; //mã dịch vụ
    private String nameFacility; //tên dịch vụ
    private double areaFacility;
    private long costFacility;
    private int numberMemberMaxFacility;
    private String rentalStyleFacility;
    public Facility(){}

    public Facility(String idFacility, String nameFacility, double areaFacility, long costFacility, int numberMemberMaxFacility, String rentalStyleFacility) {
        this.idFacility = idFacility;
        this.nameFacility = nameFacility;
        this.areaFacility = areaFacility;
        this.costFacility = costFacility;
        this.numberMemberMaxFacility = numberMemberMaxFacility;
        this.rentalStyleFacility = rentalStyleFacility;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
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
    public abstract String getInforToCSV();

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Facility facility = (Facility) object;
        return Objects.equals(idFacility, facility.idFacility);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idFacility);
    }
}
