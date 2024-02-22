import java.util.*;

// TreeNode class definition
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }

//     TreeNode(int x, TreeNode left, TreeNode right) {
//         val = x;
//         this.left = left;
//         this.right = right;
//     }
// }

// Pair class to associate a node with its column index
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        int minColumn = 0, maxColumn = 0;

        // Start BFS with the root node
        queue.offer(new Pair<>(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                // If this column has not been seen before, create a new List
                columnTable.putIfAbsent(column, new ArrayList<>());
                // Add the node's value to the column's list
                columnTable.get(column).add(root.val);
                // Update the min and max column indices
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);

                // Enqueue child nodes with their respective column indices
                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }

        // Construct the final list by combining lists from each column
        for(int i = minColumn; i <= maxColumn; i++) {
            result.add(columnTable.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        // Example 1
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(solution.verticalOrder(root1));

        // Example 2
        TreeNode root2 = new TreeNode(3, new TreeNode(9, new TreeNode(4), new TreeNode(0)), new TreeNode(8, new TreeNode(1), new TreeNode(7)));
        System.out.println(solution.verticalOrder(root2));

        // Example 3
        TreeNode root3 = new TreeNode(3, null, new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.verticalOrder(root3));
    }
}
