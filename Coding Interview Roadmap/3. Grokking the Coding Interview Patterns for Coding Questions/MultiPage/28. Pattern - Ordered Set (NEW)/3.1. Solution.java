import java.util.*;

public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // TreeMap to maintain order of keys (item IDs) and to store sums of values
        Map<Integer, Integer> mergedItems = new TreeMap<>();

        // Process items from the first array
        for (int[] item : items1) {
            mergedItems.put(item[0], mergedItems.getOrDefault(item[0], 0) + item[1]);
        }

        // Process items from the second array
        for (int[] item : items2) {
            mergedItems.put(item[0], mergedItems.getOrDefault(item[0], 0) + item[1]);
        }

        // Convert map entries to a list of lists
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mergedItems.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example inputs
        int[][] items1Example1 = {{1,2}, {4,3}};
        int[][] items2Example1 = {{2,1}, {4,3}, {3,4}};
        System.out.println(solution.mergeSimilarItems(items1Example1, items2Example1));

        int[][] items1Example2 = {{5,5}};
        int[][] items2Example2 = {{5,10}};
        System.out.println(solution.mergeSimilarItems(items1Example2, items2Example2));

        int[][] items1Example3 = {{1,1}, {2,2}};
        int[][] items2Example3 = {{3,3}};
        System.out.println(solution.mergeSimilarItems(items1Example3, items2Example3));
    }
}
