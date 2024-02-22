public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            // Check if current, previous, and next spots are empty (or boundaries)
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1; // Plant a flower
                n--; // Decrease the number of flowers needed
            }
        }
        return n <= 0; // Check if all flowers were planted
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the algorithm with the three examples
        System.out.println(solution.canPlaceFlowers(new int[]{0,0,1,0,1,0,0}, 2)); // true
        System.out.println(solution.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2)); // false
        System.out.println(solution.canPlaceFlowers(new int[]{0,0,1,0,0}, 1)); // true
    }
}
