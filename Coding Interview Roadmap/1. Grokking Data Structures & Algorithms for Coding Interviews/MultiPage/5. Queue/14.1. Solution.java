import java.util.*;

class Solution {
    private Queue<Iterator<Integer>> queue;

    public Solution(List<Integer> v1, List<Integer> v2) {
        // Initialize a queue to store iterators of non-empty input lists.
        queue = new LinkedList<>();
        // Add iterators for non-empty input lists to the queue.
        if (!v1.isEmpty()) queue.add(v1.iterator());
        if (!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        // Dequeue an iterator, retrieve the next value, and re-enqueue if there are more elements.
        Iterator<Integer> iter = queue.remove();
        int value = iter.next();
        if (iter.hasNext()) queue.add(iter);
        return value;
    }

    public boolean hasNext() {
        // Check if there are more iterators in the queue to process.
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        Solution i = new Solution(Arrays.asList(1, 2), Arrays.asList(3, 4, 5, 6));
        System.out.println(i.next());  // returns 1
        System.out.println(i.next());  // returns 3
        System.out.println(i.next());  // returns 2
        System.out.println(i.next());  // returns 4
        System.out.println(i.next());  // returns 5
        System.out.println(i.next());  // returns 6
        System.out.println(i.hasNext());  // returns false
    }
}
