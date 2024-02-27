public class Solution {
    // Function to compute the maximum area
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1; // Initialize two pointers at the start and end
        int maxArea = 0; // To store the maximum area found

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]); // Find the shorter of the two lines
            maxArea = Math.max(maxArea, minHeight * (right - left)); // Compute the area and update maxArea if needed

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxArea(new int[]{1,3,2,4,5})); // 9
        System.out.println(sol.maxArea(new int[]{5,2,4,2,6,3})); // 20
        System.out.println(sol.maxArea(new int[]{2,3,4,5,18,17,6})); // 17
    }
}
