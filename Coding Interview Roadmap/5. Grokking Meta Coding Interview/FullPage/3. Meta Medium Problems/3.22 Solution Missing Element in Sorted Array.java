public class Solution {
    // Method to find the k-th missing element in a sorted array
    public int findMissingElement(int[] nums, int k) {
        int n = nums.length; // Length of the array
        int left = 0, right = n - 1; // Initialize pointers for binary search

        // Perform binary search
        while (left < right) {
            int mid = right - (right - left) / 2; // Calculate the middle index
            // If the count of missing numbers until mid is less than k, move left pointer
            if (nums[mid] - nums[0] - mid < k) {
                left = mid;
            } else { // Otherwise, move right pointer
                right = mid - 1;
            }
        }

        // Calculate and return the k-th missing element
        return nums[0] + k + left;
    }

    // Main method to test the algorithm with examples
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMissingElement(new int[]{3, 5, 6, 7}, 2)); // Example 1
        System.out.println(solution.findMissingElement(new int[]{1, 2, 4, 8}, 3)); // Example 2
        System.out.println(solution.findMissingElement(new int[]{2, 3, 4, 7, 8, 10, 11}, 2)); // Updated Example 3
    }
}
