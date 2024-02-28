public class Solution {
    private int[] parents;

    // Helper function to find the leader/parent of a node
    private int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);  // Path compression
        }
        return parents[x];
    }

    public int countComponents(int n, int[][] edges) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;  // Initially, each node is its own parent
        }

        for (int[] edge : edges) {
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            if (root1 != root2) {
                parents[root1] = root2;  // Union operation
                n--;  // Decrease the component count
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countComponents(4, new int[][]{{0,1},{2,3}}));  //Expected 2
        System.out.println(sol.countComponents(5, new int[][]{{0,1},{1,2},{2,0}}));  //Expected 3
        System.out.println(sol.countComponents(3, new int[][]{}));  //Expected 3
    }
}
