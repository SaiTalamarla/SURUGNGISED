import java.util.ArrayList;
import java.util.List;

// TreeNode class to represent the Binary Search Tree nodes.
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
// }

public class Solution {
    // Using a List to hold the values in order.
    private List<Integer> nodes = new ArrayList<>();
    
    public int minDiffInBST(TreeNode root) {
        
        nodes.clear(); // make sure nodes is empty
        
        // First, perform the in-order traversal.
        inorderTraversal(root);
        
        // Initialize the minimum difference to the largest possible value.
        int minDiff = Integer.MAX_VALUE;
        
        // Loop through the list and find the difference between each consecutive pair.
        for (int i = 1; i < nodes.size(); i++) {
            minDiff = Math.min(minDiff, nodes.get(i) - nodes.get(i - 1));
        }
        
        return minDiff;
    }
    
    
    // Helper method to perform the in-order traversal.
    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);  // Recursively visit the left subtree.
        nodes.add(node.val);          // Add the current node's value.
        inorderTraversal(node.right); // Recursively visit the right subtree.
    }

    public static void main(String[] args) {
        // First test case
        TreeNode example1 = new TreeNode(4);
        example1.left = new TreeNode(2);
        example1.left.left = new TreeNode(1);
        example1.left.right = new TreeNode(3);
        example1.right = new TreeNode(6);
        
        // Second test case
        TreeNode example2 = new TreeNode(40);
        example2.right = new TreeNode(70);
        example2.right.left = new TreeNode(50);
        example2.right.right = new TreeNode(90);
        
        Solution solution = new Solution();

        System.out.println(solution.minDiffInBST(example1)); // Expected output: 1
        System.out.println(solution.minDiffInBST(example2)); // Expected output: 10 (40-50)
    }
}
