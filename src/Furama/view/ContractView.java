package Furama.view;

import Furama.entity.Contract;

import java.util.List;
import java.util.Scanner;

public class ContractView {
    private static final Scanner scanner = new Scanner(System.in);
    public static Contract inputContract() {
        System.out.print("Nhập mã hợp đồng: ");
        String contractId = scanner.nextLine();

        System.out.print("Nhập số tiền đặt cọc: ");
        double deposit = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập tổng tiền: ");
        double totalPayment = Double.parseDouble(scanner.nextLine());
        return new Contract(contractId, deposit, totalPayment);
    }
    public static void displayContract(Contract contract) {
        System.out.println("----- Thông tin hợp đồng -----");
        System.out.println("Mã hợp đồng: " + contract.getContractId());
        System.out.println("Mã booking: " + contract.getBookingId());
        System.out.println("Số tiền đặt cọc: " + contract.getDeposit());
        System.out.println("Tổng thanh toán: " + contract.getTotalPayment());
        System.out.println("------------------------------");
    }
    public static void displayContractList(List<Contract> contractList) {
        System.out.println("===== Danh sách hợp đồng =====");
        for (Contract c : contractList) {
            displayContract(c);
        }
        System.out.println("==============================");
    }
}
