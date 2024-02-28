import java.util.HashSet;

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Create a hashset to store jewel types
        HashSet<Character> jewelSet = new HashSet<>();
        
        // Populate the hashset with jewel types
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }
        
        int count = 0;
        // Count the number of stones that are jewels
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numJewelsInStones("abc", "aabbcc"));  // Expected: 6
        System.out.println(sol.numJewelsInStones("aA", "aAaZz"));    // Expected: 3
        System.out.println(sol.numJewelsInStones("zZ", "zZzZzZ"));   // Expected: 6
    }
}
