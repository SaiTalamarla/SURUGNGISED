import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Define eight possible directions to move: up, down, left, right, and diagonally
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {0, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length; // Get the size of the grid (assuming it's a square grid).
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;  // Check if start or end is blocked.

        boolean[][] visited = new boolean[N][N]; // Create a boolean array to keep track of visited cells.
        Queue<int[]> queue = new LinkedList<>(); // Create a queue to perform breadth-first search.
        queue.add(new int[]{0, 0, 1});  // Add the starting cell (row, column, and path length).
        visited[0][0] = true; // Mark the starting cell as visited.

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // Get the current cell from the queue.
            int row = current[0], col = current[1], path = current[2]; // Extract row, column, and path length.

            if (row == N - 1 && col == N - 1) return path;  // Check if we reached the destination.

            // Explore all eight possible directions from the current cell.
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0], newCol = col + direction[1];

                // Check if the new position is within the grid boundaries and not visited.
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N && grid[newRow][newCol] == 0 && !visited[newRow][newCol]) {
                    queue.add(new int[]{newRow, newCol, path + 1}); // Add the new cell to the queue with an increased path length.
                    visited[newRow][newCol] = true; // Mark the new cell as visited.
                }
            }
        }
        return -1;  // No path found.
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] grid1 = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
        System.out.println("Example 1: " + solution.shortestPathBinaryMatrix(grid1));

        // Example 2
        int[][] grid2 = {{1, 1, 1}, {0, 1, 1}, {0, 0, 0}};
        System.out.println("Example 2: " + solution.shortestPathBinaryMatrix(grid2));

        // Example 3
        int[][] grid3 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Example 3: " + solution.shortestPathBinaryMatrix(grid3));
    }
}
