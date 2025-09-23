package ss11_DSA_stack_queue.bai_tap.bracket_checker;

import java.util.Stack;

public class BracketChecker {
    public static boolean isBalanced(String str){
        Stack<Character> bStack = new Stack<>();
        for (char sym: str.toCharArray()) {
            if (sym == '(' || sym == '[' || sym == '{') {
                bStack.push(sym);
            } else if (sym == ')' || sym == ']' || sym == '}') {
                if (bStack.isEmpty()) {
                    return false;
                }
                char left = bStack.pop();
                if (!isMatchingPair(left, sym)) {
                    return false;
                }
            }
        }
        return bStack.isEmpty();
    }
    private static boolean isMatchingPair(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}');
    }
}
