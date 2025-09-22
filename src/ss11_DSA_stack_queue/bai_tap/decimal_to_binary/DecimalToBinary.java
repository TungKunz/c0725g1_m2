package ss11_DSA_stack_queue.bai_tap.decimal_to_binary;

import java.util.Stack;

public class DecimalToBinary {
    public static void decimalToBinary(int number){
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while (number>0){
            stack.push(number%2);
            number=number/2;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
