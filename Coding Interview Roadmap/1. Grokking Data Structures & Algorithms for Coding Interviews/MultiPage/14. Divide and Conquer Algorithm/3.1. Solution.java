public class Solution {
    // Function to initiate the divide and conquer algorithm
    public int findMajority(int[] arr) {
        return majorityRec(arr, 0, arr.length - 1);
    }

    // Recursive function to find the majority element in a given segment
    private static int majorityRec(int[] arr, int start, int end) {
        // Base case: if the segment contains only one element
        if (start == end) {
            return arr[start];
        }

        // Find the middle index of the current segment
        int mid = start + (end - start) / 2;

        // Recursively find the majority element in the left and right halves
        int leftMajority = majorityRec(arr, start, mid);
        int rightMajority = majorityRec(arr, mid + 1, end);

        // If both halves agree on the majority element, return it
        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        // Count the occurrences of the left and right majority elements in the current segment
        int leftCount = countOccurrences(arr, leftMajority, start, end);
        int rightCount = countOccurrences(arr, rightMajority, start, end);

        // Return the element with the higher count in the current segment
        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    // Helper function to count the occurrences of a number in a specified range
    private static int countOccurrences(int[] arr, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMajority(new int[]{1, 2, 2, 3, 2})); // Expect 2
        System.out.println(sol.findMajority(new int[]{4, 4, 4, 4, 7, 4, 4})); // Expect 4
        System.out.println(sol.findMajority(new int[]{9, 9, 1, 1, 9, 1, 9, 9})); // Expect 9
    }

}
