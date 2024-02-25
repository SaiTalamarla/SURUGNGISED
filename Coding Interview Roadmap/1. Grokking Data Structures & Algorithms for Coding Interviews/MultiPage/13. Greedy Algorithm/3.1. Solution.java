public class Solution {
    // Method to check if it's possible to form a palindrome
    public boolean isPalindromePossible(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Check by removing either left or right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true; // String is already a palindrome
    }

    // Helper method to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindromePossible("racecar")); // true
        System.out.println(sol.isPalindromePossible("abccdba")); // true
        System.out.println(sol.isPalindromePossible("abcdef"));  // false
    }
}
