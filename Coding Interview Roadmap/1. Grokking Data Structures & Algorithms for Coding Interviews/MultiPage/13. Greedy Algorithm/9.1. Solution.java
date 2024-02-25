import java.util.*;

public class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashSet<Character> present = new HashSet<>();
        Stack<Character> result = new Stack<>();

        // Counting the frequency of each character
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (!present.contains(c)) {
                // Ensure the smallest lexicographical order by removing higher characters that will appear again
                while (!result.isEmpty() && c < result.peek() && count.get(result.peek()) > 0) {
                    present.remove(result.pop());
                }
                result.push(c);
                present.add(c);
            }
            count.put(c, count.get(c) - 1); // Decreasing the frequency
        }

        // Building the result string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicateLetters("bbaac"));    // Output: "bac"
        System.out.println(sol.removeDuplicateLetters("zabccde")); // Output: "zabcde"
        System.out.println(sol.removeDuplicateLetters("mnopmn"));   // Output: "mnop"
    }
}
