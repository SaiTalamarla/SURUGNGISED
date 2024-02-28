import java.util.*;

public class Solution {
    private boolean[] visited; // To keep track of visited nodes

    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize the graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Populate the graph from edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Because it's an undirected graph
        }
        
        visited = new boolean[n];
        return dfs(graph, start, end);
    }

    private boolean dfs(List<List<Integer>> graph, int node, int end) {
        if (node == end) return true; // Found the path
        visited[node] = true;
        
        // Traverse neighbors
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor] && dfs(graph, neighbor, end)) {
                return true;
            }
        }
        return false; // Path not found
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validPath(4, new int[][]{{0,1},{1,2},{2,3}}, 0, 3)); // true
        System.out.println(sol.validPath(4, new int[][]{{0,1},{2,3}}, 0, 3));     // false
        System.out.println(sol.validPath(5, new int[][]{{0,1},{3,4}}, 0, 4));     // false
    }
}
