import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0, start = 0, end = 0;
        
        // Traverse the string with the end pointer
        while (end < s.length()) {
            // If the character is not in the set, it's a unique character for the current substring
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                // If we find a repeating character, remove the character at the start pointer and move the start pointer
                set.remove(s.charAt(start));
                start++;
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcdaef"));       // Expected: 6
        System.out.println(sol.lengthOfLongestSubstring("aaaaa"));         // Expected: 1
        System.out.println(sol.lengthOfLongestSubstring("abrkaabcdefghijjxxx")); // Expected: 10
    }
}
