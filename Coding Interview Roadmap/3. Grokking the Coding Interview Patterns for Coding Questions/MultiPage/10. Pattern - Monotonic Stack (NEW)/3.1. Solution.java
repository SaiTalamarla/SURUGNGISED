import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Create hashmap and stack
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Process each number in nums2
        for (int num : nums2) {
            // Pop elements from the stack that are smaller than current number
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num); // Remember the next greater element for num
            // Push current number onto stack
            stack.push(num);
        }   
        
        // Map the remaining numbers on the stack to -1
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {4,2,6};
        int[] nums2 = {6,2,4,5,3,7};
        int[] output = solution.nextGreaterElement(nums1, nums2);
        for (int num : output)
            System.out.print(num + " ");
        System.out.println();
    }
}
