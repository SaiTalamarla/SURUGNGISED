public class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0, maxLen = 0, zeroCount = 0;
        // Iterate through the array with right pointer
        for (int right = 0; right < A.length; right++) {
            // Increment zeroCount if current element is 0
            if (A[right] == 0) zeroCount++;
            
            // Move left pointer to reduce zeroCount within limit
            while (zeroCount > K) {
                if (A[left] == 0) zeroCount--;
                left++;
            }
            
            // Update maxLen for the longest window found
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] example1 = {1, 0, 1, 1, 0, 0, 1, 1, 1, 0};
        System.out.println("Example 1: " + solution.longestOnes(example1, 2)); // Expected output: 7

        // Example 2
        int[] example2 = {0, 1, 1, 0, 1, 0, 1, 0, 1};
        System.out.println("Example 2: " + solution.longestOnes(example2, 1)); // Expected output: 4

        // Example 3
        int[] example3 = {1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1};
        System.out.println("Example 3: " + solution.longestOnes(example3, 3)); // Expected output: 8
    }
}
