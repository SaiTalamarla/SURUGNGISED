import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0; // Current result
        int number = 0; // Current number being processed
        int sign = 1;   // Current sign (1 for positive, -1 for negative)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // Building the number by multiplying the previous number by 10 and adding the current digit
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                // Apply the previous sign to the number, add to the result, and reset the number
                result += sign * number;
                number = 0;
                sign = 1; // Set sign as positive
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1; // Set sign as negative
            } else if (c == '(') {
                // Push the result and sign on the stack and reset them
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Apply the sign to the number, add to the result
                result += sign * number;
                number = 0;
                // Pop the sign and previous result from the stack and add to the current result
                result *= stack.pop(); // stack.pop() is the sign before the parenthesis
                result += stack.pop(); // stack.pop() is the result before the parenthesis
            }
        }
        // Add the last number to the result
        return result + sign * number;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3 - (2 - 1) + 4")); // 6
        System.out.println(solution.calculate("10 + (8 - (4 + 2)) - 1")); // 11
        System.out.println(solution.calculate("5 + (3 - (2 + (8 - 5)) + 7) - (6 - 4)")); // 8
    }
}
