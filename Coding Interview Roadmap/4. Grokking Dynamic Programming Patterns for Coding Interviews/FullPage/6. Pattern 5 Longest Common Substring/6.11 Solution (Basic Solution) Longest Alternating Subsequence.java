
class Solution {

  public int findLASLength(int[] nums) {
    // we have to start with two recursive calls, one where we will consider that the first element is
    // bigger than the second element and one where the first element is smaller than the second element
    return Math.max(findLASLengthRecursive(nums, -1, 0, true),
                    findLASLengthRecursive(nums, -1, 0, false));
  }

  private int findLASLengthRecursive(int[] nums, int previousIndex, int currentIndex, boolean isAsc) {
    if(currentIndex == nums.length)
      return 0;

    int c1=0;
    // if ascending, the next element should be bigger
    if(isAsc) {
      if(previousIndex == -1 || nums[previousIndex] < nums[currentIndex])
        c1 = 1 + this.findLASLengthRecursive(nums, currentIndex, currentIndex+1, !isAsc);
    } else { // if descending, the next element should be smaller
    if(previousIndex == -1 || nums[previousIndex] > nums[currentIndex])
      c1 = 1 + this.findLASLengthRecursive(nums, currentIndex, currentIndex+1, !isAsc);
    }
    // skip the current element
    int c2 = this.findLASLengthRecursive(nums, previousIndex, currentIndex+1, isAsc);
    return Math.max(c1,c2);
  }

  public static void main(String[] args) {
    Solution las = new Solution();
    int[] nums = {1,2,3,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{3,2,1,4};
    System.out.println(las.findLASLength(nums));
    nums = new int[]{1,3,2,4};
    System.out.println(las.findLASLength(nums));
  }
}
