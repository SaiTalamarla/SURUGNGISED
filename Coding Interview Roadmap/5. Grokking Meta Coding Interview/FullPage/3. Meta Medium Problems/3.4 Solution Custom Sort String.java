import java.util.*;

public class Solution {
    public String customSortString(String pattern, String text) {
        // Creating a hashmap to store the frequency of each character in 'text'
        Map<Character, Integer> textFrequency = new HashMap<>();
        for (char ch : text.toCharArray()) {
            textFrequency.put(ch, textFrequency.getOrDefault(ch, 0) + 1);
        }

        // StringBuilder to build the final sorted string
        StringBuilder result = new StringBuilder();

        // Iterating over 'pattern' to append characters in the defined order
        for (char ch : pattern.toCharArray()) {
            if (textFrequency.containsKey(ch)) {
                for (int i = 0; i < textFrequency.get(ch); i++) {
                    result.append(ch);
                }
                textFrequency.remove(ch); // Remove the character after processing
            }
        }

        // Appending the remaining characters from 'text'
        for (char ch : text.toCharArray()) {
            if (textFrequency.containsKey(ch)) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.customSortString("xy", "yyzx")); // "xyyz"
        System.out.println(solution.customSortString("abc", "aabbcc")); // "aabbcc"
        System.out.println(solution.customSortString("mno", "onomon")); // "mnnooo"
    }
}
