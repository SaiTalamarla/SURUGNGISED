public class Solution {
    public int maxProduct(int[] nums) {
        // Base case: if the array is empty
        if (nums.length == 0) return 0;

        // Initialize the current maximum, minimum, and the result
        int maxCurrent = nums[0];
        int minCurrent = nums[0];
        int maxProduct = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Store the current max value to handle negative numbers
            int temp = maxCurrent;
            
            // Update maxCurrent for the current number
            maxCurrent = Math.max(nums[i], Math.max(maxCurrent * nums[i], minCurrent * nums[i]));
            
            // Update minCurrent for the current number
            minCurrent = Math.min(nums[i], Math.min(temp * nums[i], minCurrent * nums[i]));
            
            // Update the result
            maxProduct = Math.max(maxProduct, maxCurrent);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(new int[]{2,3,-2,4}));  // 6
        System.out.println(sol.maxProduct(new int[]{-2,0,-1}));  // 0
        System.out.println(sol.maxProduct(new int[]{-2,3,2,-4}));  // 48
    }
}
