import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class TrieNode {
//     TrieNode[] children = new TrieNode[26];
//     boolean isEnd = false;
// }

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }

    // Performs a DFS to find all words with the given prefix
    void dfs(TrieNode node, List<String> list, StringBuilder word) {
        if (list.size() == 3) return; // Limit to 3 suggestions
        if (node.isEnd) {
            list.add(word.toString());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.children[ch - 'a'] != null) {
                word.append(ch);
                dfs(node.children[ch - 'a'], list, word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    // Searches the trie for words starting with prefix
    List<String> search(String prefix) {
        TrieNode node = root;
        List<String> list = new ArrayList<>();

        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return list; // No words found with this prefix
            }
            node = node.children[ch - 'a'];
        }

        dfs(node, list, new StringBuilder(prefix));
        return list;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch);
            result.add(trie.search(prefix.toString()));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Example 1
        String[] products1 = {"apple", "apricot", "application"};
        String searchWord1 = "app";
        System.out.println("Example 1: " + solution.suggestedProducts(products1, searchWord1));

        // Test Example 2
        String[] products2 = {"king", "kingdom", "kit"};
        String searchWord2 = "ki";
        System.out.println("Example 2: " + solution.suggestedProducts(products2, searchWord2));

        // Test Example 3
        String[] products3 = {"fantasy", "fast", "festival"};
        String searchWord3 = "farm";
        System.out.println("Example 3: " + solution.suggestedProducts(products3, searchWord3));
    }
}
