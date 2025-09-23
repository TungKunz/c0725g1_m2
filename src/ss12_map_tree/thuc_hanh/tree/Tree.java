package ss12_map_tree.thuc_hanh.tree;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();
    int getSize();
}
