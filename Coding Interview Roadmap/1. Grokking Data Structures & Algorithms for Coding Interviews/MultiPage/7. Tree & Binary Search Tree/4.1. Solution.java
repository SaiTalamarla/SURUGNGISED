// Definition for a binary tree node.
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class Solution {

    // Method to compute the maximum depth of a binary tree
    public int maxDepth(TreeNode root) {
        // Base case: if node is null, return 0
        if (root == null) return 0;

        // Recursively calculate left subtree depth
        int leftDepth = maxDepth(root.left);
        
        // Recursively calculate right subtree depth
        int rightDepth = maxDepth(root.right);

        // Return the maximum of left and right subtree depth plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(solver.maxDepth(root1)); // Expected output: 3

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        System.out.println(solver.maxDepth(root2)); // Expected output: 3

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(7);
        root3.left.right.right = new TreeNode(9);
        System.out.println(solver.maxDepth(root3)); // Expected output: 4
    }
}
