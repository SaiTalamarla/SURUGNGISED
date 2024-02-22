import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Maps character to its frequency in t.
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0, minStart = 0, minLength = Integer.MAX_VALUE;
        int counter = t.length(); // Number of characters in t to be found in s.

        while (end < s.length()) {
            char endChar = s.charAt(end);
            // If character in s exists in t, decrease counter.
            if (map.getOrDefault(endChar, 0) > 0) {
                counter--;
            }
            map.put(endChar, map.getOrDefault(endChar, 0) - 1);
            end++;

            // When counter is 0, all characters in t are found in the current window.
            while (counter == 0) {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                map.put(startChar, map.getOrDefault(startChar, 0) + 1);
                // If character in s exists in t, increase counter.
                if (map.get(startChar) > 0) {
                    counter++;
                }
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    // Main method for testing.
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("xyyzyzyx", "xyz")); // "zyx"
        System.out.println(solution.minWindow("abracadabra", "aa")); // "aca"
        System.out.println(solution.minWindow("welcomeback", "ole")); // "elco"
    }
}
