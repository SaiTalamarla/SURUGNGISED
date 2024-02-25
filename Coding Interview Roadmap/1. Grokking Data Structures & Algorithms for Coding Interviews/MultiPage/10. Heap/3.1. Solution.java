import java.util.PriorityQueue;

public class Solution {
    
    public int remainingGifts(int[] gifts, int k) {
        // Create a max heap. We're using a min heap, but by inserting negative numbers, 
        // we effectively convert it into a max heap.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        // Populate the max heap with the negative of gifts' values.
        for (int gift : gifts) {
            maxHeap.add(-gift);
        }
        
        // For the given k operations, we'll remove the pile with the most gifts.
        for (int i = 0; i < k; i++) {
            // Take the pile with the maximum number of gifts (remember it's negative due to our maxHeap approach)
            int current = -maxHeap.poll();
            
            // After taking gifts, we re-insert the pile with reduced gifts into the max heap.
            maxHeap.add(-(int)Math.sqrt(current));
        }

        // Sum up the remaining gifts in all the piles
        int result = 0;
        while (!maxHeap.isEmpty()) {
            result += -maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        // Test the solution with sample test cases
        Solution sol = new Solution();
        System.out.println(sol.remainingGifts(new int[]{4, 9, 16}, 2)); // Expected: 11
        System.out.println(sol.remainingGifts(new int[]{1, 2, 3}, 1)); // Expected: 4
        System.out.println(sol.remainingGifts(new int[]{25, 36, 49}, 3)); // Expected: 18
    }
}
