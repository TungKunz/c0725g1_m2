package ss8_clean_code.bai_tap_lam_them_car.entity;

public class Truck extends Vehicle {
    private int loadCapacity;

    public Truck() {
    }

    public Truck(String numberPlate, String manufacturerName, int manufactureYear, String owner, int loadCapacity) {
        super(numberPlate, manufacturerName, manufactureYear, owner);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-15s | %-10d | %-15s | %-10d",
                getNumberPlate(), getManufacturerName(), getManufactureYear(), getOwner(),
                loadCapacity);
    }

    @Override
    public String getInforToCSV() {
        return this.getNumberPlate() +","+this.getManufacturerName()+","+this.getManufactureYear()+","+this.getOwner()+","+this.getLoadCapacity();
    }

}
