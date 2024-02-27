import java.util.Stack;

public class Solution {
    // Function to reverse a given string using a stack
    public String reverseString(String s) {
        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character from the input string onto the stack
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        // Create a StringBuilder to build the reversed string
        StringBuilder reversed = new StringBuilder();

        // Pop characters from the stack and append them to the StringBuilder
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Convert the StringBuilder to a string and return the reversed string
        return reversed.toString();
    }

    // Main method to test the reverseString function
    public static void main(String[] args) {
        Solution rs = new Solution();

        // Test cases
        System.out.println(rs.reverseString("Hello, World!")); // Output: "!dlroW ,olleH"
        System.out.println(rs.reverseString("OpenAI")); // Output: "IAnepO"
        System.out.println(rs.reverseString("Stacks are fun!")); // Output: "!nuf era skcatS"
    }
}
