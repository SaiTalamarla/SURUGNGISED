public class Solution {
    public String removeDuplicates(String s) {
        // Create a StringBuilder to use as a stack
        StringBuilder stack = new StringBuilder();

        // Process each character in s
        for (char c : s.toCharArray()) {
            int length = stack.length();
            // If the stack is not empty and the current character is the same as the top of the stack, pop the character from the stack
            if (length > 0 && c == stack.charAt(length - 1))
                stack.deleteCharAt(length - 1);
            else // Push the current character onto the stack
                stack.append(c);
        }

        // Convert the stack to a string
        return stack.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abccba")); // Output: ""
        System.out.println(solution.removeDuplicates("foobar")); // Output: "fbar"
        System.out.println(solution.removeDuplicates("abcd")); // Output: "abcd"
    }
}
