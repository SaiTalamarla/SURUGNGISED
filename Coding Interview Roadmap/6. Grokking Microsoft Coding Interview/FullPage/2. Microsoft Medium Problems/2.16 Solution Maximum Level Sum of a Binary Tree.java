import java.util.LinkedList;
import java.util.Queue;

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; } // Constructor to create a new node
// }

public class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return -1; // Return -1 if tree is empty
        int maxSum = Integer.MIN_VALUE, maxLevel = 1, currentLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Start with the root node
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(), levelSum = 0;
            for (int i = 0; i < levelSize; i++) { // Process each level
                TreeNode node = queue.poll(); // Remove and get the current node
                levelSum += node.val; // Add its value to the level's sum
                if (node.left != null) queue.offer(node.left); // Add left child if exists
                if (node.right != null) queue.offer(node.right); // Add right child if exists
            }
            if (levelSum > maxSum) { // Check if current level has the max sum
                maxSum = levelSum;
                maxLevel = currentLevel;
            }
            currentLevel++; // Move to the next level
        }
        return maxLevel; // Return the level with maximum sum
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.maxLevelSum(root1)); // Output: 2

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(7);
        System.out.println(solution.maxLevelSum(root2)); // Output: 3

        // Example 3
        TreeNode root3 = new TreeNode(-10);
        root3.left = new TreeNode(20);
        root3.left.left = new TreeNode(15);
        root3.left.right = new TreeNode(25);
        System.out.println(solution.maxLevelSum(root3)); // Output: 3
    }
}
