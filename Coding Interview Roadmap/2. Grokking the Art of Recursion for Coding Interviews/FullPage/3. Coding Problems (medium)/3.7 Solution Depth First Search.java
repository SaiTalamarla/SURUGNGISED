import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    private void initializeGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    private void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    private void DFSExe(int startNode, Set<Integer> visited, List<Integer> depthFirstSearch) {
        visited.add(startNode);
        depthFirstSearch.add(startNode);

        for (int neighbor : adj.get(startNode)) {
            if (!visited.contains(neighbor)) {
                DFSExe(neighbor, visited, depthFirstSearch);
            }
        }
    }

    public List<Integer> DFS(List<List<Integer>> args, int n, int first) {
        initializeGraph(n);
        List<Integer> depthFirstSearch = new ArrayList<>();

        for (int i = 0; i < args.size(); i++) {
            List<Integer> num = args.get(i);
            addEdge(num.get(0), num.get(1));
        }

        DFSExe(first, new HashSet<>(), depthFirstSearch);
        return depthFirstSearch;
    }

    public static void main(String[] args) {
       // Example graph represented as a 2D List
        List<List<Integer>> graphEdges = new ArrayList<>();
        graphEdges.add(List.of(1, 2));
        graphEdges.add(List.of(1, 5));
        graphEdges.add(List.of(2, 4));
        graphEdges.add(List.of(4, 5));
        graphEdges.add(List.of(3, 5));

        Solution graph = new Solution();

        System.out.print("DFS traversal: ");
        List<Integer> result = graph.DFS(graphEdges, 6, 1);

        // Print the DFS result
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }
    }
}
