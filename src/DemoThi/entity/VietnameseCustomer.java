package DemoThi.entity;

public class VietnameseCustomer extends Person {
    private String customerType;
    private int consumptionLimit;

    public VietnameseCustomer() {
    }

    public VietnameseCustomer(String customId, String fullName, String customerType, int consumptionLimit) {
        super(customId, fullName);
        this.customerType = customerType;
        this.consumptionLimit = consumptionLimit;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getConsumptionLimit() {
        return consumptionLimit;
    }

    public void setConsumptionLimit(int consumptionLimit) {
        this.consumptionLimit = consumptionLimit;
    }

    @Override
    public String toString() {
        return "VietnameseCustomer " + super.toString() +","+
                " customerType = " + customerType + '\'' +
                ", consumptionLimit = " + consumptionLimit;
    }

    @Override
    public double calculateTotalAmount(double consumedKW, double unitPrice) {
        if (consumedKW <= this.getConsumptionLimit()) {
            return consumedKW * unitPrice;
        } else {
            return this.getConsumptionLimit() * unitPrice
                    + (consumedKW - this.getConsumptionLimit()) * unitPrice * 2.5;
        }
    }

    @Override
    public String toInForCSV() {
        return super.getCustomId() + "," +
                super.getFullName() + "," +
                this.getCustomerType() + "," +
                this.getConsumptionLimit();
    }
}
