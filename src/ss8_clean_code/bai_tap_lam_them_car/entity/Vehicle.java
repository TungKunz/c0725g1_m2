package ss8_clean_code.bai_tap_lam_them_car.entity;

public abstract class Vehicle {

    private String numberPlate; //biển kiểm soát
    private String manufacturerName; //tên hãng
    private int manufactureYear; //năm sản xuất
    private String owner; //chủ sở hữu
    public Vehicle(){
    }
    public Vehicle(String numberPlate, String manufacturerName, int manufactureYear, String owner){
        this.numberPlate=numberPlate;
        this.manufacturerName=manufacturerName;
        this.manufactureYear=manufactureYear;
        this.owner=owner;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-15s | %-10d | %-15s",
                numberPlate, manufacturerName, manufactureYear, owner);
    }

}
