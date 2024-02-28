class Solution {

  // This method removes duplicates from a sorted integer array and returns the length of the modified array.
  public int remove(int[] arr) {
    int nextNonDuplicate = 1; // Initialize the index of the next non-duplicate element

    // Iterate through the array starting from the second element
    for (int i = 1; i < arr.length; i++) {
      // Check if the current element is different from the previous non-duplicate element
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        // If different, copy the current element to the nextNonDuplicate position
        arr[nextNonDuplicate] = arr[i];
        // Increment the index of the next non-duplicate element
        nextNonDuplicate++;
      }
    }

    // Return the length of the modified array (number of non-duplicate elements)
    return nextNonDuplicate;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(sol.remove(arr)); // Output: 4 (Non-duplicate elements: 2, 3, 6, 9)

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(sol.remove(arr)); // Output: 2 (Non-duplicate elements: 2, 11)
  }
}
