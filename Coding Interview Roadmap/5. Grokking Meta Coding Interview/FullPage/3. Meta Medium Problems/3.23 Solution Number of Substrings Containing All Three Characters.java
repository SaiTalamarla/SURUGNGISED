import java.util.*;

public class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0}; // Array to keep track of 'a', 'b', 'c' counts
        int start = 0, total = 0;
        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'a']++; // Increment the count of the current character
            
            // Check if all characters are present
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[s.charAt(start) - 'a']--; // Decrement the count of the start character
                start++; // Move the start forward
            }
            
            // Add the number of substrings ending at 'end' which contain all characters
            total += start;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubstrings("abc")); // Example 1
        System.out.println(solution.numberOfSubstrings("abbcca")); // Example 2
        System.out.println(solution.numberOfSubstrings("ababacb")); // Example 3
    }
}
