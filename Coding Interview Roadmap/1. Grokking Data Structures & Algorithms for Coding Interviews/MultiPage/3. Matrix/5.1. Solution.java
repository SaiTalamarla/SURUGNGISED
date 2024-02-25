public class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;  // Get the size of the matrix
        int totalSum = 0;  // Initialize the total sum
        
        // Loop through each row
        for (int i = 0; i < n; i++) {
            totalSum += mat[i][i] + mat[i][n-i-1];  // Add primary and secondary diagonal elements
        }
        
        // If n is odd, subtract the central element
        if (n % 2 != 0) {
            totalSum -= mat[n/2][n/2];
        }
        return totalSum;  // Return the calculated total sum
    }

    // Main method to test the examples
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));  // Output: 25
        System.out.println(sol.diagonalSum(new int[][]{{1,0},{0,1}}));  // Output: 2
        System.out.println(sol.diagonalSum(new int[][]{{5}}));  // Output: 5
    }
}
