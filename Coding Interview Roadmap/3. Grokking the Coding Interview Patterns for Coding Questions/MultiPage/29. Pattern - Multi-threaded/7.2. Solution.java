import java.util.Stack;

/** definition for a binary search tree node */
// class TreeNode {
//   int val;
//   TreeNode left;
//   TreeNode right;  
//   public TreeNode(int val) {
//     this.val = val;
//     this.left = null;
//     this.right = null;
//   }
// }

public class Solution {

  private Stack<TreeNode> stack = new Stack<TreeNode>();

  public Solution(TreeNode root) {
    traverseLeft(root);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  /** We only need to synchronize the following function.
  @return the next smallest number */
  synchronized public int next() {
    TreeNode tmpNode = stack.pop();
    traverseLeft(tmpNode.right);
    return tmpNode.val;
  }
  
  /** traverse the left sub-tree to push all nodes on the stack */
  private void traverseLeft(TreeNode node) {
    while(node != null){
      stack.push(node);
      node = node.left;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(1);
    root.right = new TreeNode(15);
    root.right.left = new TreeNode(14);
    root.right.right = new TreeNode(19);
    root.right.right.right = new TreeNode(20);

    Solution itr = new Solution(root);
    System.out.println("hasNext() -> " + itr.hasNext());
    System.out.println("next() -> " + itr.next());
    System.out.println("next() -> " + itr.next());
    System.out.println("hasNext() -> " + itr.hasNext());
    System.out.println("next() -> " + itr.next());
    System.out.println("next() -> " + itr.next());
    System.out.println("next() -> " + itr.next());
    System.out.println("next() -> " + itr.next());
    System.out.println("next() -> " + itr.next());
    System.out.println("hasNext() -> " + itr.hasNext());
  }
}