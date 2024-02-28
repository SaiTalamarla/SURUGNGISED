public boolean search(T value) {
    Node<T> current = root;
    while (current != null) {
        if (value.compareTo(current.data) == 0) {
            return true;
        } else if (value.compareTo(current.data) < 0) {
            current = current.left;
        } else {
            current = current.right;
        }
    }
    return false;
}
