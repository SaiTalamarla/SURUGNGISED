// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int val) {
//         this.val = val;
//     }
// }

public class Solution {
    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            // Base case: create a new node with the given value
            return new TreeNode(value);
        }

        if (value < root.val) {
            // Recursive case: insert into the left subtree
            root.left = insert(root.left, value);
        } else if (value > root.val) {
            // Recursive case: insert into the right subtree
            root.right = insert(root.right, value);
        }

        // Return the modified BST
        return root;
    }

    public static void main(String[] args) {
        // Example inputs
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int[] values = { 5, 4, 2 };

        Solution bstInsertion = new Solution();

        // Insert nodes into the BST
        for (int value : values) {
            root = bstInsertion.insert(root, value);
        }

        // Print the updated BST
        System.out.println("BST After Insertion:");
        printBST(root);
    }

    private static void printBST(TreeNode node) {
        if (node == null) {
            return;
        }

        printBST(node.left);
        System.out.print(node.val + " ");
        printBST(node.right);
    }
}
