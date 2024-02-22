import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // Validate input
        if (matrix == null || matrix.length == 0) return result;
        
        // Initialize boundary pointers
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        
        // Traverse the matrix in a spiral order
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;
            
            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            
            // Traverse from right to left if top <= bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
                bottom--;
            }
            
            // Traverse from bottom to top if left <= right
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[][] matrix1 = {{10,20,30},{40,50,60},{70,80,90}};
        System.out.println(sol.spiralOrder(matrix1));
        
        // Example 2
        int[][] matrix2 = {{1,2},{3,4},{5,6}};
        System.out.println(sol.spiralOrder(matrix2));
        
        // Example 3 (Revised)
        int[][] matrix3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(sol.spiralOrder(matrix3));
    }
}
