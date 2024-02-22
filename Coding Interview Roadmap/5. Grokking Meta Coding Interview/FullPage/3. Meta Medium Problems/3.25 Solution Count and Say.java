public class Solution {
    public String countAndSay(int n) {
        // Base string for the sequence
        String result = "1";

        // Building each string in the sequence
        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);

            // Iterating over the string
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prev) {
                    count++;
                } else {
                    // Appending the count and previous character
                    current.append(count).append(prev);
                    prev = result.charAt(j);
                    count = 1;
                }
            }
            // Appending the last counted character
            current.append(count).append(prev);
            result = current.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(3)); // "21"
        System.out.println(solution.countAndSay(4)); // "1211"
        System.out.println(solution.countAndSay(5)); // "111221"
    }
}
