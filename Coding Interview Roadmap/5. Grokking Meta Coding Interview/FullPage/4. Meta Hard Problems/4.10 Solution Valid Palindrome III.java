public class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        // dp[i][j] will hold the minimum number of deletions required 
        // to make the substring s[i...j] a palindrome
        int[][] dp = new int[n][n];

        // Filling the dp array for substrings of increasing lengths
        for (int gap = 1; gap < n; gap++) {
            for (int start = 0; start < n - gap; start++) {
                int end = start + gap;

                if (s.charAt(start) == s.charAt(end)) {
                    // If characters are same, no extra deletion is needed
                    dp[start][end] = start + 1 <= end - 1 ? dp[start + 1][end - 1] : 0;
                } else {
                    // If characters are different, one deletion is needed
                    dp[start][end] = 1 + Math.min(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }

        // If the number of deletions required is less than or equal to k,
        // then it is possible to make the string a palindrome
        return dp[0][n - 1] <= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testing the algorithm with the example inputs
        String example1 = "rdar";
        int k1 = 1;
        System.out.println(solution.isValidPalindrome(example1, k1));

        String example2 = "abracadabra";
        int k2 = 5;
        System.out.println(solution.isValidPalindrome(example2, k2));

        String example3 = "data";
        int k3 = 0;
        System.out.println(solution.isValidPalindrome(example3, k3));
    }
}
