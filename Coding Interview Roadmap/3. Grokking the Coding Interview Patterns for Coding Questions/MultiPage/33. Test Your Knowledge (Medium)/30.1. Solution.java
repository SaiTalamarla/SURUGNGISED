public class Solution {
    
    // Main rob function that handles the circle scenario.
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        // Compare the result excluding the first or the last house.
        return Math.max(robSimple(nums, 0, nums.length - 2), robSimple(nums, 1, nums.length - 1));
    }
    
    // The simple rob function that doesn't consider the circle scenario.
    private int robSimple(int[] nums, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{4, 2, 3, 1})); // Expected 7
        System.out.println(solution.rob(new int[]{5, 1, 2, 5})); // Expected 7
        System.out.println(solution.rob(new int[]{1, 2, 3, 4, 5})); // Expected 8
    }
}
