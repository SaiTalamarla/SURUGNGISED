import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s) {
        // Create a stack to store characters.
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the input string.
        for (char c : s.toCharArray()) {
            // Check if the stack is not empty and the current character matches the top of the stack.
            if (!stack.isEmpty() && stack.peek() == c) {
                // If a duplicate is found, pop the character from the stack.
                stack.pop();
            } else {
                // If no duplicate is found, push the character onto the stack.
                stack.push(c);
            }
        }
        
        // Create a StringBuilder to build the result string.
        StringBuilder sb = new StringBuilder();
        
        // Iterate through the characters in the stack and append them to the result.
        for (char c : stack) {
            sb.append(c);
        }
        
        // Convert the StringBuilder to a String and return the result.
        return sb.toString();
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class.
        Solution solution = new Solution();
        
        // Test cases to remove duplicates.
        System.out.println(solution.removeDuplicates("abbaca"));  // Output: "ca"
        System.out.println(solution.removeDuplicates("azxxzy"));  // Output: "ay"
        System.out.println(solution.removeDuplicates("abba"));    // Output: ""
    }
}
