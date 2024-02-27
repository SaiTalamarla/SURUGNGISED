import java.util.ArrayList;
import java.util.HashMap;

class Graph {
    private HashMap<Integer, ArrayList<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex);
    // Add a new vertex to the graph.

    public void removeVertex(int vertex);
    // Remove a vertex from the graph.

    public void addEdge(int vertex1, int vertex2);
    // Add an edge between two vertices.

    public void removeEdge(int vertex1, int vertex2);
    // Remove an edge between two vertices.

    public ArrayList<Integer> getVertices();
    // Get a list of all vertices.

    public boolean isAdjacent(int vertex1, int vertex2);
    // Check if two vertices are adjacent.

    public int getVertexCount();
    // Get the total number of vertices.

    public int getEdgeCount();
    // Get the total number of edges.

    public ArrayList<Pair<Integer, Integer>> getEdges();
    // Get a list of all edges.

    public ArrayList<Integer> getNeighbors(int vertex);
    // Get a list of neighbors of a given vertex.
}