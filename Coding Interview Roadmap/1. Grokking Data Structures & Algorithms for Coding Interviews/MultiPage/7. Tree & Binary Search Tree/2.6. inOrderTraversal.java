private void inOrderHelper(Node<T> node) {
    if (node != null) {
        inOrderHelper(node.left);
        System.out.print(node.data + " ");
        inOrderHelper(node.right);
    }
}

public void inOrder() {
    inOrderHelper(root);
    System.out.println();
}