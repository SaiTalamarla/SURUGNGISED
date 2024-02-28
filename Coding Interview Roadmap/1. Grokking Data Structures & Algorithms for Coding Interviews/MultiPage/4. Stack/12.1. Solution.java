import java.util.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    // Method to find the Next Greater Element (NGE) for each element in the list
    List<Integer> nextLargerElement(List<Integer> arr) {
        int n = arr.size();
        Stack<Integer> s = new Stack<>();
        List<Integer> res = new ArrayList<>();

        // Iterate through the list in reverse order
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while they are smaller than or equal to the current element
            while (!s.empty() && s.peek() <= arr.get(i)) {
                s.pop();
            }

            // If the stack is empty, there is no greater element on the right, so set it to -1
            // Otherwise, set it to the top element of the stack
            res.add(s.empty() ? -1 : s.peek());
            
            // Push the current element onto the stack
            s.push(arr.get(i));
        }

        // Reverse the result list to maintain the original order
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(11, 13, 21, 3);
        List<Integer> arr2 = Arrays.asList(4, 5, 2, 25);
        List<Integer> arr3 = Arrays.asList(13, 7, 6, 12);
        Solution nge = new Solution();
        
        // Find and print the Next Greater Element (NGE) for each list
        System.out.println(nge.nextLargerElement(arr));
        System.out.println(nge.nextLargerElement(arr2));
        System.out.println(nge.nextLargerElement(arr3));
    }
}
