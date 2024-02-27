import java.util.*;

class Solution {

  public List<Integer> findNumbers(int[] nums) {
    int i = 0;  // Initialize a pointer for iterating through the array.
    while (i < nums.length) {
      if (nums[i] != nums[nums[i] - 1])  // Check if the current element is not in its correct position.
        swap(nums, i, nums[i] - 1);  // Swap the elements to their correct positions.
      else
        i++;  // If the current element is in the correct position, move to the next element.
    }

    List<Integer> missingNumbers = new ArrayList<>();
    for (i = 0; i < nums.length; i++)
      if (nums[i] != i + 1)  // Check if the element at index 'i' is not in the correct position.
        missingNumbers.add(i + 1);  // Add the missing number to the list.

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];  // Swap two elements in the array.
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    List<Integer> missing = sol.findNumbers(
      new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
    System.out.println("Missing numbers: " + missing);

    missing = sol.findNumbers(new int[] { 2, 4, 1, 2 });
    System.out.println("Missing numbers: " + missing);

    missing = sol.findNumbers(new int[] { 2, 3, 2, 1 });
    System.out.println("Missing numbers: " + missing);
  }
}
