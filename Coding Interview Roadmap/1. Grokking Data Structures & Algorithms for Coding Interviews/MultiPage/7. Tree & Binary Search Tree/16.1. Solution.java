// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }

public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // If one of the nodes is null, return the other node
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        // Create a new node with the sum of values of t1 and t2.
        TreeNode newNode = new TreeNode(t1.val + t2.val);

        // Recursive call for left and right children.
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);

        return newNode;    
    }

    public static void main(String[] args) {
        // Test the algorithm with given input
        Solution solution = new Solution();

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(5);

        TreeNode mergedTree = solution.mergeTrees(tree1, tree2);

        // Print the merged tree using inorder traversal
        printInOrder(mergedTree);
    }

    // Utility method to print tree using inorder traversal
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}
