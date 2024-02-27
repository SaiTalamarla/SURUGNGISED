import java.util.ArrayList;
import java.util.Stack;

class Graph {
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    public Graph(int V) {
        vertices = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For an undirected graph
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> s = new Stack<>();

        s.push(start);
        visited[start] = true;

        while (!s.isEmpty()) {
            int curr = s.pop();
            System.out.print(curr + " ");

            for (int neighbor : adjList.get(curr)) {
                if (!visited[neighbor]) {
                    s.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.print("DFS Traversal starting from vertex 0: ");
        g.DFS(0);
    }
}
