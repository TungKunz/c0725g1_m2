package ss11_DSA_stack_queue.bai_tap.bracket_checker;

public class Main {
    public static void main(String[] args) {
        if(BracketChecker.isBalanced("s * s – a) * (s – b) * (s – c)")){
            System.out.println("OK");
        }else {
            System.out.println("Not OK");
        }
    }
}
