import java.util.*;

public class Solution {
    // Method to find all shortest transformation sequences
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(end)) return results; // Early return if end word not in dict

        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        dict.add(start);
        
        // Breadth-first search to find the shortest path and build adjacency list
        bfs(start, end, dict, adjList, distances);
        
        // Depth-first search to build paths from start to end
        List<String> path = new ArrayList<>();
        path.add(start);
        dfs(start, end, adjList, distances, path, results);
        
        return results;
    }
    
    // BFS to calculate shortest distance from start to all words and build adjacency list
    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> adjList, Map<String, Integer> distances) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distances.put(start, 0);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String next : getNeighbors(current, dict)) {
                adjList.putIfAbsent(current, new ArrayList<>());
                adjList.get(current).add(next);
                if (!distances.containsKey(next)) {
                    distances.put(next, distances.get(current) + 1);
                    if (!end.equals(next)) { // Avoid adding end word to queue to stop BFS
                        queue.offer(next);
                    }
                }
            }
        }
    }
    
    // DFS to find all paths from start to end based on distances and adjacency list
    private void dfs(String current, String end, Map<String, List<String>> adjList, Map<String, Integer> distances, List<String> path, List<List<String>> results) {
        if (current.equals(end)) {
            results.add(new ArrayList<>(path));
            return;
        }
        
        if (!adjList.containsKey(current)) return;
        
        for (String next : adjList.get(current)) {
            if (distances.get(next) == distances.get(current) + 1) { // Check if next is part of the shortest path
                path.add(next);
                dfs(next, end, adjList, distances, path, results);
                path.remove(path.size() - 1); // Backtrack
            }
        }
    }
    
    // Generate all possible next words by changing one letter at a time
    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String nextWord = new String(chars);
                if (dict.contains(nextWord)) {
                    neighbors.add(nextWord);
                }
            }
            chars[i] = old; // Restore original word
        }
        return neighbors;
    }

    // Main method to test the algorithm with provided examples
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        System.out.println(solution.findLadders("cat", "dog", Arrays.asList("dat", "dot", "dog")));
        // Example 2
        System.out.println(solution.findLadders("bit", "fog", Arrays.asList("but", "put", "big", "pot", "pog", "dog")));
        // Revised Example 3
        System.out.println(solution.findLadders("hot", "cog", Arrays.asList("dot", "dog", "lot", "log", "cog")));
    }
}
