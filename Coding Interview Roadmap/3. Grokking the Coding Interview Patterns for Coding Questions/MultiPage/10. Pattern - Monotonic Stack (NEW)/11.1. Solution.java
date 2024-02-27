import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();  // Initialize a stack to store character-count pairs.
        
        // Iterate through the input string character by character.
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) { // If the stack is not empty and the current character matches the character on top of the stack.
                stack.peek()[1]++;  // Increment the count of the top character in the stack.
            } else {
                stack.push(new int[]{c, 1});  // Otherwise, push a new character-count pair onto the stack.
            }
            
            if (stack.peek()[1] == k) {  // If the count of the top character in the stack reaches 'k'.
                stack.pop();  // Remove it from the stack.
            }
        }

        StringBuilder result = new StringBuilder();
        // Reconstruct the result string by popping characters and their counts from the stack.
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            result.append(String.valueOf((char) top[0]).repeat(top[1]));
        }

        return result.reverse().toString();  // Reverse the result and convert it to a string.
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbbaaca", 3)); // Output: "ca"
        System.out.println(solution.removeDuplicates("abbaccaa", 3)); // Output: "abbaccaa"
        System.out.println(solution.removeDuplicates("abbacccaa", 3)); // Output: "abb"
    }
}
