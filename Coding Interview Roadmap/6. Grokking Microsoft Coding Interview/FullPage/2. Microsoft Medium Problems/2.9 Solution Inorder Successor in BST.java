// class TreeNode {
//     int val;
//     TreeNode left, right;
//     TreeNode(int x) { val = x; }
// }

public class Solution {
    public int inorderSuccessor(TreeNode root, int p) {
        TreeNode successor = null;
        while (root != null) {
            // If root value is greater than p, root could be a successor.
            if (p < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        // Return the value of the successor or -1 if it does not exist.
        return successor != null ? successor.val : -1;
    }

    public static void main(String[] args) {
        // Example of constructing a tree and finding an inorder successor
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);

        int p = 6; // The value to find the inorder successor of
        Solution solution = new Solution();
        System.out.println("Inorder Successor value: " + solution.inorderSuccessor(root, p));
    }
}
