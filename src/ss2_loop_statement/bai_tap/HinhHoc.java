package ss2_loop_statement.bai_tap;

import java.util.Scanner;

public class HinhHoc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte choice;
        do{
            System.out.println("Nhập lựa chọn mà bạn muốn");
            System.out.println("1. In hình chữ nhật");
            System.out.println("2. In hình tam giác");
            System.out.println("3. In hình vuông");
            System.out.println("4. Thoát");
            choice= Byte.parseByte(scanner.nextLine());
            if(choice >=1 &&choice <=3){
                switch (choice){
                    case 1:
                        for (int i = 1; i <= 4; i++) {
                            for (int j = 1; j <= 5; j++) {
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                        break;
                    case 2:
                        for (int i = 1; i <= 5; i++) {
                            for (int j = 1; j <=i ; j++) {
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                        break;
                    case 3:
                        for (int i = 1; i <= 4; i++) {
                            for (int j = 1; j <= 4; j++) {
                                System.out.print("*");
                            }
                            System.out.println();
                        }
                        break;
                }
            }
        }while (choice != 4);
    }
}
