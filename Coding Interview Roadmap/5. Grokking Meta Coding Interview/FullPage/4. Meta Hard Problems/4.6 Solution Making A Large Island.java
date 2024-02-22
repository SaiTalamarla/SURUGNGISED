import java.util.*;

public class Solution {
    private int[][] grid;
    private boolean[][] visited;
    private int n; // Grid dimension
    private Map<Integer, Integer> islandSizeMap = new HashMap<>(); // Map to store island sizes

    // Main method to find the largest island after conversion
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        visited = new boolean[n][n]; // Visited array to keep track of visited cells
        int id = 2; // Starting ID for islands
        int maxIslandSize = 0; // Max island size found

        // Labeling each island with a unique identifier
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j, id); // Perform DFS to find island size
                    islandSizeMap.put(id, size); // Store island size
                    maxIslandSize = Math.max(maxIslandSize, size); // Update max island size
                    id++; // Increment island ID
                }
            }
        }

        // Checking each water cell to calculate potential island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    maxIslandSize = Math.max(maxIslandSize, calculatePotentialSize(i, j)); // Update max island size
                }
            }
        }

        return maxIslandSize == 0 ? n * n : maxIslandSize; // Return max island size
    }

    // DFS function to label islands and calculate their sizes
    private int dfs(int x, int y, int id) {
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || grid[x][y] == 0) {
            return 0; // Boundary and visited check
        }
        visited[x][y] = true; // Mark as visited
        grid[x][y] = id; // Assign island ID
        int size = 1; // Initialize island size
        // Explore all four directions
        size += dfs(x + 1, y, id);
        size += dfs(x - 1, y, id);
        size += dfs(x, y + 1, id);
        size += dfs(x, y - 1, id);
        return size; // Return total island size
    }

    // Function to calculate the potential size of an island if a water cell is converted to land
    private int calculatePotentialSize(int x, int y) {
        Set<Integer> adjacentIslands = new HashSet<>(); // Set to store unique adjacent island IDs
        // Check all four neighboring cells
        if (x > 0) adjacentIslands.add(grid[x - 1][y]);
        if (y > 0) adjacentIslands.add(grid[x][y - 1]);
        if (x < n - 1) adjacentIslands.add(grid[x + 1][y]);
        if (y < n - 1) adjacentIslands.add(grid[x][y + 1]);

        int potentialSize = 1; // Include the current water cell
        // Sum sizes of all unique adjacent islands
        for (int islandId : adjacentIslands) {
            potentialSize += islandSizeMap.getOrDefault(islandId, 0);
        }
        return potentialSize; // Return potential island size
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test cases
        int[][] grid1 = {
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {1, 1, 0, 0}
        };
        System.out.println("Example 1: " + solution.largestIsland(grid1));

        int[][] grid2 = {
            {1, 1, 1},
            {1, 0, 0},
            {0, 0, 1}
        };
        System.out.println("Example 2: " + solution.largestIsland(grid2));

        int[][] grid3 = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        };
        System.out.println("Example 3: " + solution.largestIsland(grid3));
    }
}
