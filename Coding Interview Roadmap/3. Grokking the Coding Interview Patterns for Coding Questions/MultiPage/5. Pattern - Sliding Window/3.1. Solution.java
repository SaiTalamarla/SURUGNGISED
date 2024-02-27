class Solution {
    public int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;  // Initialize the maximum sum.
        int windowSum;   // Initialize the current window sum.

        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;  // Reset the window sum for each new window.
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];  // Calculate the sum of the current window.
            }
            maxSum = Math.max(maxSum, windowSum);  // Update the maximum sum.
        }

        return maxSum;  // Return the maximum sum found.
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Maximum sum of a subarray of size K: "
                + sol.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + sol.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
