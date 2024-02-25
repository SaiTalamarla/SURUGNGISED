import java.util.HashSet;

public class Solution {
    public int countElements(int[] arr) {
        // Create a set to store unique numbers from the array
        HashSet<Integer> set = new HashSet<>();
        
        // Populate the set with numbers from the array
        for (int num : arr) {
            set.add(num);
        }
        
        int count = 0;
        // For each number in the array, check if its next consecutive number exists in the set
        for (int num : arr) {
            if (set.contains(num + 1)) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countElements(new int[]{4, 3, 1, 5, 6}));  // Expected: 3
        System.out.println(sol.countElements(new int[]{7, 8, 9, 10}));   // Expected: 3
        System.out.println(sol.countElements(new int[]{11, 13, 15, 16})); // Expected: 1
    }
}
