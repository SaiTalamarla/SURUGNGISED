public class Solution {
    // Method to merge two strings alternately
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder(); // StringBuilder to store the result
        int minLength = Math.min(word1.length(), word2.length()); // Determine the shorter string length
        // Loop through both strings up to the length of the shorter string
        for (int i = 0; i < minLength; i++) {
            result.append(word1.charAt(i)); // Append character from word1
            result.append(word2.charAt(i)); // Append character from word2
        }
        // Append remaining characters from the longer string, if any
        if (word1.length() > minLength) {
            result.append(word1.substring(minLength));
        } else if (word2.length() > minLength) {
            result.append(word2.substring(minLength));
        }
        return result.toString(); // Convert StringBuilder to String and return
    }

    // Main method to test the algorithm with example inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mergeAlternately("dog", "cat")); // Example 1
        System.out.println(solution.mergeAlternately("hello", "hi")); // Example 2
        System.out.println(solution.mergeAlternately("abc", "xyz123")); // Example 3
    }
}
