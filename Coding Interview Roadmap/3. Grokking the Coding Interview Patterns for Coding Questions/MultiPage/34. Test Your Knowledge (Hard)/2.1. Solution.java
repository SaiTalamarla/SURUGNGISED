import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0; // To keep track of the maximum length
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices
        stack.push(-1); // Initial value to calculate length properly
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // Push the index of '(' to stack
            } else {
                stack.pop(); // Pop from stack for ')'
                if (stack.isEmpty()) {
                    stack.push(i); // Reset the base for length calculation
                } else {
                    max = Math.max(max, i - stack.peek()); // Calculate the length
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Testing the function with example inputs
        System.out.println(sol.longestValidParentheses("(())")); // Output: 4
        System.out.println(sol.longestValidParentheses(")()())")); // Output: 4
        System.out.println(sol.longestValidParentheses("(()")); // Output: 2
    }
}
