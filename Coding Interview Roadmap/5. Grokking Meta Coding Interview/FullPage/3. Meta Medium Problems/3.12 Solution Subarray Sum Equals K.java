import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, cumulativeSum = 0;
        Map<Integer, Integer> cumulativeSumFrequency = new HashMap<>();
        cumulativeSumFrequency.put(0, 1);  // Initialize with 0 sum count as 1

        for (int num : nums) {
            cumulativeSum += num;  // Update cumulative sum
            // Check if there's a subarray sum that equals k
            count += cumulativeSumFrequency.getOrDefault(cumulativeSum - k, 0);
            // Update the frequency map for the current cumulative sum
            cumulativeSumFrequency.put(cumulativeSum, cumulativeSumFrequency.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;  // Return the total count of subarrays
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Testing with the provided examples
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3)); // Example 1
        System.out.println(solution.subarraySum(new int[]{10, 2, -2, -20, 10}, -10)); // Example 2
        System.out.println(solution.subarraySum(new int[]{5, 1, 2, -3, 4, -2}, 3)); // Example 3
    }
}
