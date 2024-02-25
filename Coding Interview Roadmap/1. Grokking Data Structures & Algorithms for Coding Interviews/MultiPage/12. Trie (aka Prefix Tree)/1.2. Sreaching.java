class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Children nodes
    boolean isEndOfWord; // Flag to represent the end of a word

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Function to search a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                return false; // Word not found
            node = node.children[index];
        }
        return node.isEndOfWord; // Return true if word exists, false otherwise
    }
}
