// class TrieNode {
//     TrieNode[] children = new TrieNode[26];  // Representing each character of the alphabet.
//     boolean isEnd = false;  // To determine if the current TrieNode marks the end of a word.
// }

class Solution {

    // Method to calculate minimum extra characters.
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);  // Building the trie from the dictionary.
        int n = s.length();
        int[] dp = new int[n + 1];  // DP array to store minimum extra characters.

        // Iterate over the string in reverse.
        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;  // Default case: considering current character as extra.

            TrieNode node = root;
            // Try to form words starting from the current position.
            for (int end = start; end < n; end++) {
                if (node.children[s.charAt(end) - 'a'] == null) {
                    break;  // No further word can be formed.
                }
                node = node.children[s.charAt(end) - 'a'];
                if (node.isEnd) {
                    // Update DP if a word is found.
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];  // Minimum extra characters for the entire string.
    }

    // Method to build the trie from the dictionary.
    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();  // Creating new node if not exists.
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;  // Mark the end of a word.
        }
        return root;
    }

    // Main method to test the algorithm with example inputs.
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1
        System.out.println(solution.minExtraChar("amazingracecar", new String[]{"race", "car"})); // Output: 7
        // Test case 2
        System.out.println(solution.minExtraChar("bookkeeperreading", new String[]{"keep", "read"})); // Output: 9
        // Test case 3
        System.out.println(solution.minExtraChar("thedogbarksatnight", new String[]{"dog", "bark", "night"})); // Output: 6
    }
}
