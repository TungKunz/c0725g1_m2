package ss12_map_tree.bai_tap.binary_search_tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = {27, 14, 35, 10, 19, 31, 42};

        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }

        System.out.println("Duyệt Post-order:");
        tree.postOrder(tree.root);
        System.out.println("\nDuyệt Pre-order:");
        tree.preOrder(tree.root);
        System.out.println(tree.search(tree.root,10));
    }
}
