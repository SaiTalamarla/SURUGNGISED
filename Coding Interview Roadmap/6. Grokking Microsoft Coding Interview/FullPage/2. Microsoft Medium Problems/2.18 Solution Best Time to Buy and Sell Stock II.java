public class Solution {
    // Calculate the maximum profit from stock transactions
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        // Iterate over array to find successive profit opportunities
        for (int i = 1; i < prices.length; i++) {
            // Add to total profit if today's price is higher than yesterday's
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }
        return totalProfit;
    }

    // Test the algorithm with example inputs
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        System.out.println(solution.maxProfit(new int[]{4, 9, 2, 3, 6, 8}));
        // Example 2
        System.out.println(solution.maxProfit(new int[]{5, 3, 6, 2, 5, 4}));
        // Example 3
        System.out.println(solution.maxProfit(new int[]{10, 8, 6, 5, 4, 2}));
    }
}
