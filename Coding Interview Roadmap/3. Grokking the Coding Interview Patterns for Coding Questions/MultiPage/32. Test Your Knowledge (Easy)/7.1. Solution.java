public class Solution {
    public int maxProfit(int[] prices) {
        // Initialize minPrice to the maximum possible integer value
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit to 0
        int maxProfit = 0;
        // Iterate through each price in the prices array
        for (int price : prices) {
            // Update minPrice to be the minimum of minPrice and the current price
            minPrice = Math.min(minPrice, price);
            // Update maxProfit to be the maximum of maxProfit and the difference between the current price and minPrice
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        // Return the final maxProfit
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] example1 = {3, 2, 6, 5, 0, 3};
        int[] example2 = {8, 6, 5, 2, 1};
        int[] example3 = {1, 2};
        System.out.println(solution.maxProfit(example1)); // Output: 4
        System.out.println(solution.maxProfit(example2)); // Output: 0
        System.out.println(solution.maxProfit(example3)); // Output: 1
    }
}
