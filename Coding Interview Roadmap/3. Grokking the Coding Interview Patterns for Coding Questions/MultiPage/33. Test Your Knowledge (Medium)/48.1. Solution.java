import java.util.*;

public class Solution {
    
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    
    public boolean validTree(int n, int[][] edges) {
        // Building the adjacency list for the graph
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // Checking for cycle
        if (hasCycle(-1, 0)) {
            return false;
        }

        // Checking for connectivity
        return visited.size() == n;
    }

    private boolean hasCycle(int parent, int node) {
        visited.add(node);
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (neighbor == parent) continue;
            if (visited.contains(neighbor) || hasCycle(node, neighbor)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}}));  // true
        System.out.println(sol.validTree(4, new int[][]{{0,1},{1,2},{2,3},{3,0}}));  // false
        System.out.println(sol.validTree(5, new int[][]{{0,1},{1,2},{2,3}}));       // false
    }
}
