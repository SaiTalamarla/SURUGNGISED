private void preOrderHelper(Node<T> node) {
    if (node != null) {
        System.out.print(node.data + " ");
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }
}

public void preOrder() {
    preOrderHelper(root);
    System.out.println();
}