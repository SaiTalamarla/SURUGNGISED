import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    // Define the directions for North, East, South, and West
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        // Check for empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Initialize DFS for both oceans
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific, Integer.MIN_VALUE);
            dfs(matrix, i, n - 1, atlantic, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, pacific, Integer.MIN_VALUE);
            dfs(matrix, m - 1, i, atlantic, Integer.MIN_VALUE);
        }
        
        // Collect coordinates where both oceans meet
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] matrix, int r, int c, boolean[][] visited, int height) {
        int m = matrix.length, n = matrix[0].length;
        // Check boundaries, visited state, and height constraints
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || matrix[r][c] < height) {
            return;
        }
        
        // Mark current cell as visited
        visited[r][c] = true;
        // Explore neighbors
        for (int[] dir : DIRECTIONS) {
            dfs(matrix, r + dir[0], c + dir[1], visited, matrix[r][c]);
        }
    }
    
     public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Convert the output to a readable format before printing
        System.out.println(Arrays.deepToString(solution.pacificAtlantic(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).toArray()));
        System.out.println(Arrays.deepToString(solution.pacificAtlantic(new int[][]{{10,10,10},{10,1,10},{10,10,10}}).toArray()));
        System.out.println(Arrays.deepToString(solution.pacificAtlantic(new int[][]{{5,4,3},{4,3,2},{3,2,1}}).toArray()));
    }

}
