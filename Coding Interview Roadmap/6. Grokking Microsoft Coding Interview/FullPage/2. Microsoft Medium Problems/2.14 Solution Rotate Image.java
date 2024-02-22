import java.util.Arrays;

public class Solution {
    public int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 3 Modified
        int[][] matrix = {{10,11,12,13},{14,15,16,17},{18,19,20,21},{22,23,24,25}};
        solution.rotate(matrix);
        System.out.println("Rotated Matrix: " + Arrays.deepToString(matrix));
    }
}
