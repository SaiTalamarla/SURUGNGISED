import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDiagonalOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int N = matrix.length, M = matrix[0].length;
        int row = 0, column = 0;
        boolean upwards = true;

        while (row < N && column < M) {
            result.add(matrix[row][column]);

            // Determine the next cell in the traversal
            int newRow = upwards ? row - 1 : row + 1;
            int newColumn = upwards ? column + 1 : column - 1;

            // Check boundary conditions
            if (newRow < 0 || newRow == N || newColumn < 0 || newColumn == M) {
                if (upwards) {
                    row += (column == M - 1) ? 1 : 0;
                    column += (column < M - 1) ? 1 : 0;
                } else {
                    column += (row == N - 1) ? 1 : 0;
                    row += (row < N - 1) ? 1 : 0;
                }
                upwards = !upwards; // Change direction
            } else {
                row = newRow;
                column = newColumn;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        int[][] matrix1 = {{1, 5}, {3, 6}};
        System.out.println(solution.findDiagonalOrder(matrix1));

        // Example 2
        int[][] matrix2 = {{1}, {2}, {3}};
        System.out.println(solution.findDiagonalOrder(matrix2));

        // Example 3
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(solution.findDiagonalOrder(matrix3));
    }
}
