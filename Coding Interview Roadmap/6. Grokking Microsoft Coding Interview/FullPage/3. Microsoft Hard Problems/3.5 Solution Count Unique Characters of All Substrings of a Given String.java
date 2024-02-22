import java.util.Arrays;

public class Solution {
    public int uniqueLetterString(String S) {
        int[][] index = new int[26][2]; // Stores last two positions for each character
        for (int i = 0; i < 26; ++i) Arrays.fill(index[i], -1); // Initialize with -1
        int res = 0, N = S.length(), mod = 1000000007; // Result, string length, and mod value for avoiding overflow

        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A'; // Convert char to index 0-25
            // Update result based on positions stored in index for this character
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            // Update last two positions for this character
            index[c] = new int[] {index[c][1], i};
        }

        // Adjust result for each character considering the string's end
        for (int c = 0; c < 26; ++c)
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueLetterString("AAC")); // Example input
        System.out.println(solution.uniqueLetterString("AAA")); // Example input
        System.out.println(solution.uniqueLetterString("ABCA")); // Example input
    }
}
