package Furama.entity;

import Furama.entity.facility.Facility;

public class Maintenance {
    private String maintenanceId;
    private Facility facilityId;
    private int checkCount;
    private String maintenanceDate;
    Maintenance(){}
    public Maintenance(String maintenanceId, Facility facilityId, int checkCount, String maintenanceDate) {
        this.maintenanceId = maintenanceId;
        this.facilityId = facilityId;
        this.checkCount = checkCount;
        this.maintenanceDate = maintenanceDate;
    }

    public String getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(String maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public Facility getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Facility facilityId) {
        this.facilityId = facilityId;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(int checkCount) {
        this.checkCount = checkCount;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "maintenanceId='" + maintenanceId + '\'' +
                ", facilityId=" + facilityId +
                ", checkCount=" + checkCount +
                ", maintenanceDate='" + maintenanceDate + '\'' +
                '}';
    }
}
