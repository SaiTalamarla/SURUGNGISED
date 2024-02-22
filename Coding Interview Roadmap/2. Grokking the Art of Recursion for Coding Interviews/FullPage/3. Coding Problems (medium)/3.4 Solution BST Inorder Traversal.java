import java.util.*;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int val) {
//         this.val = val;
//     }
// }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return; // Base case: reached the end of the subtree
        }

        inorder(node.left, result); // Recursively traverse the left subtree
        result.add(node.val); // Visit the current node
        inorder(node.right, result); // Recursively traverse the right subtree
    }

    public static void main(String[] args) {
        // Example inputs
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution inorderTraversal = new Solution();
        List<Integer> result = inorderTraversal.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}
