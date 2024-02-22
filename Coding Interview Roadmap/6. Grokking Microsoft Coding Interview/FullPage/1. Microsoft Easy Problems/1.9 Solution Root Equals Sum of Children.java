// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//     TreeNode(int x, TreeNode left, TreeNode right) {
//         this.val = x;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    // Method to check if root's value equals the sum of its children
    public boolean checkTree(TreeNode root) {
        // Check if the root's value is equal to the sum of its children's values
        return root.val == root.left.val + root.right.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode example1 = new TreeNode(10, new TreeNode(3), new TreeNode(7));
        System.out.println(solution.checkTree(example1)); // Expected: true

        // Corrected Example 2
        TreeNode example2 = new TreeNode(4, new TreeNode(1), new TreeNode(5));
        System.out.println(solution.checkTree(example2)); // Expected: false

        // Example 3
        TreeNode example3 = new TreeNode(15, new TreeNode(10), new TreeNode(5));
        System.out.println(solution.checkTree(example3)); // Expected: true
    }
}
