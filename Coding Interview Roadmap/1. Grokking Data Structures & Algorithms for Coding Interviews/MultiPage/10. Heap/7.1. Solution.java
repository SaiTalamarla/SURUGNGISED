import java.util.PriorityQueue;

public class Solution {
    public int connectSticks(int[] sticks) {
        // Initialize a priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add all sticks to the priority queue
        for (int stick : sticks) {
            minHeap.add(stick);
        }
        
        int cost = 0;
        
        // Continue until there's only one stick left
        while (minHeap.size() > 1) {
            int first = minHeap.poll();  // Get the smallest stick
            int second = minHeap.poll(); // Get the second smallest stick
            
            // Combine the two sticks
            int combined = first + second;
            cost += combined;
            
            // Add the combined stick back into the minHeap
            minHeap.add(combined);
        }
        
        return cost;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.connectSticks(new int[]{1, 2, 3, 4})); // Expected: 19
        System.out.println(sol.connectSticks(new int[]{3, 4, 5}));    // Expected: 19
        System.out.println(sol.connectSticks(new int[]{5, 2, 9, 12}));// Expected: 51
    }
}
