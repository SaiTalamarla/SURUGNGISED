class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;  // Initialize maxWealth to 0
        // Loop through each customer's accounts
        for (int[] customer : accounts) {
            int wealth = 0;  // Variable to store the wealth of the current customer
            // Loop through each account of the current customer and sum them up
            for (int account : customer) {
                wealth += account;
            }
            // Update maxWealth if the current customer's wealth is greater
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        // Return the maximum wealth found
        return maxWealth;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example test cases
        System.out.println(sol.maximumWealth(new int[][]{{5,2,3},{0,6,7}}));  // 13
        System.out.println(sol.maximumWealth(new int[][]{{1,2},{3,4},{5,6}}));  // 11
        System.out.println(sol.maximumWealth(new int[][]{{10,100},{200,20},{30,300}}));  // 330
    }
}
