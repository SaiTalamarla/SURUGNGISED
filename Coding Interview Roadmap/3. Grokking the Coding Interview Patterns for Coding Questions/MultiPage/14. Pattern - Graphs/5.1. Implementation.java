import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private int V; // Number of vertices
    private ArrayList<ArrayList<Integer>> adjList;

    public Graph(int vertices) {
        V = vertices;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V]; // To keep track of visited vertices
        Queue<Integer> q = new LinkedList<>();

        visited[startVertex] = true;
        q.add(startVertex);

        while (!q.isEmpty()) {
            int currentVertex = q.poll();
            System.out.print(currentVertex + " ");

            // Explore adjacent vertices
            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        System.out.println("Breadth-First Traversal starting from vertex 0:");
        graph.BFS(0);
    }
}
