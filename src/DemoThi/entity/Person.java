package DemoThi.entity;

public abstract class Person {
    private String customId;
    private String fullName;

    public Person() {}
    public Person(String customId, String fullName) {
        this.customId = customId;
        this.fullName = fullName;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "fullName='" + fullName;
    }
    public abstract double calculateTotalAmount(double consumedKW, double unitPrice);
    public abstract String toInForCSV();
}
