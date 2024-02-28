private Node<T> findMin(Node<T> node) {
    if (node.left == null) {
        return node;
    }
    return findMin(node.left);
}

private Node<T> deleteNode(Node<T> root, T value) {
    if (root == null) {
        return root;
    }

    if (value.compareTo(root.data) < 0) {
        root.left = deleteNode(root.left, value);
    } else if (value.compareTo(root.data) > 0) {
        root.right = deleteNode(root.right, value);
    } else {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        Node<T> temp = findMin(root.right);
        root.data = temp.data;
        root.right = deleteNode(root.right, temp.data);
    }
    return root;
}

public void deleteMethod(T value) {
    root = deleteNode(root, value);
}