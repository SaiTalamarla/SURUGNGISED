import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Arrays;

public class Solution {
    private int size; // Size of the moving window
    private Queue<Integer> queue; // Queue to store the elements
    private double sum; // Sum of the elements in the current window

    // Constructor to initialize the moving window
    public Solution(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }

    // Method to add a new value and get the moving average
    public double next(int val) {
        queue.add(val); // Add new value to the queue
        sum += val; // Add new value to the sum

        // If the queue size exceeds the window size, remove the oldest element
        if (queue.size() > size) {
            sum -= queue.poll(); // Subtract the oldest value from the sum
        }

        // Return the average of the elements in the current window
        return sum / Math.min(queue.size(), size);
    }

    // Main method to test the algorithm with example inputs
    public static void main(String[] args) {
        List<List<Object>> tests = Arrays.asList(
            Arrays.asList("MovingAverage", "next", "next", "next", "next"),
            Arrays.asList(3, 7, 4, 8, 5)
        );

        Solution movingAverage = null;
        for (int i = 0; i < tests.get(0).size(); i++) {
            String operation = (String) tests.get(0).get(i);
            if (operation.equals("MovingAverage")) {
                movingAverage = new Solution((Integer) tests.get(1).get(i));
                System.out.println("null");
            } else if (operation.equals("next")) {
                // Print the moving average after each next operation
                System.out.println(movingAverage.next((Integer) tests.get(1).get(i)));
            }
        }
    }
}
