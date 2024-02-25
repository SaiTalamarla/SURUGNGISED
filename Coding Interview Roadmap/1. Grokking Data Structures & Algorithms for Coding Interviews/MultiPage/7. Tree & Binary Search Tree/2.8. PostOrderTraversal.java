private void postOrderHelper(Node<T> node) {
    if (node != null) {
        postOrderHelper(node.left);
        postOrderHelper(node.right);
        System.out.print(node.data + " ");
    }
}

public void postOrder() {
    postOrderHelper(root);
    System.out.println();
}