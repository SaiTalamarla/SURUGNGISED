// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int val) {
//         this.val = val;
//     }
// }

public class Solution {
    public static TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode[] {null, null}; // Base case: empty subtree
        }

        if (root.val <= target) {
            TreeNode[] rightSplit = splitBST(root.right, target); // Split right subtree recursively
            root.right = rightSplit[0]; // Connect the resulting right subtree to the current node's right
            return new TreeNode[] {root, rightSplit[1]}; // Return root and right subtree
        } else {
            TreeNode[] leftSplit = splitBST(root.left, target); // Split left subtree recursively
            root.left = leftSplit[1]; // Connect the resulting left subtree to the current node's left
            return new TreeNode[] {leftSplit[0], root}; // Return left subtree and root
        }
    }

    public static void main(String[] args) {
        // Example inputs
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(7);
        int target1 = 5;

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);
        int target2 = 4;

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);
        int target3 = 1;

        // Split BSTs
        TreeNode[] split1 = splitBST(root1, target1);
        TreeNode[] split2 = splitBST(root2, target2);
        TreeNode[] split3 = splitBST(root3, target3);

        // Print results
        System.out.println("Split BST 1: " + printBST(split1[0]) + ", " + printBST(split1[1]));
        System.out.println("Split BST 2: " + printBST(split2[0]) + ", " + printBST(split2[1]));
        System.out.println("Split BST 3: " + printBST(split3[0]) + ", " + printBST(split3[1]));
    }

    // Helper method to print the BST
    public static String printBST(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = printBST(root.left);
        String right = printBST(root.right);
        return left + " " + root.val + " " + right;
    }
}
