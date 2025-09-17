package ss8_clean_code.bai_tap_lam_them_car.entity;

public class MotorbikeEntity extends VehicleEntity {
    private int power;

    public MotorbikeEntity() {
    }

    public MotorbikeEntity(String numberPlate, String manufacturerName, int manufactureYear, String owner, int power) {
        super(numberPlate, manufacturerName, manufactureYear, owner);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-15s | %-10d | %-15s | %-10d",
                getNumberPlate(), getManufacturerName(), getManufactureYear(), getOwner(),
                power);
    }
}
