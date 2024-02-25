import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Count occurrences of each number
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Check if the occurrences are unique
        HashSet<Integer> uniqueCounts = new HashSet<>();
        for (int count : countMap.values()) {
            if (!uniqueCounts.add(count)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniqueOccurrences(new int[]{4, 5, 4, 6, 6, 6}));
        System.out.println(sol.uniqueOccurrences(new int[]{7, 8, 8, 9, 9, 9, 10, 10}));
        System.out.println(sol.uniqueOccurrences(new int[]{11, 12, 13, 14, 14, 15, 15, 15}));
    }
}
