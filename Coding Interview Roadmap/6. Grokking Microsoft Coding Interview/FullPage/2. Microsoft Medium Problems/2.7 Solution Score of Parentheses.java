import java.util.Stack;

public class Solution {
    // Method to calculate the score of parentheses
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Initialize stack with a base score

        for (char c : S.toCharArray()) { // Iterate through each character in the string
            if (c == '(') {
                stack.push(0); // Push 0 for a new depth level
            } else {
                int cur = stack.pop(); // Pop the top element to evaluate
                int prev = stack.pop(); // Pop the next top element for addition
                stack.push(prev + Math.max(2 * cur, 1)); // Calculate and push the score
            }
        }
        
        return stack.pop(); // Return the final score
    }
    
    // Main method to test the examples
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.scoreOfParentheses("((()))")); // Expected Output: 4
        System.out.println(solution.scoreOfParentheses("(()())")); // Expected Output: 4
        System.out.println(solution.scoreOfParentheses("(()(()))")); // Expected Output: 6
    }
}
