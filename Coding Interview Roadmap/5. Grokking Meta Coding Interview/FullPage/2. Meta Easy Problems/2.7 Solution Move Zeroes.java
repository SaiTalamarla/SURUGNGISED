import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    // Method to move zeroes to the end
    public List<Integer> moveZeroes(List<Integer> nums) {
        int lastNonZeroIndex = 0; // Tracks the position to place the next non-zero element

        // Iterate over the array
        for (int i = 0; i < nums.size(); i++) {
            // If the current element is non-zero
            if (nums.get(i) != 0) {
                // Swap the current element with the element at lastNonZeroIndex
                Collections.swap(nums, i, lastNonZeroIndex++);
            }
        }
        return nums;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test with different examples
        // Example 1
        List<Integer> example1 = new ArrayList<>(List.of(1, 0, 2, 0, 3, 0, 4));
        System.out.println("Example 1: " + solution.moveZeroes(example1));

        // Example 2
        List<Integer> example2 = new ArrayList<>(List.of(0, 0, 0, 10, 20));
        System.out.println("Example 2: " + solution.moveZeroes(example2));

        // Example 3
        List<Integer> example3 = new ArrayList<>(List.of(5, 1, 0, 2, 0));
        System.out.println("Example 3: " + solution.moveZeroes(example3));
    }
}
