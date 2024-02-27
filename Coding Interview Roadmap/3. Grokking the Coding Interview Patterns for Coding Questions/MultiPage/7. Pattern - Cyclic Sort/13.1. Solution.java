class Solution {

  // Function to find two numbers that are swapped in the given array
  public static int[] findNumbers(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      // If the current number is not in its correct position, swap it
      if (nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }

    // Iterate through the array to find the first misplaced number
    for (i = 0; i < nums.length; i++)
      if (nums[i] != i + 1)
        return new int[] { nums[i], i + 1 };

    // If no numbers are swapped, return [-1, -1]
    return new int[] { -1, -1 };
  }

  // Function to swap two elements in an array
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = Solution.findNumbers(new int[] { 3, 1, 2, 5, 2 });
    System.out.println(nums[0] + ", " + nums[1]);
    nums = Solution.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
    System.out.println(nums[0] + ", " + nums[1]);
  }
}
