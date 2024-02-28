class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        data = value;
        left = null;
        right = null;
    }
}