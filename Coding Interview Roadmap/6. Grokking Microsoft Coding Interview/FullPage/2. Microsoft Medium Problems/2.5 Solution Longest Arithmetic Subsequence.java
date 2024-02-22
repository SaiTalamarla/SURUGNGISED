import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Method to find the length of the longest arithmetic subsequence
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        // Array of maps to store the length of arithmetic sequence ending with A[i] with a certain difference
        Map<Integer, Integer>[] dp = new HashMap[n];
        int result = 2; // Minimum length of any arithmetic subsequence
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                // Compute the length of the longest subsequence with this difference
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                // Update result if a longer subsequence is found
                result = Math.max(result, dp[i].get(diff));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the method with the revised examples
        System.out.println(solution.longestArithSeqLength(new int[]{8, 12, 6, 4, 2})); // Example 1
        System.out.println(solution.longestArithSeqLength(new int[]{5, 10, 15, 7, 11, 5})); // Example 2
        System.out.println(solution.longestArithSeqLength(new int[]{1, 7, 10, 15, 27, 29})); // Example 3
    }
}
