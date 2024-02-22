import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add new value
            deque.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        int[] nums1 = {2, 1, 5, 1, 3, 2};
        int k1 = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums1, k1)));
        // Example 2
        int[] nums2 = {4, -2, -3, 4, 1};
        int k2 = 2;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums2, k2)));
        // Example 3
        int[] nums3 = {9, 7, 2, 4, 6};
        int k3 = 4;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums3, k3)));
    }
}
