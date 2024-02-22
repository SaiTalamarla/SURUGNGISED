import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Method to find missing ranges
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int prev = lower - 1; // Initialize previous element as lower-1

        // Iterate through the array and beyond to include upper bound
        for (int i = 0; i <= nums.length; i++) {
            // Handle last element case by setting it to upper+1
            int curr = (i < nums.length) ? nums[i] : upper + 1;

            // Check if there is a gap between prev and curr
            if (prev + 1 <= curr - 1) {
                // Add the missing range to the result
                result.add(new ArrayList<>(List.of(prev + 1, curr - 1)));
            }
            prev = curr; // Update prev for the next iteration
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test cases
        int[][] examplesNums = {
            {3, 5, 10, 20},
            {10, 20, 30, 40, 50},
            {1, 3, 6, 10}
        };
        int[] examplesLower = {1, 5, 0};
        int[] examplesUpper = {22, 55, 12};

        // Testing each example
        for (int i = 0; i < examplesNums.length; i++) {
            System.out.println("Example " + (i + 1) + ": " +
                solution.findMissingRanges(examplesNums[i], examplesLower[i], examplesUpper[i]));
        }
    }
}
