public class Solution {
    // Method to check if two strings are buddy strings
    public boolean buddyStrings(String a, String b) {
        // Check for length equality
        if (a.length() != b.length()) return false;

        // Handling identical strings
        if (a.equals(b)) {
            int[] count = new int[26]; // Frequency count for characters
            for (int i = 0; i < a.length(); i++) {
                count[a.charAt(i) - 'a']++;
                if (count[a.charAt(i) - 'a'] > 1) return true; // Found a repeating character
            }
            return false; // No repeating characters
        } else {
            // Identifying positions where characters differ
            int first = -1, second = -1;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (first == -1) first = i; // First difference
                    else if (second == -1) second = i; // Second difference
                    else return false; // More than two differences
                }
            }
            // Checking if swapping makes the strings equal
            return (second != -1 && a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("xy", "yx")); // true
        System.out.println(solution.buddyStrings("ab", "cd")); // false
        System.out.println(solution.buddyStrings("abcde", "acbde")); // true
    }
}
