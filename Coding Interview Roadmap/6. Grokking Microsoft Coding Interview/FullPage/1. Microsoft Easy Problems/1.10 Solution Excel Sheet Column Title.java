public class Solution {
    // Method to convert number to Excel column title
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--; // Adjust because 'A' starts at 1 not 0
            char letter = (char) ('A' + n % 26); // Map number to letter
            result.insert(0, letter); // Prepend to build the title from right to left
            n /= 26; // Move to the next digit
        }
        return result.toString();
    }

    // Main method to test the convertToTitle function
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test with example inputs
        System.out.println(solution.convertToTitle(700)); // Expected: "ZX"
        System.out.println(solution.convertToTitle(52)); // Expected: "AZ"
        System.out.println(solution.convertToTitle(705)); // Expected: "AAC"
    }
}
