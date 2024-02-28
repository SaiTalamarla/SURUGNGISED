// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {}

//     TreeNode(int val) { this.val = val; }
// }

public class Solution {
    // Helper function to check if two trees are identical
    private boolean isMatch(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true; // Both trees are null
        if (s == null || t == null) return false; // One tree is null, and the other isn't
        if (s.val != t.val) return false; // Values at the nodes are different
        // Check left and right subtrees
        return isMatch(s.left, t.left) && isMatch(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false; // If tree s is null, t can't be its subtree
        // Check if tree rooted at current node matches t or if any subtree of s matches t
        return isMatch(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode s1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode t1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(sol.isSubtree(s1, t1));  // true

        TreeNode s2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(2, new TreeNode(3), null);
        System.out.println(sol.isSubtree(s2, t2));  // false

        TreeNode s3 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        TreeNode t3 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(sol.isSubtree(s3, t3));  // false
    }
}


