import java.util.*;

public class Solution {
    // Method to calculate the number of flowers in full bloom for each person's query time
    public List<Integer> fullBloomFlowers(int[][] flowers, int[] persons) {
        List<int[]> events = new ArrayList<>();
        // Convert flower bloom intervals into start and end events
        for (int[] flower : flowers) {
            events.add(new int[]{flower[0], 1}); // Start of bloom
            events.add(new int[]{flower[1] + 1, -1}); // End of bloom
        }
        // Sort events by time, then by type of event
        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<Integer> result = new ArrayList<>();
        int blooms = 0;
        // Build a prefix sum array of blooms to efficiently query bloom counts
        int[] prefixSum = new int[events.size()];
        for (int i = 0; i < events.size(); i++) {
            blooms += events.get(i)[1];
            prefixSum[i] = blooms;
        }

        // For each query time, use binary search to find the bloom count
        for (int person : persons) {
            int index = binarySearch(events, person);
            result.add(index < 0 ? 0 : prefixSum[index]);
        }
        return result;
    }

    // Binary search to find the last event that occurs at or before the query time
    private int binarySearch(List<int[]> events, int time) {
        int left = 0, right = events.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events.get(mid)[0] <= time) {
                if (mid == events.size() - 1 || events.get(mid + 1)[0] > time) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Main method to test the algorithm with provided examples
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        int[][] flowers1 = {{1,4},{2,2}};
        int[] persons1 = {2,3};
        System.out.println(solution.fullBloomFlowers(flowers1, persons1)); // Expected: [2,1]
        // Example 2
        int[][] flowers2 = {{5,10},{15,25},{25,30}};
        int[] persons2 = {5,10,15,20,25,30};
        System.out.println(solution.fullBloomFlowers(flowers2, persons2)); // Expected: [1,1,1,1,2,1]
        // Example 3
        int[][] flowers3 = {{1,50},{10,14},{6,10}};
        int[] persons3 = {11,6,3};
        System.out.println(solution.fullBloomFlowers(flowers3, persons3)); // Expected: [2,2,1]
    }
}
