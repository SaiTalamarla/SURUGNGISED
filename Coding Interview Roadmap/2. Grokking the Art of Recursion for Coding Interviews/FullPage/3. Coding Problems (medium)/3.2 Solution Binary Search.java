public class Solution {
    public static boolean binarySearch(int[] nums, int target) {
        return binarySearchHelper(nums, target, 0, nums.length - 1);
    }

    private static boolean binarySearchHelper(int[] nums, int target, int low, int high) {
        if (low > high) {
            return false; // Base case: key not found
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return true; // Base case: key found
        } else if (nums[mid] > target) {
            return binarySearchHelper(nums, target, low, mid - 1); // Recursive call on left half
        } else {
            return binarySearchHelper(nums, target, mid + 1, high); // Recursive call on right half
        }
    }

    public static void main(String[] args) {
        // Example inputs
        int[][] examples = {
            {1, 2, 3, 4, 5},
            {2, 4, 6, 8, 10},
            {3, 6, 9, 12, 15}
        };
        int[] keys = {4, 5, 15};

        for (int i = 0; i < examples.length; i++) {
            int[] nums = examples[i];
            int target = keys[i];
            boolean result = binarySearch(nums, target);
            System.out.println("Example " + (i + 1) + ": " + target + " found? " + result);
        }
    }
}
