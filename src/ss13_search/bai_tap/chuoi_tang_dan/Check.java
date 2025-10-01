package ss13_search.bai_tap.chuoi_tang_dan;

import java.util.LinkedList;
import java.util.Scanner;

public class Check {
    public static void checkString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi vào");
        String str= scanner.nextLine();
        LinkedList<Character> linkedList= new LinkedList<>();
        LinkedList<Character> max= new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if(linkedList.size()>1 &&  str.charAt(i) <= linkedList.getLast()){
                linkedList.clear();
            }
            linkedList.add(str.charAt(i));
            if(linkedList.size()>max.size()){
                max.clear();
                max.addAll(linkedList);
            }
        }
        for (Character character:max){
            System.out.print(character);
        }
    }
}
