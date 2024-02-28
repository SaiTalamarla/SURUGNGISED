class Solution {

  public int[] makeSquares(int[] arr) {
    int n = arr.length;
    int[] squares = new int[n]; // Create an array to store the squared values.
    int highestSquareIdx = n - 1; // Initialize the index to store the highest squared value.
    int left = 0, right = arr.length - 1; // Initialize two pointers, one at the beginning and one at the end of the input array.

    // Iterate over the input array from both ends towards the center.
    while (left <= right) {
      int leftSquare = arr[left] * arr[left]; // Calculate the square of the value at the left pointer.
      int rightSquare = arr[right] * arr[right]; // Calculate the square of the value at the right pointer.

      if (leftSquare > rightSquare) {
        // If the square of the value at the left pointer is greater, store it in the squares array
        // at the current highestSquareIdx and move the left pointer to the right.
        squares[highestSquareIdx--] = leftSquare;
        left++;
      } else {
        // If the square of the value at the right pointer is greater or equal, store it in the squares array
        // at the current highestSquareIdx and move the right pointer to the left.
        squares[highestSquareIdx--] = rightSquare;
        right--;
      }
    }
    return squares; // Return the sorted array of squared values.
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] result = sol.makeSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = sol.makeSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();
  }
}
