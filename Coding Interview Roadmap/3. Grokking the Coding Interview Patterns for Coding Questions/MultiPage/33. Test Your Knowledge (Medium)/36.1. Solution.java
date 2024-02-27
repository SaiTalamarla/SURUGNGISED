import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict into a set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Initialize dp array with false values and set the first value to true
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // Iterate over the string
        for (int i = 1; i <= s.length(); i++) {
            // For each position, check all possible words that end at this position
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // Return if the entire string can be segmented or not
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("ilovecoding", Arrays.asList("i", "love", "coding"))); // true
        System.out.println(sol.wordBreak("helloworld", Arrays.asList("hello", "world", "hell", "low"))); // true
        System.out.println(sol.wordBreak("enjoylife", Arrays.asList("enj", "life", "joy"))); // false
    }
}
