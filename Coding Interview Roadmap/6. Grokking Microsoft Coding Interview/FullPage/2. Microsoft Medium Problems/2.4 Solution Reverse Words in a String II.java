public class Solution {
    // Method to reverse words in an array
    public char[] reverseWords(char[] s) {
        // Step 1: Reverse the entire array
        reverse(s, 0, s.length - 1);
        
        // Step 2 & 3: Find each word's bounds and reverse each word
        int start = 0; // Start index of a word
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, start, i - 1); // Reverse the current word
                start = i + 1; // Update the start index for the next word
            }
        }
        return s;
    }
    
    // Helper method to reverse a portion of the array
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        char[] example1 = {'h','e','l','l','o',' ','w','o','r','l','d'};
        solution.reverseWords(example1);
        System.out.println(example1);
        
        // Example 2 (Revised)
        char[] example2 = {'m','o','r','n','i','n','g',' ','s','k','y',' ','i','s',' ','b','r','i','g','h','t'};
        solution.reverseWords(example2);
        System.out.println(example2);
        
        // Example 3
        char[] example3 = {'a','l','o','n','e'};
        solution.reverseWords(example3);
        System.out.println(example3);
    }
}
