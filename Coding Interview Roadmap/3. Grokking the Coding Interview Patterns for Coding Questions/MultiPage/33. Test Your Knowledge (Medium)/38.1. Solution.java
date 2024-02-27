// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

class Solution {
    // Main function to determine LCA
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // Iterate until the LCA is found
        while (root != null) {
            if (p < root.val && q < root.val) {
                root = root.left;  // Both nodes are on the left
            } else if (p > root.val && q > root.val) {
                root = root.right;  // Both nodes are on the right
            } else {
                return root.val;  // One node is on the left and the other is on the right, so we found the LCA
            }
        }
        return -1;  // Just in case, though we should always find an LCA in a valid input
    }

    public static void main(String[] args) {
        // Creating the example tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        Solution solution = new Solution();
        // Testing the solution on the provided examples
        System.out.println(solution.lowestCommonAncestor(root, 2, 8));  // expected: 6
        System.out.println(solution.lowestCommonAncestor(root, 0, 3));  // expected: 2
        System.out.println(solution.lowestCommonAncestor(root, 4, 5));  // expected: 4
    }
}
