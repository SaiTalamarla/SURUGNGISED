import java.util.Stack;

public class Solution {
    // Method to remove '*' characters from a string
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>(); // Create a stack to store characters
        for (char c : s.toCharArray()) { // Loop through each character in the input string
            if (c == '*' && !stack.empty()) { // If the character is '*' and the stack is not empty
                stack.pop(); // Pop (remove) the top character from the stack
            } else if (c != '*') { // If the character is not '*'
                stack.push(c); // Push (add) the character to the stack
            }
        }
        StringBuilder sb = new StringBuilder(); // Create a StringBuilder to build the result string
        for (char c : stack) { // Iterate through the characters in the stack
            sb.append(c); // Append each character to the StringBuilder
        }
        return sb.toString(); // Convert the StringBuilder to a string and return the result
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeStars("abc*de*f"));  // Output: "abdf"
        System.out.println(solution.removeStars("a*b*c*d"));  // Output: "d"
        System.out.println(solution.removeStars("abcd"));  // Output: "abcd"
    }
}
