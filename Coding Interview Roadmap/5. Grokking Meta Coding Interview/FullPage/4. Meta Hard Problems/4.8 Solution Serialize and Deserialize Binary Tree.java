import java.util.*;

public class Solution {
    // Definition for a binary tree node.
    // public static class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //     TreeNode(int x) { val = x; }
    // }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return ""; // Handle empty tree
        StringBuilder sb = new StringBuilder(); // StringBuilder for efficient string concatenation
        Queue<TreeNode> queue = new LinkedList<>(); // Queue to hold nodes for BFS
        queue.offer(root); // Start with root node
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Remove the next node from the queue
            if (node != null) {
                sb.append(node.val).append(","); // Append node value
                queue.offer(node.left); // Add left child to queue
                queue.offer(node.right); // Add right child to queue
            } else {
                sb.append("null,"); // Handle null children
            }
        }
        return sb.toString(); // Return the serialized string
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null; // Handle empty input
        String[] values = data.split(","); // Split string into values
        TreeNode root = new TreeNode(Integer.parseInt(values[0])); // Create root node
        Queue<TreeNode> queue = new LinkedList<>(); // Queue to manage nodes
        queue.offer(root); // Add root to the queue
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll(); // Get next node to add children
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i])); // Create left child
                parent.left = left; // Link left child
                queue.offer(left); // Add left child to queue
            }
            if (++i < values.length && !values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i])); // Create right child
                parent.right = right; // Link right child
                queue.offer(right); // Add right child to queue
            }
        }
        return root; // Return the root of the deserialized tree
    }

    // Method to print the binary tree
    public static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of elements at the current level
            boolean isLastLevel = true;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (curr != null) {
                    // Print the value of the current node
                    System.out.print(curr.val + " ");
                    queue.add(curr.left);
                    queue.add(curr.right);
                    // If any of the children is not null, this is not the last level
                    if (curr.left != null || curr.right != null) {
                        isLastLevel = false;
                    }
                } else {
                    System.out.print("null ");
                }
            }
            // After finishing a level, if it's the last level, break out of the loop
            if (isLastLevel) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Testing with provided examples
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);
        String serialized1 = solution.serialize(root1);
        TreeNode deserialized1 = solution.deserialize(serialized1);

        System.out.println("Example 1 Tree:");
        solution.printTree(deserialized1);
    }
}
