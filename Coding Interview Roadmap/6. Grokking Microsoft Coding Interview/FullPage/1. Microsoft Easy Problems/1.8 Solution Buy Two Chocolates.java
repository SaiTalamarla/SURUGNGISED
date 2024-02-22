import java.util.Arrays;

public class Solution {
    // Calculate the leftover money after buying the two cheapest chocolates
    public int maxLeftover(int[] prices, int money) {
        Arrays.sort(prices); // Sort the prices array
        // Ensure there are at least two chocolates to buy
        if (prices.length < 2 || prices[0] + prices[1] > money) {
            return money; // Return the original amount if not enough to buy two
        }
        return money - (prices[0] + prices[1]); // Subtract the cost of two cheapest chocolates from the money
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] prices1 = {2, 5, 3, 9};
        int money1 = 10;
        System.out.println("Leftover money for Example 1: " + solution.maxLeftover(prices1, money1));
        
        // Example 2
        int[] prices2 = {10, 20, 15, 5, 25, 30, 35, 40};
        int money2 = 50;
        System.out.println("Leftover money for Example 2: " + solution.maxLeftover(prices2, money2));
        
        // Example 3
        int[] prices3 = {7, 1, 5, 3};
        int money3 = 3;
        System.out.println("Leftover money for Example 3: " + solution.maxLeftover(prices3, money3));
    }
}
