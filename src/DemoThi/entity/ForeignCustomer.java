package DemoThi.entity;

public class ForeignCustomer extends Person {
    private String nationality;

    public ForeignCustomer() {
    }

    public ForeignCustomer(String customId, String fullName, String nationality) {
        super(customId, fullName);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "ForeignCustomer{" + super.toString() +","+
                " nationality= " + nationality + '\'' +
                '}';
    }

    @Override
    public double calculateTotalAmount(double consumedKW, double unitPrice) {
        return consumedKW * unitPrice;
    }

    @Override
    public String toInForCSV() {
        return super.getCustomId() + "," +
                super.getFullName() + "," +
                this.getNationality();
    }
}
