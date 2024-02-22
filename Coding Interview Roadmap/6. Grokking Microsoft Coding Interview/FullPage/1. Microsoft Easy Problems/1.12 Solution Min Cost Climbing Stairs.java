public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Use two variables to store the cost of the last two steps
        int secondLast = cost[0];
        int last = cost[1];
        
        // Start from the third step
        for (int i = 2; i < n; i++) {
            // Calculate the minimum cost for the current step
            int current = cost[i] + Math.min(secondLast, last);
            // Update the last two step costs for the next iteration
            secondLast = last;
            last = current;
        }
        
        // Return the minimum of the costs of the last two steps
        return Math.min(secondLast, last);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{2, 7, 9, 3, 1})); // 10
        System.out.println(solution.minCostClimbingStairs(new int[]{3, 2, 10, 1})); // 3
        System.out.println(solution.minCostClimbingStairs(new int[]{5, 10, 5, 15, 10, 5, 20})); // 25
    }
}
