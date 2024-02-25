import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class TrieNode {
//     TrieNode[] children = new TrieNode[26]; // Array to hold child nodes for each letter
//     boolean isEnd = false; // Flag to mark the end of a word
// }

class Trie {
    TrieNode root = new TrieNode();

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(); // Create a new node if not present
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true; // Mark the end of a word
    }
}

public class Solution {
    public List<List<Integer>> indexPairs(String text, List<String> words) {
        Trie trie = new Trie();
        // Populate the trie with the list of words
        for (String word : words) {
            trie.insert(word);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            TrieNode p = trie.root;
            for (int j = i; j < text.length(); j++) {
                char currentChar = text.charAt(j);
                if (p.children[currentChar - 'a'] == null) {
                    break; // Break if the character is not in the trie
                }
                p = p.children[currentChar - 'a'];
                if (p.isEnd) {
                    result.add(Arrays.asList(i, j)); // Add index pair if word found as a list
                }
            }
        }

        return result; // Return a list of lists containing index pairs
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test examples
        String text1 = "bluebirdskyscraper";
        List<String> words1 = Arrays.asList("blue", "bird", "sky");
        System.out.println(solution.indexPairs(text1, words1));

        String text2 = "programmingisfun";
        List<String> words2 = Arrays.asList("pro", "is", "fun", "gram");
        System.out.println(solution.indexPairs(text2, words2));

        String text3 = "interstellar";
        List<String> words3 = Arrays.asList("stellar", "star", "inter");
        System.out.println(solution.indexPairs(text3, words3));
    }
}
