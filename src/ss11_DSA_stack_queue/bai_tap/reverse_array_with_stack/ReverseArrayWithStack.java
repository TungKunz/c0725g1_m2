package ss11_DSA_stack_queue.bai_tap.reverse_array_with_stack;

import java.util.Stack;

public class ReverseArrayWithStack {
    public static void ReverseArray(){
        int[] arr={1,2,3,4,5,6,7};
        Stack<Integer> stack=new Stack<>();
        for (int j : arr) {
            stack.push(j);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    public static void ReverseString(){
        String input = "Hello world from Java";

        Stack<String> stack = new Stack<>();

        String[] words = input.split(" ");
        for (String word : words) {
            stack.push(word);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop()).append(" ");
        }
        String output = reversed.toString().trim();
        System.out.println(output);
    }
}
