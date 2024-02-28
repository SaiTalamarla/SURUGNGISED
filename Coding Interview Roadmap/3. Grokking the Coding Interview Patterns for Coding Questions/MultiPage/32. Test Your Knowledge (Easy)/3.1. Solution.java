import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store the numbers and their indices
        Map<Integer, Integer> numIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current number
            int complement = target - nums[i];
            // If the complement is found in the map, return the indices
            if (numIndices.containsKey(complement)) {
                return new int[]{numIndices.get(complement), i};
            }
            // Otherwise, add the number and its index to the map
            numIndices.put(nums[i], i);
        }
        // Throw an exception if no solution is found
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the algorithm with example inputs
        int[] result1 = solution.twoSum(new int[]{2, 15, 11, 7}, 9);
        // Output the results
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 3]
        
        int[] result2 = solution.twoSum(new int[]{3, 1, 4, 8, 5}, 9);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // Output: [2, 4]
        
        int[] result3 = solution.twoSum(new int[]{10, 20, 30, 40, 50}, 90);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // Output: [3, 4]
    }
}
