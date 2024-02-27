import java.util.*;

class Solution {

  public int findKthSmallestNumber(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[k - 1];
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int result = 
        sol.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
    System.out.println("Kth smallest number is: " + result);

    // as there're two 5s in input array, our 3rd and 4th smallest numbers should be '5'
    result = sol.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
    System.out.println("Kth smallest number is: " + result);

    result = sol.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Kth smallest number is: " + result);
  }
}
