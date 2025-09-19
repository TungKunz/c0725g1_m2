package ss10_dsa_list.bai_tap.linked_list;


public class MyLinkedList <E>{
    private Node head;
    private int numNodes;
    private class Node{
        private Node next;
        private E data;
        public Node(E data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void addFirst(E e){
        Node temp= head;
        head= new Node(e);
        head.next=temp;
        numNodes++;
    }
    public void addLast(E e){
        Node newNode= new Node(e);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tail=head;
        while (tail.next!=null){
            tail=tail.next;
        }
        tail.next=newNode;
        numNodes++;
    }
    public boolean add(E e, int index){
        if(index < 0 || index > numNodes){
            throw new IllegalArgumentException("index " + index);
        }
        Node insert = new Node(e);
        if(index == 0){
            addFirst(e);
        } else {
            Node temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            insert.next = temp.next;
            temp.next = insert;
        }
        numNodes++;
        return true;
    }
    public E removeNode(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IllegalArgumentException("index " + index);
        }

        Node removedNode;

        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            removedNode = temp.next;
            temp.next = temp.next.next;
        }

        removedNode.next = null;
        numNodes--;
        return (E) removedNode;
    }
    public boolean remove(E e){
        if (head == null) return false;
        if (head.data.equals(e)) {
            head = head.next;
            return true;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.data.equals(e)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            return false;
        } else {
            temp.next = temp.next.next;
            return true;
        }

    }
    public E getFirst(){
        if (head == null) return null;
        return (E) head.data;
    }

    public E getLast(){
        if (head == null) return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }
    public E getIndex(int index){
        if (index < 0 || index >= numNodes) {
            throw new IllegalArgumentException("index " + index);
        }
        if(index==0){
            return (E) head.data;
        }
        Node temp=head;
        int numberIndex=0;
        while (numberIndex<index){
            temp=temp.next;
            numberIndex++;
        }
        return (E) temp.next.data;
    }
}
