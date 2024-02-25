public void insert(T value) {
    Node<T> newNode = new Node<>(value);

    if (root == null) {
        root = newNode;
    } else {
        Node<T> current = root;
        Node<T> parent = null;

        while (current != null) {
            parent = current;
            if (value.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (value.compareTo(parent.data) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }
}
