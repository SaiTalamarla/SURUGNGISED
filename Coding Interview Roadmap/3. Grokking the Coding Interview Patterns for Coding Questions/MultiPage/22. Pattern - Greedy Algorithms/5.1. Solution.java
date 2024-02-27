import java.util.Arrays;

public class Solution {

    public int findLongestChain(int[][] pairs) {
        // Sort pairs based on their second element
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        // Initialize variables
        int currentEnd = Integer.MIN_VALUE;
        int chainCount = 0;

        // Iterate through the pairs
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                // Update currentEnd and increment chainCount
                currentEnd = pair[1];
                chainCount++;
            }
        }

        return chainCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test cases
        int[][] example1 = {{1,2}, {3,4}, {2,3}};
        int[][] example2 = {{5,6}, {1,2}, {8,9}, {2,3}};
        int[][] example3 = {{7,8}, {5,6}, {1,2}, {3,5}, {4,5}, {2,3}};

        System.out.println("Example 1: " + solution.findLongestChain(example1)); // Expected Output: 2
        System.out.println("Example 2: " + solution.findLongestChain(example2)); // Expected Output: 3
        System.out.println("Example 3: " + solution.findLongestChain(example3)); // Expected Output: 3
    }
}
