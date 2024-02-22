import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // Method to calculate the maximum length of a unique character string from a list
    public int maxLength(List<String> arr) {
        // Initialize a list to keep all combinations starting with an empty string
        List<String> results = new ArrayList<>();
        results.add(""); // Start with an empty string to build upon
        int best = 0; // Variable to keep track of the maximum length found
        
        // Iterate over each word in the input list
        for (String word : arr) {
            // Only iterate over the combinations found before adding the current word
            int resultsLen = results.size();
            for (int i = 0; i < resultsLen; i++) {
                // Create a new combination by appending the current word
                String newRes = results.get(i) + word;
                // Check if the new combination has all unique characters
                if (isUnique(newRes)) {
                    // If unique, add it to the list of combinations
                    results.add(newRes);
                    // Update the maximum length found so far
                    best = Math.max(best, newRes.length());
                }
            }
        }
        return best; // Return the maximum length of unique characters found
    }

    // Helper method to check if a string has all unique characters
    private boolean isUnique(String s) {
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            // Try adding each character to a set, if it's already there, string is not unique
            if (!chars.add(c)) return false;
        }
        return true; // If all characters are unique, return true
    }

    // Main method to test the algorithm with example inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        System.out.println(solution.maxLength(List.of("ab", "cd", "e"))); // Expected output: 5
        // Example 2
        System.out.println(solution.maxLength(List.of("a", "abc", "d", "de", "def"))); // Expected output: 6
        // Example 3
        System.out.println(solution.maxLength(List.of("xyz", "y", "z"))); // Expected output: 3
    }
}
