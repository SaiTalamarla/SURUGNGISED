class Solution {

  public int remove(int[] arr, int key) {
      int nextElement = 0; // Initialize the index of the next element which is not 'key'
      
      // Iterate through the array
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] != key) { // Check if the current element is not equal to 'key'
            arr[nextElement] = arr[i]; // Copy the non-key element to the next available position
            nextElement++; // Increment the index for the next non-key element
        }
      }

      return nextElement; // Return the new length of the modified array
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
      // Test case 1
      int[] arr1 = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
      System.out.println(sol.remove(arr1, 3)); // Output: 4 (After removing 3s, the array becomes {2, 6, 10, 9})

      // Test case 2
      int[] arr2 = new int[] { 2, 11, 2, 2, 1 };
      System.out.println(sol.remove(arr2, 2)); // Output: 2 (After removing 2s, the array becomes {11, 1})
    }
}
