public class Solution {

    public String findLongestNiceSubstring(String s) {
        if (s == null || s.length() <= 1) return ""; // Base condition

        // Check if the whole string is a nice substring
        if (isNice(s)) {
            return s;
        }

        String longest = "";

        // Divide and conquer: Check for each split point
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);

            // Recursively find the longest nice substring in the left and right parts
            String leftNice = findLongestNiceSubstring(left);
            String rightNice = findLongestNiceSubstring(right);

            // Conquer: Choose the longer one between leftNice and rightNice
            if (leftNice.length() >= rightNice.length()) {
                longest = leftNice.length() > longest.length() ? leftNice : longest;
            } else {
                longest = rightNice.length() > longest.length() ? rightNice : longest;
            }
        }

        return longest;
    }

    // Helper method to check if a string is a nice substring
    private static boolean isNice(String s) {
        int[] charMap = new int[128]; // ASCII character set size
        for (char c : s.toCharArray()) {
            charMap[c]++;
        }

        for (char c : s.toCharArray()) {
            // Check both cases for each character
            if (Character.isLowerCase(c) && charMap[Character.toUpperCase(c)] == 0
                || Character.isUpperCase(c) && charMap[Character.toLowerCase(c)] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Testing the algorithm with example inputs
        System.out.println(sol.findLongestNiceSubstring("BbCcXxY"));  // Expected: BbCcXx
        System.out.println(sol.findLongestNiceSubstring("aZAbcD"));   // Expected: (empty string)
        System.out.println(sol.findLongestNiceSubstring("qQwWeErR")); // Expected: qQwWeErR
    }
}
