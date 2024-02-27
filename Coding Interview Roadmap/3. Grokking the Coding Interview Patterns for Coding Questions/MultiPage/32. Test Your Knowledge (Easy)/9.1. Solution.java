import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty, it means no matching opening bracket
                if (stack.isEmpty()) return false;
                char top = stack.pop(); // Get the top element of the stack
                // Check if the current closing bracket matches the top of the stack
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        // If stack is empty, all brackets were matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(]")); // false
        System.out.println(solution.isValid("{[]}")); // true
        System.out.println(solution.isValid("[{]}")); // false
    }
}
