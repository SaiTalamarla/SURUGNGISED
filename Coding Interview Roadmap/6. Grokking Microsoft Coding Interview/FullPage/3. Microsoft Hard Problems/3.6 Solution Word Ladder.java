import java.util.*;

public class Solution {

  // Utility class to hold a pair of values
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
    // Method to find the shortest transformation sequence length
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return -1; // End word not in list
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1)); // Start with beginWord
        
        while (!queue.isEmpty()) {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int level = current.getValue();
            
            if (word.equals(endWord)) return level; // Found the end word
            
            // Generate all transformations
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArray[i] = ch;
                    String nextWord = new String(wordArray);
                    if (wordSet.contains(nextWord)) {
                        queue.add(new Pair<>(nextWord, level + 1));
                        wordSet.remove(nextWord); // Mark as visited
                    }
                }
            }
        }
        return -1; // Transformation not possible
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ladderLength("cat", "dog", Arrays.asList("cot", "dot", "dog"))); // Example 1
        System.out.println(solution.ladderLength("bit", "pog", Arrays.asList("but", "put", "pig", "pog", "big"))); // Example 2
        System.out.println(solution.ladderLength("sing", "ring", Arrays.asList("ring"))); // Example 3
    }

}
