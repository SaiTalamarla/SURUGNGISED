import java.util.*;

class Solution {

  public List<Integer> findNumbers(int[] nums, int k) {
    int i = 0;
    
    // Step 1: Rearrange elements in the array to their correct positions
    while (i < nums.length) {
      if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }

    List<Integer> missingNumbers = new ArrayList<>();
    Set<Integer> extraNumbers = new HashSet<>();
    
    // Step 2: Find missing numbers up to 'k' by comparing each element to its position
    for (i = 0; i < nums.length && missingNumbers.size() < k; i++)
      if (nums[i] != i + 1) {
        missingNumbers.add(i + 1);
        extraNumbers.add(nums[i]);
      }

    // Step 3: Add the remaining missing numbers if needed
    for (i = 1; missingNumbers.size() < k; i++) {
      int candidateNumber = i + nums.length;
      
      // Ignore if the array contains the candidate number
      if (!extraNumbers.contains(candidateNumber))
        missingNumbers.add(candidateNumber);
    }

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    List<Integer> missingNumbers = sol.findNumbers(
                                                    new int[] { 3, -1, 4, 5, 5 }, 3);
    System.out.println("Missing numbers: " + missingNumbers);

    missingNumbers = sol.findNumbers(new int[] { 2, 3, 4 }, 3);
    System.out.println("Missing numbers: " + missingNumbers);

    missingNumbers = sol.findNumbers(new int[] { -2, -3, 4 }, 2);
    System.out.println("Missing numbers: " + missingNumbers);
  }
}
