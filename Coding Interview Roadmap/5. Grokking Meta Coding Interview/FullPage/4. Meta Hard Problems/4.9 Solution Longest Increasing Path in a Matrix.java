public class Solution {
    private int[][] matrix; // The input matrix
    private int[][] cache; // Cache to store lengths of longest increasing paths
    private int rows, cols; // Dimensions of the matrix

    // Main method to find the longest increasing path
    public int longestIncreasingPath(int[][] matrix) {
        // Edge case check
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        cache = new int[rows][cols];
        int maxPath = 0;

        // Iterate through each cell of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Use DFS to find the longest path from each cell
                maxPath = Math.max(maxPath, dfs(i, j));
            }
        }

        return maxPath;
    }

    // DFS function to explore all possible paths
    private int dfs(int row, int col) {
        // If the value is already computed, return it to avoid recomputation
        if (cache[row][col] != 0) {
            return cache[row][col];
        }
        int maxLength = 1; // Initializing path length to 1 (the cell itself)
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Directions: up, down, left, right

        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            // Check if the new cell is within bounds and is greater than the current cell
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                && matrix[newRow][newCol] > matrix[row][col]) {
                // DFS to the new cell and update the maximum path length
                maxLength = Math.max(maxLength, 1 + dfs(newRow, newCol));
            }
        }

        cache[row][col] = maxLength; // Update the cache
        return maxLength;
    }

    // Main method for testing the algorithm with examples
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[][] matrix1 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println("Example 1: " + solution.longestIncreasingPath(matrix1)); // Expected: 4
        
        // Example 2
        int[][] matrix2 = {{5, 4, 9}, {5, 3, 8}, {4, 6, 7}};
        System.out.println("Example 2: " + solution.longestIncreasingPath(matrix2)); // Expected: 5

        // Example 3 (Revised)
        int[][] matrix3 = {{1, 2, 3, 4}, {6, 5, 4, 3}, {7, 8, 9, 2}, {10, 11, 12, 1}};
        System.out.println("Example 3: " + solution.longestIncreasingPath(matrix3)); // Expected: 9
    }
}
