package ss12_map_tree.bai_tap.binary_search_tree;


public class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    Node root;
    Node insert(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        if(data < root.data){
            root.left=insert(root.left,data);
        }else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);

    }
    boolean search(Node root, int element){
        Node current=root;
        while (current!=null){
            if(element < current.data){
                current=current.left;
            }else if(element> current.data){
                current=current.right;
            }else {
                return true;
            }
        }
        return false;
    }
}
