import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> nonZeroValues;

    // Constructor to initialize the non-zero values of the vector
    public Solution(int[] nums) {
        nonZeroValues = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Store only non-zero elements with their index
                nonZeroValues.put(i, nums[i]);
            }
        }
    }

    // Method to compute the dot product of two sparse vectors
    public int dotProduct(Solution vec) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : vec.nonZeroValues.entrySet()) {
            if (this.nonZeroValues.containsKey(entry.getKey())) {
                // Multiply and sum only for matching non-zero indices
                result += entry.getValue() * this.nonZeroValues.get(entry.getKey());
            }
        }
        return result;
    }

    // Main method to test the dot product with examples
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
