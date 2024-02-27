// class TrieNode {
//     TrieNode[] children = new TrieNode[26];  // Representing each character of the alphabet.
//     boolean isEnd = false;  // To determine if the current TrieNode marks the end of a word.
// }

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();  // Initialize root node.
    }

    // Function to add a word into the trie structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {  // If the child node doesn't exist, create it.
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];  // Move to the child node.
        }
        node.isEnd = true;  // Mark the end of the word.
    }

    // Function to search a word, considering '.' as a wildcard.
    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                // If it's a wildcard, recursively search for all possible characters.
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                // If the character doesn't exist, return false.
                if (node.children[ch - 'a'] == null) return false;
                node = node.children[ch - 'a'];  // Move to the next node.
            }
        }
        return node.isEnd;  // Return if we're at the end of a valid word.
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.addWord("apple");
        obj.addWord("banana");
        System.out.println(obj.search("apple"));  // true
        System.out.println(obj.search("....."));  // true
    }
}
