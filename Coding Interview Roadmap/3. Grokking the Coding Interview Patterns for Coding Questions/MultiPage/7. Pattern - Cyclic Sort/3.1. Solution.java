public class Solution {

  public int[] sort(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      int j = nums[i] - 1; // Calculate the index where the current element should be placed.
      if (nums[i] != nums[j]) // Check if the current element is not in its correct position.
        swap(nums, i, j); // Swap the current element with the one at its correct position.
      else
        i++; // If the current element is already in its correct position, move to the next element.
    }
    return nums;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] arr = new int[] { 3, 1, 5, 4, 2 };
    arr = sol.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");
    System.out.println();

    arr = new int[] { 2, 6, 4, 3, 1, 5 };
    arr = sol.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");
    System.out.println();

    arr = new int[] { 1, 5, 6, 4, 3, 2 };
    arr = sol.sort(arr);
    for (int num : arr)
      System.out.print(num + " ");
    System.out.println();
  }
}
