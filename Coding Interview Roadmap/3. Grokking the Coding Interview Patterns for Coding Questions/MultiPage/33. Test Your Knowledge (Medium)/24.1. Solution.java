// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class Solution {
    // Main method to check if a tree is a BST
    public boolean isValidBST(TreeNode root) {
        // Initially, the range is set to the largest and smallest possible values
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper method that checks the node value against a range
    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        // Null nodes are always BST
        if (node == null) return true;

        // Node value should be strictly within the min and max
        if (node.val <= min || node.val >= max) return false;

        // Recursively check left (with updated max) and right (with updated min)
        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }

    // Test the solution with the examples
    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode example1 = new TreeNode(5);
        example1.left = new TreeNode(3);
        example1.right = new TreeNode(7);
        System.out.println(sol.isValidBST(example1));  // true

        TreeNode example2 = new TreeNode(5);
        example2.left = new TreeNode(7);
        example2.right = new TreeNode(3);
        System.out.println(sol.isValidBST(example2));  // false

        TreeNode example3 = new TreeNode(10);
        example3.left = new TreeNode(5);
        example3.right = new TreeNode(15);
        example3.right.left = new TreeNode(12);
        example3.right.right = new TreeNode(20);
        System.out.println(sol.isValidBST(example3));  // false
    }
}
