import java.util.*;

class Solution {

  // Function to find duplicate numbers in an array.
  public static List<Integer> findNumbers(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] != nums[nums[i] - 1])  // Check if the current element is not in its correct position.
        swap(nums, i, nums[i] - 1);  // Swap the current element with the element at its correct position.
      else
        i++;  // Move to the next element if the current element is already in its correct position.
    }

    List<Integer> duplicateNumbers = new ArrayList<>();
    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1)  // Identify elements that are not in their correct positions, which are duplicates.
        duplicateNumbers.add(nums[i]);  // Add the duplicates to the list.
    }

    return duplicateNumbers;
  }

  // Function to swap two elements in an array.
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    List<Integer> duplicates = Solution.findNumbers(new int[] { 3, 4, 4, 5, 5 });
    System.out.println("Duplicates are: " + duplicates);

    duplicates = Solution.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
    System.out.println("Duplicates are: " + duplicates);
  }
}
