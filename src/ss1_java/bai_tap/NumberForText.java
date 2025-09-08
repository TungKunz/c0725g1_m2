package ss1_java.bai_tap;

import java.util.Scanner;

public class NumberForText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen (0-999): ");
        int num = scanner.nextInt();

        if (num < 0 || num > 999) {
            System.out.println("Out of range!");
            return;
        }

        if (num == 0) {
            System.out.println("zero");
            return;
        }

        int hundreds = num / 100;
        int tens = (num / 10) % 10;
        int ones = num % 10;

        String result = "";

        if (hundreds > 0) {
            result += digitToWord(hundreds) + " hundred";
            if (tens > 0 || ones > 0) {
                result += " and ";
            }
        }

        if (tens == 1) {
            switch (ones) {
                case 0: result += "ten"; break;
                case 1: result += "eleven"; break;
                case 2: result += "twelve"; break;
                case 3: result += "thirteen"; break;
                case 4: result += "fourteen"; break;
                case 5: result += "fifteen"; break;
                case 6: result += "sixteen"; break;
                case 7: result += "seventeen"; break;
                case 8: result += "eighteen"; break;
                case 9: result += "nineteen"; break;
            }
        } else {
            switch (tens) {
                case 2: result += "twenty"; break;
                case 3: result += "thirty"; break;
                case 4: result += "forty"; break;
                case 5: result += "fifty"; break;
                case 6: result += "sixty"; break;
                case 7: result += "seventy"; break;
                case 8: result += "eighty"; break;
                case 9: result += "ninety"; break;
            }

            if (ones > 0) {
                if (tens > 1) result += " ";
                result += digitToWord(ones);
            }
        }

        System.out.println(result);
    }
    public static String digitToWord(int d) {
        return switch (d) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };
    }
}
