import java.util.TreeSet;

public class Solution {
    // Method to check if the array contains a 132 pattern
    public boolean find132pattern(int[] nums) {
        int z = Integer.MIN_VALUE;  // Initialize z to the smallest possible value
        TreeSet<Integer> set = new TreeSet<>();  // A TreeSet to keep elements in sorted order

        // Iterate through the array from end to start
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < z) return true;  // If current number is smaller than z, pattern is found

            // Find the largest element in the set which is smaller than the current number
            Integer n = set.lower(nums[i]);
            if (n != null) z = n;  // Update z to this element

            set.add(nums[i]);  // Add current number to the set for future comparisons
        }

        return false;  // Return false if no pattern is found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the method with different arrays
        System.out.println(solution.find132pattern(new int[]{3, 5, 0, 3, 4})); // Expecting True
        System.out.println(solution.find132pattern(new int[]{1, 2, 3, 4})); // Expecting False
        System.out.println(solution.find132pattern(new int[]{9, 11, 8, 9, 10, 7, 9})); // Expecting True
    }
}
