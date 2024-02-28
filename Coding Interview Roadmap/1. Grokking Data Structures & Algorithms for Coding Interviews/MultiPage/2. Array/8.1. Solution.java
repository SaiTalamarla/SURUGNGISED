public class Solution {
    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] differenceArray = new int[n];
        
        // Calculate leftSum array
        leftSum[0] = nums[0];
        for(int i=1; i<n; i++) {
            leftSum[i] = leftSum[i-1] + nums[i];
        }
        
        // Calculate rightSum array
        rightSum[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            rightSum[i] = rightSum[i+1] + nums[i];
        }
        
        // Calculate differenceArray
        for(int i=0; i<n; i++) {
            differenceArray[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        
        return differenceArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] example1 = {2, 5, 1, 6};
        int[] example2 = {3, 1, 4, 2, 2};
        int[] example3 = {1, 2, 3, 4, 5};
        
        // Output should be: [12, 5, 1, 8]
        printArray(solution.findDifferenceArray(example1));
        // Output should be: [9, 5, 0, 6, 10]
        printArray(solution.findDifferenceArray(example2));
        // Output should be: [14, 11, 6, 1, 10]
        printArray(solution.findDifferenceArray(example3));
    }
    
    // Helper method to print array elements
    public static void printArray(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
