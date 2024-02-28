import java.util.Arrays;

public class Solution {
    // Method to construct the beautiful array
    public int[] beautifulArray(int N) {
        // Base case: if N is 1, return an array with a single element [1]
        if (N == 1) return new int[]{1};

        // Recursively construct the beautiful array for odd and even parts
        int[] odd = beautifulArray((N + 1) / 2);
        int[] even = beautifulArray(N / 2);

        // Initialize the result array of size N
        int[] result = new int[N];

        // Transform and populate the odd part in the result
        for (int i = 0; i < odd.length; i++) {
            result[i] = 2 * odd[i] - 1; // Each odd element is 2*value - 1
        }

        // Transform and populate the even part in the result
        for (int i = 0; i < even.length; i++) {
            result[odd.length + i] = 2 * even[i]; // Each even element is 2*value
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Example 1: N = 4
        int[] result1 = solution.beautifulArray(4);
        System.out.println("Beautiful Array for N = 4: " + Arrays.toString(result1));

        // Test Example 2: N = 3
        int[] result2 = solution.beautifulArray(3);
        System.out.println("Beautiful Array for N = 3: " + Arrays.toString(result2));

        // Test Example 3: N = 8
        int[] result3 = solution.beautifulArray(8);
        System.out.println("Beautiful Array for N = 8: " + Arrays.toString(result3));
    }
}
