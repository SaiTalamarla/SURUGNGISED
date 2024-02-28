import java.util.HashMap;

public class Solution {
    public int firstUniqChar(String s) {
        // Create a hashmap to store the frequency of each character
        HashMap<Character, Integer> freq = new HashMap<>();
        
        // Traverse the string to populate the hashmap with character frequencies
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        // Traverse the string again to find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        // If no unique character is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.firstUniqChar("apple"));  // Expected: 0
        System.out.println(sol.firstUniqChar("abcab"));  // Expected: 2
        System.out.println(sol.firstUniqChar("abab"));   // Expected: -1
    }
}
