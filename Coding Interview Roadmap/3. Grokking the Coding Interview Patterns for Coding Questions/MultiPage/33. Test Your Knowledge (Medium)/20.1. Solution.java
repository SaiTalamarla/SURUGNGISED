class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // Continue until the search range is exhausted
        while (left < right) {
            int mid = left + (right - left) / 2; // Finding the middle index
            
            // If mid element is greater than the rightmost element, the minimum is on the right
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid; // Otherwise, the minimum is on the left or at mid
            }
        }
        return nums[left]; // Return the smallest element
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[]{8, 1, 3, 4, 5}));  // Expected output: 1
        System.out.println(sol.findMin(new int[]{4, 5, 7, 8, 0, 2, 3}));  // Expected output: 0
        System.out.println(sol.findMin(new int[]{7, 9, 12, 3, 4, 5}));  // Expected output: 3
    }
}
