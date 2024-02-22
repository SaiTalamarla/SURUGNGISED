import java.util.LinkedList;
import java.util.Queue;

// class TreeNode {
//     int val;
//     TreeNode left, right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Find the node to be deleted and its parent.
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null && cur.val != key) {
            parent = cur;
            if (key < cur.val) cur = cur.left;
            else cur = cur.right;
        }
        if (cur == null) return root; // Key not found.

        // Node to be deleted is found and has two children.
        if (cur.left != null && cur.right != null) {
            // Find the in-order successor and its parent.
            TreeNode succParent = cur;
            TreeNode succ = cur.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            cur.val = succ.val; // Replace cur value with successor's value.
            cur = succ; // Move to successor.
            parent = succParent;
        }

        // Node to be deleted has one child or no child.
        TreeNode child = (cur.left != null) ? cur.left : cur.right;
        if (parent == null) {
            root = child; // The root is being deleted.
        } else if (parent.left == cur) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 2
        TreeNode root2 = new TreeNode(20);
        root2.left = new TreeNode(10);
        root2.right = new TreeNode(30);
        root2.left.right = new TreeNode(15);
        root2.right.left = new TreeNode(25);
        root2.right.right = new TreeNode(35);

        root2 = solution.deleteNode(root2, 10);
        printTree(root2);
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
}
