package ss8_clean_code.bai_tap_lam_them_car.entity;

public class Car extends Vehicle {
    private int numberOfSeats;
    private String carType;
    public Car(){}
    public Car(String numberPlate, String manufacturerName, int manufactureYear, String owner, int numberOfSeats, String carType){
        super(numberPlate,manufacturerName,manufactureYear,owner);
        this.numberOfSeats=numberOfSeats;
        this.carType=carType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-15s | %-10d | %-15s | %-5d | %-10s",
                getNumberPlate(), getManufacturerName(), getManufactureYear(), getOwner(),
                numberOfSeats, carType);
    }

    @Override
    public String getInforToCSV() {
        return this.getNumberPlate() +","+this.getManufacturerName()+","+this.getManufactureYear()+","+this.getOwner()+","+this.getNumberOfSeats()+","+this.getCarType();
    }

}
