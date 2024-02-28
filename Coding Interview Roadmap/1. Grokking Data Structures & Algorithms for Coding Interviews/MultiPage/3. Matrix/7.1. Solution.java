public class Solution {
    public int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;
        // Traverse through rows
        for (int i = 0; i < mat.length; i++) {
            int onesCount = 0;
            // Count ones in the current row
            for (int j = 0; j < mat[i].length; j++) {
                onesCount += mat[i][j];
            }
            // Check and update tracking variables if needed
            if (onesCount > maxOnesCount) {
                maxOnesIdx = i;
                maxOnesCount = onesCount;
            }
        }
        return new int[]{maxOnesIdx, maxOnesCount};
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Applying example inputs
        int[] result1 = sol.findMaxOnesRow(new int[][]{{1, 0}, {1, 1}, {0, 1}});
        System.out.println(result1[0] + ", " + result1[1]);  // Output: 1, 2
        
        int[] result2 = sol.findMaxOnesRow(new int[][]{{0, 1, 1}, {0, 1, 1}, {1, 1, 1}});
        System.out.println(result2[0] + ", " + result2[1]);  // Output: 2, 3
        
        int[] result3 = sol.findMaxOnesRow(new int[][]{{1, 0, 1}, {0, 0, 1}, {1, 1, 0}});
        System.out.println(result3[0] + ", " + result3[1]);  // Output: 0, 2
    }
}
