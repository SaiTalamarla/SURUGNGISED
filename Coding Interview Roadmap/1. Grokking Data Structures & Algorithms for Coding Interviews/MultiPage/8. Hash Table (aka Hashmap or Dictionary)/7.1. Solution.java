import java.util.HashMap;

public class Solution {
    public int largestUniqueNumber(int[] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // Populate the hashmap with number frequencies
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        int maxUnique = -1;
        // Traverse the hashmap to find the largest unique number
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                maxUnique = Math.max(maxUnique, key);
            }
        }
        
        return maxUnique;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestUniqueNumber(new int[]{5, 7, 3, 7, 5, 8}));  // Expected: 8
        System.out.println(sol.largestUniqueNumber(new int[]{1, 2, 3, 2, 1, 4, 4}));  // Expected: 3
        System.out.println(sol.largestUniqueNumber(new int[]{9, 9, 8, 8, 7, 7}));   // Expected: -1
    }
}
