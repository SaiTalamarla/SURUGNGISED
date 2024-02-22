public class Solution {
    public boolean isMatch(String text, String pattern) {
        // Initialize DP table
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true; // Empty text matches empty pattern

        // Handle patterns like a*, a*b*, a*b*c* etc.
        for (int j = 2; j <= pattern.length(); j += 2) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= text.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                char currentTextChar = text.charAt(i - 1);
                char currentPatternChar = pattern.charAt(j - 1);

                if (currentPatternChar == '.' || currentPatternChar == currentTextChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentPatternChar == '*') {
                    dp[i][j] = dp[i][j - 2]; // '*' Matches zero occurrence
                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == currentTextChar) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // '*' Matches one or more occurrences
                    }
                }
            }
        }

        return dp[text.length()][pattern.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the algorithm with examples
        System.out.println(solution.isMatch("aadg", ".*d.")); // true
        System.out.println(solution.isMatch("hello", "he*o")); // false
    }
}
