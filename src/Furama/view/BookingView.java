package Furama.view;

import Furama.entity.Booking;
import Furama.service.BookingService;
import Furama.service.IBookingService;
import Furama.validate.CheckBooking;
import Furama.validate.CheckFacility;
import Furama.validate.CheckPerson;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;

public class BookingView {
    private static final IBookingService bookingService= new BookingService();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Booking addNewBookingView() {
        System.out.println("\n--- Thêm mới Booking ---");

        System.out.print("Nhập mã Booking: ");
        String bookingId = scanner.nextLine().trim();

        LocalDate bookingDate = inputDate("Nhập ngày Booking (dd/MM/yyyy): ");
        LocalDate startDate = inputDate("Nhập ngày bắt đầu (dd/MM/yyyy): ");
        LocalDate endDate = inputDate("Nhập ngày kết thúc (dd/MM/yyyy): ");
        String customerId;
        while (true) {
            System.out.print("Nhập mã khách hàng (KH-YYYY): ");
            customerId = scanner.nextLine();
            if (CheckPerson.checkId("customer",customerId)) break;
            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
        }


        String serviceId;
        while (true) {
            System.out.print("Nhập mã dịch vụ: ");
            serviceId = scanner.nextLine().trim();
            if (CheckFacility.checkId("villa",serviceId)){
                break;
            }else if(CheckFacility.checkId("house",serviceId)){
                break;
            }else if(CheckFacility.checkId("room",serviceId)){
                break;
            }
            System.out.println("Mã không đúng định dạng. Thử lại!");
        }
        return new Booking(
                bookingId,
                bookingDate,
                startDate,
                endDate,
                customerId,
                serviceId
        );
    }

    private static LocalDate inputDate(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày không hợp lệ! Vui lòng nhập lại (dd/MM/yyyy).");
            }
        }
    }
    public static void displayAllBookings() {
        System.out.println("\n--- Danh sách Booking ---");
        Set<Booking> bookingList = bookingService.getAll();

        if (bookingList.isEmpty()) {
            System.out.println("⚠ Hiện chưa có booking nào!");
        } else {
            for (Booking b : bookingList) {
                System.out.println(b);
            }
        }
    }
    public static String inputCustomerId() {
        while (true) {
            System.out.print("Nhập mã khách hàng (KH-YYYY): ");
            String id = scanner.nextLine();
            if (CheckPerson.checkId("customer",id)) return id;
            System.out.println("Mã khách hàng không đúng định dạng. Thử lại!");
        }
    }

}
