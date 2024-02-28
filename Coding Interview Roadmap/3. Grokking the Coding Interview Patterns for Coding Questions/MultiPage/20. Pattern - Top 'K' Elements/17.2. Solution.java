import java.util.*;

class Solution {

  public List<Integer> findClosestElements(int[] arr, int K, Integer X) {
    List<Integer> result = new LinkedList<>();
    
    // Find the index of the element closest to X using binary search
    int index = binarySearch(arr, X);
    int leftPointer = index;
    int rightPointer = index + 1;
    
    for (int i = 0; i < K; i++) {
      if (leftPointer >= 0 && rightPointer < arr.length) {
        int diff1 = Math.abs(X - arr[leftPointer]);
        int diff2 = Math.abs(X - arr[rightPointer]);
        
        // Choose the element with the smaller absolute difference
        if (diff1 <= diff2)
          result.add(0, arr[leftPointer--]); // Add to the beginning of the list
        else
          result.add(arr[rightPointer++]); // Add to the end of the list
      } else if (leftPointer >= 0) {
        result.add(0, arr[leftPointer--]);
      } else if (rightPointer < arr.length) {
        result.add(arr[rightPointer++]);
      }
    }
    
    return result;
  }

  private static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target)
        return mid;
      if (arr[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    
    // If the element is not found, return the index where it should be inserted
    if (low > 0) {
      return low - 1;
    }
    return low;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    
    List<Integer> result = sol.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = sol.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = sol.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);
  }
}
