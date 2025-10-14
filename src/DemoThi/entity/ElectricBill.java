package DemoThi.entity;

import java.time.LocalDate;

public class ElectricBill {
    private String invoiceId;
    private String customerId;
    private LocalDate invoiceDate;
    private double consumedKW;
    private double unitPrice;
    private double totalAmount;

    public ElectricBill() {
    }
    public ElectricBill(String customerId, LocalDate invoiceDate, double consumedKW, double unitPrice) {
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.consumedKW = consumedKW;
        this.unitPrice = unitPrice;
    }
    public ElectricBill(String customerId, LocalDate invoiceDate, double consumedKW, double unitPrice, double totalAmount) {
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.consumedKW = consumedKW;
        this.unitPrice = unitPrice;
        this.totalAmount = totalAmount;
    }

    public ElectricBill(String invoiceId, String customerId, LocalDate invoiceDate, double consumedKW, double unitPrice, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.consumedKW = consumedKW;
        this.unitPrice = unitPrice;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getConsumedKW() {
        return consumedKW;
    }

    public void setConsumedKW(double consumedKW) {
        this.consumedKW = consumedKW;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "ElectricBill{" +
                "invoiceId='" + invoiceId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", consumedKW=" + consumedKW +
                ", unitPrice=" + unitPrice +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public String toInForCSV() {
        return invoiceId + "," +
                customerId + "," +
                invoiceDate + "," +
                consumedKW + "," +
                unitPrice + "," +
                totalAmount
                ;
    }

}
