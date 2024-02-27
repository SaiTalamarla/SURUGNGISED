import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create a hashmap to store character frequencies from the magazine
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Populate the hashmap with character frequencies from the magazine
        for (char c : magazine.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Check if the ransom note can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canConstruct("hello", "hellworld"));  // Expected: true
        System.out.println(sol.canConstruct("notes", "stoned"));     // Expected: true
        System.out.println(sol.canConstruct("apple", "pale"));       // Expected: false
    }
}
