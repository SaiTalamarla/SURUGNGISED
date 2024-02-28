import java.util.*;

public class Solution {
      // Definition for a binary tree node.
//    public static class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) { val = x; }
//     TreeNode(int x, TreeNode left, TreeNode right) {  // Overloaded constructor
//         this.val = x;
//         this.left = left;
//         this.right = right;
//     }
// }
    // Encodes a tree to a single string using a pre-order traversal.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        // If the current node is null, append "X" to the result string.
        if(node == null) {
            sb.append("X,");
        } else {
            // Append the node value and then serialize left and right subtrees.
            sb.append(node.val + ",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    private TreeNode deserializeHelper(Queue<String> queue) {
        // Extract the value from the queue.
        String val = queue.poll();
        if(val.equals("X")) return null;
        // Create a node and then recursively deserialize left and right children.
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    
public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode testTree = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
    String serialized = solution.serialize(testTree);
    TreeNode deserialized = solution.deserialize(serialized);
    System.out.println("Serialized: " + serialized);
    System.out.println("Deserialized (Serialized again for verification): " + solution.serialize(deserialized));
}

}
