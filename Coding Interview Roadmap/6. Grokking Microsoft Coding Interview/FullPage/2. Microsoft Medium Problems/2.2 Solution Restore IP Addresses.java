import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Method to restore IP addresses from a given string
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }

    // Backtracking method to explore all combinations
    private void backtrack(List<String> result, String s, int start, String current, int dotCount) {
        // If reached the end of the string and exactly 3 dots have been placed
        if (start == s.length() && dotCount == 4) {
            result.add(current.substring(0, current.length() - 1)); // Remove last dot before adding to result
            return;
        }
        // If more than 4 segments or end of string is reached before placing all dots, stop backtracking
        if (dotCount > 4) return;
        for (int i = 1; i <= 3; i++) { // Check next 1 to 3 characters
            if (start + i > s.length()) break; // If exceeds length, stop
            String part = s.substring(start, start + i);
            if ((part.startsWith("0") && part.length() > 1) || (i == 3 && Integer.parseInt(part) > 255)) continue; // Skip invalid segments
            backtrack(result, s, start + i, current + part + ".", dotCount + 1); // Recurse with next segment
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test the algorithm with the provided examples
        System.out.println(solution.restoreIpAddresses("11211"));
        System.out.println(solution.restoreIpAddresses("1111"));
        System.out.println(solution.restoreIpAddresses("0000"));
    }
}
