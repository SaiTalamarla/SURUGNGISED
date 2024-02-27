import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize a priority queue
        PriorityQueue<Integer> allocator = new PriorityQueue<>();

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // For all the remaining meeting rooms
        for(int i = 1; i < intervals.length; i++) {
            // If the current meeting starts right after the previous meeting ends, remove it
            if(intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            // If a new room is to be assigned, then also we add to the heap.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minMeetingRooms(new int[][]{{10, 15}, {20, 25}, {30, 35}})); // 1
        System.out.println(sol.minMeetingRooms(new int[][]{{10, 20}, {15, 25}, {24, 30}})); // 2
        System.out.println(sol.minMeetingRooms(new int[][]{{10, 20}, {20, 30}})); // 1
    }
}
