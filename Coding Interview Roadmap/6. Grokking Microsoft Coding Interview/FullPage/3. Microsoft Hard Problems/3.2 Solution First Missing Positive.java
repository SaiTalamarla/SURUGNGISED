public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // First pass: place each number in its right place, if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctPos = nums[i] - 1;
                // Swap the numbers to their correct positions
                int temp = nums[correctPos];
                nums[correctPos] = nums[i];
                nums[i] = temp;
            }
        }
        // Second pass: find the first position where the index doesn't match the value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // If all positions match, the missing number is n+1
        return n + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[]{5, 3, -1, 8, 4, 2})); // 1
        System.out.println(solution.firstMissingPositive(new int[]{2, 5, -7, 3, 9, 4, 6, 1})); // 7
        System.out.println(solution.firstMissingPositive(new int[]{-4, -3, -2, -1})); // 1
    }
}
