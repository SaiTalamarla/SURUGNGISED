public class BST<T extends Comparable<T>> {
    private Node<T> root;
    
    private void inOrderHelper(Node<T> p);
    private void preOrderHelper(Node<T> p);
    private void postOrderHelper(Node<T> p);
    private Node<T> findMin(Node<T> node);
    private Node<T> deleteNode(Node<T> root, T node);
    
    public BST();
    public void insert(T node);
    public void deleteMethod(T node);
    public boolean search(T node);
    public void inOrder();
    public void preOrder();
    public void postOrder();
}