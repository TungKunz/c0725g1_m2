package ss11_DSA_stack_queue.bai_tap.queue;

public class Solution {
    Queue q = new Queue();

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (q.front == null) {
            q.front = q.rear = temp;
        } else {
            q.rear.link = temp;
            q.rear = temp;
        }
        q.rear.link = q.front;
    }


    public void deQueue() {
        if (q.front == null) {
            System.out.println("Queue is empty");
            return;
        }
        if(q.front==q.rear){
            q.front=q.rear=null;
        }else {
            q.front= q.front.link;
            q.rear.link=q.front;
        }
    }

    public void displayQueue() {
        if (q.front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = q.front;
        System.out.print("Queue: ");
        while (temp.link != q.front) {
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
