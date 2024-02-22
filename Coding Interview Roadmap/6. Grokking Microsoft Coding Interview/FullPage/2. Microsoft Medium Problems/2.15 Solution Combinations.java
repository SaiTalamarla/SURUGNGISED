import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Function to generate all combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking process
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    // Helper function for backtracking
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // Base case: if the combination is complete
        if (k == 0) {
            // Add a copy of tempList to the result
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        // Iterate through possible starts
        for (int i = start; i <= n; i++) {
            tempList.add(i); // Add current number to the combination
            // Move to the next element and decrease k by 1
            backtrack(result, tempList, i + 1, n, k - 1);
            // Remove the last element to backtrack
            tempList.remove(tempList.size() - 1);
        }
    }

    // Main method to test the algorithm with example inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(3, 2));
        System.out.println(solution.combine(4, 1));
        System.out.println(solution.combine(5, 3));
    }
}
