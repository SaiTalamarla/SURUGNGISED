import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0; // Initialize the maximum height encountered so far

        // Traverse the array from the last element to the first
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                result.add(i); // Add index of the building with ocean view
                maxHeight = heights[i]; // Update the maximum height
            }
        }
        Collections.reverse(result); // Reverse the list to maintain original order
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testing the algorithm with the provided examples
        int[] heights1 = {4, 3, 2, 1};
        System.out.println("Example 1: " + solution.findBuildings(heights1));

        int[] heights2 = {2, 3, 1, 4};
        System.out.println("Example 2: " + solution.findBuildings(heights2));

        int[] heights3 = {7, 4, 3, 2, 1, 4, 6, 3};
        System.out.println("Example 3: " + solution.findBuildings(heights3));
    }
}
