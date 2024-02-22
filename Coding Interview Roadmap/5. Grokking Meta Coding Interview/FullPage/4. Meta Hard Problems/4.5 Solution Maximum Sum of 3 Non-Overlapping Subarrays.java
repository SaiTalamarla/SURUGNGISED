import java.util.Arrays;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1]; // Cumulative sum array

        // Calculate cumulative sum
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        // Arrays to store the start index of max sum subarray
        int[] left = new int[n];
        int[] right = new int[n];
        int total;

        // Fill the left array
        total = sum[k] - sum[0];
        for (int i = k; i < n; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > total) {
                left[i] = i + 1 - k;
                total = sum[i + 1] - sum[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }

        // Fill the right array
        right[n - k] = n - k;
        total = sum[n] - sum[n - k];
        for (int i = n - k - 1; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= total) {
                right[i] = i;
                total = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }

        // Find the maximum sum of three subarrays
        int[] ans = new int[3];
        total = 0;
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1], r = right[i + k];
            int temp = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (temp > total) {
                total = temp;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the solution with examples
        System.out.println(Arrays.toString(solution.maxSumOfThreeSubarrays(new int[]{1, 2, 3, 1, 1, 2, 1, 3, 2}, 2))); // Example 1
        System.out.println(Arrays.toString(solution.maxSumOfThreeSubarrays(new int[]{4, 5, 10, 6, 11, 17, 4, 5, 6, 7}, 3))); // Example 2
        System.out.println(Arrays.toString(solution.maxSumOfThreeSubarrays(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 2))); // Example 3
    }
}
