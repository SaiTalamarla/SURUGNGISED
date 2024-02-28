public class Solution {
    
    // Method to expand from the center and count palindromic substrings
    private int expandFromCenter(String s, int left, int right) {
        int count = 0;
        // Check for palindrome while staying within string boundaries
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes
            count += expandFromCenter(s, i, i);
            // Check for even length palindromes
            count += expandFromCenter(s, i, i + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countSubstrings("racecar"));  // 10
        System.out.println(sol.countSubstrings("noon"));  // 6
        System.out.println(sol.countSubstrings("apple"));  // 6
    }
}
