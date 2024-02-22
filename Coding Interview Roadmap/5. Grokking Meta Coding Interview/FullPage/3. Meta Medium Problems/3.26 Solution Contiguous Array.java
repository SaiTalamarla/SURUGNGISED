import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        // Creating a map to store the balance and its first occurrence index
        Map<Integer, Integer> balanceMap = new HashMap<>();
        balanceMap.put(0, -1); // Adding a base case for balance 0
        int maxLength = 0, cumulativeBalance = 0;

        // Iterating through the array
        for (int i = 0; i < nums.length; i++) {
            cumulativeBalance += (nums[i] == 0) ? -1 : 1;

            // Checking if the current balance is seen before
            if (balanceMap.containsKey(cumulativeBalance)) {
                maxLength = Math.max(maxLength, i - balanceMap.get(cumulativeBalance));
            } else {
                balanceMap.put(cumulativeBalance, i); // Storing the first occurrence of the balance
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Testing the algorithm with the example inputs
        System.out.println(solution.findMaxLength(new int[]{0, 1}));
        System.out.println(solution.findMaxLength(new int[]{1, 1, 0, 0, 1, 1, 0}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 1, 0, 1, 0, 0, 1, 1}));
    }
}
