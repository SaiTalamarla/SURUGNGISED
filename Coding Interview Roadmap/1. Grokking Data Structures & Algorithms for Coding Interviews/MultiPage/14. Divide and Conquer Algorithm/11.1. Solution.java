public class Solution {

    // Function to find the median of two sorted arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for efficient binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = nums1.length + nums2.length;
        boolean isEven = totalLength % 2 == 0;

        // Two pointers for each array
        int pointer1 = 0, pointer2 = 0;
        int current = 0, last = 0; // To track the last two elements for median calculation

        // Iterate until the median position is reached
        for (int count = 0; count <= totalLength / 2; count++) {
            last = current;

            // Move pointers and track current value
            if (pointer1 == nums1.length) {
                current = nums2[pointer2++];
            } else if (pointer2 == nums2.length || nums1[pointer1] < nums2[pointer2]) {
                current = nums1[pointer1++];
            } else {
                current = nums2[pointer2++];
            }
        }

        // Median calculation based on total length being odd or even
        return isEven ? (current + last) / 2.0 : current;
    }

    // Main method to test the algorithm with example cases
    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example 1
        int[] nums1Example1 = {1, 3, 5};
        int[] nums2Example1 = {2, 4, 6};
        System.out.println("Median of Example 1: " + sol.findMedianSortedArrays(nums1Example1, nums2Example1));

        // Example 2
        int[] nums1Example2 = {1, 1, 1};
        int[] nums2Example2 = {2, 2, 2};
        System.out.println("Median of Example 2: " + sol.findMedianSortedArrays(nums1Example2, nums2Example2));

        // Example 3
        int[] nums1Example3 = {2, 3, 5, 8};
        int[] nums2Example3 = {1, 4, 6, 7, 9};
        System.out.println("Median of Example 3: " + sol.findMedianSortedArrays(nums1Example3, nums2Example3));
    }
}
