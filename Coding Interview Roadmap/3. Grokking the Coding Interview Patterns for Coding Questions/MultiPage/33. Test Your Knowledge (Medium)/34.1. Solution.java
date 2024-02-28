
public class Solution {
    public int uniquePaths(int m, int n) {
        // Initialize the dp array with 1s as we have at least 1 way to reach any cell
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        // Calculate the number of ways to reach each cell
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        // Return number of ways to reach the bottom-right cell
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(2, 2)); // 2
        System.out.println(sol.uniquePaths(3, 2)); // 3
        System.out.println(sol.uniquePaths(2, 3)); // 3
    }
}
