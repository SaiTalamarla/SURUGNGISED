import java.util.*;

public class Solution {
    public List<Integer> findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new ArrayList<>(); // Array size must be even
        Arrays.sort(changed); // Sort the array
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> original = new ArrayList<>();
        
        // Count occurrences of each element
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : changed) {
            if (countMap.get(num) == 0) continue; // Skip if count is 0
            if (countMap.getOrDefault(2 * num, 0) == 0) return new ArrayList<>(); // Check if double exists
            
            original.add(num); // Add to original array
            countMap.put(num, countMap.get(num) - 1); // Decrement count
            countMap.put(2 * num, countMap.get(2 * num) - 1); // Decrement count of double
        }
        
        return original;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test with the provided examples
        System.out.println(solution.findOriginalArray(new int[]{2, 4, 1, 8}));
        System.out.println(solution.findOriginalArray(new int[]{6, 3, 0, 0}));
        System.out.println(solution.findOriginalArray(new int[]{1, 2, 2, 4, 4, 8, 16, 32}));
    }
}
