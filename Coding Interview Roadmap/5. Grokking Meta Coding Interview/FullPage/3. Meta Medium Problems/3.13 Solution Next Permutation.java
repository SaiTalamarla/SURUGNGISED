import java.util.Arrays; // Import statement for Arrays

public class Solution {
    public int[] nextPermutation(int[] nums) {
        int n = nums.length, pivot = -1;

        // Step 1: Find the pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot != -1) {
            // Step 2: Find the successor
            for (int j = n - 1; j > pivot; j--) {
                if (nums[j] > nums[pivot]) {
                    // Step 3: Swap pivot and successor
                    swap(nums, pivot, j);
                    break;
                }
            }
        }

        // Step 4: Reverse the sequence after pivot position
        reverse(nums, pivot + 1);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example tests
        int[] nums1 = {1, 3, 5, 4, 2};
        System.out.println("Next permutation: " + Arrays.toString(solution.nextPermutation(nums1)));

        int[] nums2 = {2, 3, 6, 5, 4, 1};
        System.out.println("Next permutation: " + Arrays.toString(solution.nextPermutation(nums2)));

        int[] nums3 = {1, 1, 5};
        System.out.println("Next permutation: " + Arrays.toString(solution.nextPermutation(nums3)));
    }
}
