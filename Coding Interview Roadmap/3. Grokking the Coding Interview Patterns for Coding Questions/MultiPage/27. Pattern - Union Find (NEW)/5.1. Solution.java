public class Solution {
    private int[] parent; // Array to store the root of each node.

    // Function to find the province count.
    public int findProvinces(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        
        // Initialize the parent array, initially each node is its own parent.
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int provinces = n; // Start with each node being a separate province.
        
        // Iterate through the matrix to check connections.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if nodes i and j are connected and belong to different provinces.
                if (isConnected[i][j] == 1 && find(i) != find(j)) {
                    union(i, j); // Union nodes i and j.
                    provinces--; // Decrease the count of provinces.
                }
            }
        }
        return provinces; // Return the final count of provinces.
    }

    // Function to find the root of a node.
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Apply path compression.
        }
        return parent[i];
    }

    // Function to union two sets.
    private void union(int i, int j) {
        parent[find(i)] = find(j); // Set the root of i's set to j's root.
    }

    // Main method for testing.
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1:
        int[][] example1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution.findProvinces(example1)); // Expected Output: 2

        // Example 2:
        int[][] example2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(solution.findProvinces(example2)); // Expected Output: 3

        // Example 3:
        int[][] example3 = {{1,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,0,1}};
        System.out.println(solution.findProvinces(example3)); // Expected Output: 2
    }
}
