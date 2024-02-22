public class Solution {
    // Method to check if a matrix is a Toeplitz matrix
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                // Check if current element is equal to its diagonal successor
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1,2,3},{4,1,2},{5,4,1}})); // true
        // Test case 2
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1,2},{3,4}})); // false
        // Test case 3
        System.out.println(solution.isToeplitzMatrix(new int[][]{{7,7,7},{7,7,7},{7,7,7}})); // true
    }
}
