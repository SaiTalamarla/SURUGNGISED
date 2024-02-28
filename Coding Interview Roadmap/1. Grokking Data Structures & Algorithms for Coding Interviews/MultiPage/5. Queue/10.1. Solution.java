import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String[] generateBinaryNumbers(int n) {
        Queue<String> q = new LinkedList<String>();
        q.add("1");  // Initialize the queue with "1".

        String[] res = new String[n];  // Create an array to store the binary numbers.
        for (int i = 0; i < n; i++) {
            res[i] = q.poll();  // Dequeue the current binary number and add it to the result array.
            q.add(res[i] + "0");  // Enqueue the next binary number by appending "0".
            q.add(res[i] + "1");  // Enqueue the next binary number by appending "1".
        }

        return res;  // Return the array containing binary numbers.
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] binaryNums = sol.generateBinaryNumbers(5);  // Generate binary numbers for testing.
        for (String binaryNum : binaryNums) {
            System.out.println(binaryNum);  // Print each generated binary number.
        }
    }
}
