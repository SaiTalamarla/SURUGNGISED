import java.util.HashMap;

public class Solution {
    // Method to check if a permutation of the string can form a palindrome
    public boolean canPermutePalindrome(String s) {
        // HashMap to store the counts of each character
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (char c : s.toCharArray()) {
            // Increment the count for each character
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0; // Counter for characters with odd counts
        for (int count : charCounts.values()) {
            // Check if the count is odd
            if (count % 2 != 0) {
                oddCount++;
            }
            // If more than one character has an odd count, it's not a palindrome permutation
            if (oddCount > 1) {
                return false;
            }
        }
        // If none or only one character has an odd count, it's a palindrome permutation
        return true;
    }

    // Main method to test the algorithm with example inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1: "tactcoa" - Expected output: true
        System.out.println(solution.canPermutePalindrome("tactcoa"));
        // Example 2: "abcde" - Expected output: false
        System.out.println(solution.canPermutePalindrome("abcde"));
        // Example 3: "aabbccdd" - Expected output: true
        System.out.println(solution.canPermutePalindrome("aabbccdd"));
    }
}
