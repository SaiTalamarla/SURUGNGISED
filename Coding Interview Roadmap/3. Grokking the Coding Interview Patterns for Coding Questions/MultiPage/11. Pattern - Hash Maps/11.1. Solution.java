import java.util.HashMap;

public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Populate the hashmap with character frequencies
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean oddFound = false;
        
        // Calculate the palindrome length
        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1;
                oddFound = true;
            }
        }
        
        // Add the central character if any odd frequency was found
        if (oddFound) length++;
        
        return length;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("bananas"));  // Expected output: 5
        System.out.println(sol.longestPalindrome("applepie")); // Expected output: 7
        System.out.println(sol.longestPalindrome("racecar"));  // Expected output: 7
    }
}
