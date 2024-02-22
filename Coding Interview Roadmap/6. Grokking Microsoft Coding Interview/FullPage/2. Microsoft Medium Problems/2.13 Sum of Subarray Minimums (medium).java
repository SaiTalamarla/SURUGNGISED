import java.util.Stack;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1_000_000_007; // Define modulo for handling large sums.
        Stack<int[]> stack = new Stack<>(); // Stack to keep track of minimum elements.
        int result = 0, currentSum = 0; // Initialize result and currentSum.
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            // Pop elements from the stack if current element is smaller.
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                int[] top = stack.pop();
                count += top[1];
                currentSum -= top[0] * top[1]; // Subtract their contribution.
            }
            stack.push(new int[]{arr[i], count}); // Push current element onto stack.
            currentSum = (currentSum + arr[i] * count) % mod; // Add new contribution.
            result = (result + currentSum) % mod; // Update result.
        }
        return result; // Return the final sum.
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the algorithm with example inputs.
        System.out.println(solution.sumSubarrayMins(new int[]{2, 3, 1})); // Example 1
        System.out.println(solution.sumSubarrayMins(new int[]{4, 5, 2})); // Example 2
        System.out.println(solution.sumSubarrayMins(new int[]{7, 2, 8, 4})); // Example 3
    }
}
