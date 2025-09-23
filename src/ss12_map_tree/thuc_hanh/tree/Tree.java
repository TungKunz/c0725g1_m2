package ss12_map_tree.bai_tap.tree;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();
    int getSize();
}
