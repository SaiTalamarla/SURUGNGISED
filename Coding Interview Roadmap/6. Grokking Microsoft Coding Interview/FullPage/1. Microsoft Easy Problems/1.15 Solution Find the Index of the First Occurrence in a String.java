public class Solution {
    // Method to find the first occurrence of str2 in str1
    public int findFirstOccurrence(String str1, String str2) {
        if (str2.isEmpty()) return 0; // If str2 is empty, return 0
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            // Check if the substring of str1 starting at i matches str2
            if (str1.substring(i, i + str2.length()).equals(str2)) {
                return i; // Return the index if a match is found
            }
        }
        return -1; // Return -1 if no match is found
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the method with example inputs
        System.out.println(solution.findFirstOccurrence("algorithms", "rith")); // Expected output: 4
        System.out.println(solution.findFirstOccurrence("openai", "ai")); // Expected output: 4
        System.out.println(solution.findFirstOccurrence("challenge", "test")); // Expected output: -1
    }
}
