import java.util.*;

public class Solution {
    // Function to transform the array into its rank form
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int[] sortedArr = arr.clone(); // Cloning the array to keep the original order
        Arrays.sort(sortedArr); // Sorting the cloned array
        int rank = 1;
        // Assign ranks to each unique element
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        // Replace each element in the original array with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }

    // Main function to test the solution with example inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] examples = {
            {10, 20, 20, 30},
            {100, 2, 70, 2},
            {5, 5, 5, 5}
        };
        for (int[] example : examples) {
            System.out.println("Input: " + Arrays.toString(example));
            System.out.println("Output: " + Arrays.toString(solution.arrayRankTransform(example)));
            System.out.println();
        }
    }
}
