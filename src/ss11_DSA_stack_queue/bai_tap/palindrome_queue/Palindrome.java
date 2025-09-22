package ss11_DSA_stack_queue.bai_tap.palindrome_queue;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void palindromeQueue(String s){
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char word=s.charAt(i);
            stack.push(word);
            queue.add(word);
        }
        boolean isPalindrome = true;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(s + " là Palindrome");
        } else {
            System.out.println(s + " không phải Palindrome");
        }
    }
}
