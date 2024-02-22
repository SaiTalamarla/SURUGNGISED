public class Solution {
    private int[] vector;

    // Constructor to store the entire vector
    public Solution(int[] nums) {
        vector = nums;
    }

    // Method to calculate the dot product
    public int dotProduct(Solution vec) {
        int result = 0;
        for (int i = 0; i < vector.length; i++) {
            result += this.vector[i] * vec.vector[i]; // Multiply corresponding elements
        }
        return result;
    }

    public static void main(String[] args) {
        Solution vec1 = new Solution(new int[]{1, 0, 0, 2});
        Solution vec2 = new Solution(new int[]{2, 3, 0, 1});
        System.out.println("Example 1: " + vec1.dotProduct(vec2));

        vec1 = new Solution(new int[]{0, 0, 0, 0});
        vec2 = new Solution(new int[]{1, 1, 1, 1});
        System.out.println("Example 2: " + vec1.dotProduct(vec2));

        vec1 = new Solution(new int[]{1, 0, 0, 2, 3});
        vec2 = new Solution(new int[]{0, 3, 0, 4, 0});
        System.out.println("Example 3: " + vec1.dotProduct(vec2));
    }
}
