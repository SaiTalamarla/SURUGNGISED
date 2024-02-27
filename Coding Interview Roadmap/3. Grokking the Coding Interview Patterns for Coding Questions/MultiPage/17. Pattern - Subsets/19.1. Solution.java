import java.util.*;

// class TreeNode {
//   int val;
//   TreeNode left;
//   TreeNode right;

//   TreeNode(int x) {
//     val = x;
//   }
// };

class Solution {
  public int countTrees(int n) {
    if (n <= 1)
      return 1;
    int count = 0;
    for (int i = 1; i <= n; i++) {
      // making 'i' root of the tree
      int countOfLeftSubtrees = countTrees(i - 1);
      int countOfRightSubtrees = countTrees(n - i);
      count += (countOfLeftSubtrees * countOfRightSubtrees);
    }
    return count;
  }

  public static void main(String[] args) {
    Solution ct = new Solution();
    int count = ct.countTrees(3);
    System.out.print("Total trees: " + count);
  }
}
