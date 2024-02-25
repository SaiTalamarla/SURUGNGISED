import java.util.Stack;

public class Solution {
    public String makeGood(String s) {
        // Create a stack to store characters.
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the input string.
        for (char c : s.toCharArray()) {
            // Check if the stack is not empty and the current character (ignoring case)
            // is equal to the character at the top of the stack (ignoring case), but they
            // are of different cases (e.g., 'a' and 'A', or 'b' and 'B').
            if (!stack.empty() && Character.toLowerCase(stack.peek()) == Character.toLowerCase(c) 
                && !stack.peek().equals(c)) {
                // If the conditions are met, pop the character from the stack,
                // effectively removing the pair of characters.
                stack.pop();
            } else {
                // If the conditions are not met, push the current character onto the stack.
                stack.push(c);
            }
        }
        
        // Create a StringBuilder to construct the final result.
        StringBuilder sb = new StringBuilder();
        
        // Iterate through the characters remaining in the stack and append them to the StringBuilder.
        for (char c : stack) {
            sb.append(c);
        }
        
        // Convert the StringBuilder to a string and return the result.
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("AaBbCcDdEeff"));  // Output: "ff"
        System.out.println(solution.makeGood("abBA"));  // Output: ""
        System.out.println(solution.makeGood("s"));  // Output: "s"
    }
}
