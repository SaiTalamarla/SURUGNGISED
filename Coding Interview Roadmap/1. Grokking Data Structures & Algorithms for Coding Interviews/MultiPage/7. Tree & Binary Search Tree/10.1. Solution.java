// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;  // Base case

        // If the current node's value is out of the range on the higher side
        if (root.val > R) return rangeSumBST(root.left, L, R);
        
        // If the current node's value is out of the range on the lower side
        if (root.val < L) return rangeSumBST(root.right, L, R);
        
        // Current node's value is in the range, include it and check both children
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public static void main(String[] args) {
        // Test using the examples provided
        TreeNode example1 = new TreeNode(10);
        example1.left = new TreeNode(5);
        example1.left.left = new TreeNode(3);
        example1.left.right = new TreeNode(7);
        example1.right = new TreeNode(15);
        example1.right.right = new TreeNode(18);

        Solution solution = new Solution();
        System.out.println(solution.rangeSumBST(example1, 7, 15));  // Expected output: 32
    }
}
