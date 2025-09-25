package ss11_DSA_stack_queue.bai_tap.queue;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.enQueue(10);
        s.enQueue(20);
        s.enQueue(30);
        s.displayQueue();
        s.deQueue();
        s.displayQueue();
        s.deQueue();
        s.displayQueue();
        s.deQueue();
        s.displayQueue();
    }
}
