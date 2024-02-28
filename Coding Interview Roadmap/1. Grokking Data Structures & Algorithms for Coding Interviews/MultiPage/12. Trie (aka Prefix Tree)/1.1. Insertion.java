class TrieNode {
    TrieNode[] children = new TrieNode[26]; // Array to store children nodes for each character
    boolean isEndOfWord; // Flag to indicate if this node is the end of a word

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}

public class Trie {
    private TrieNode root; // Root of the Trie

    public Trie() {
        root = new TrieNode();
    }

    // Function to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Convert character to index
            if (node.children[index] == null)
                node.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }
}
