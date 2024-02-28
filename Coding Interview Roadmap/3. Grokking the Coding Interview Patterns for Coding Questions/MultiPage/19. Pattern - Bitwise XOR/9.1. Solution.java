class Solution {
  public int[][] flipAndInvertImage(int[][] arr) {
      int C = arr[0].length;  // Get the number of columns in the input matrix
      for (int[] row: arr) {  // Iterate through each row in the matrix
          for (int i = 0; i < (C + 1) / 2; ++i) {  // Iterate through the first half of each row
              int tmp = row[i] ^ 1;  // Invert the current element and store it in tmp
              row[i] = row[C - 1 - i] ^ 1;  // Invert and swap elements symmetrically from the beginning and end of the row
              row[C - 1 - i] = tmp;  // Update the end element with the temporary value
          }
      }
      return arr;  // Return the modified matrix
  }

  public static void print(int[][] arr) {
    for(int i=0; i < arr.length; i++) {  // Iterate through rows
      for (int j=0; j < arr[i].length; j++) {  // Iterate through columns in each row
        System.out.print(arr[i][j] + " ");  // Print the element at (i, j)
      }
      System.out.println();  // Move to the next line after each row is printed
    }
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};  // Input matrix
    print(sol.flipAndInvertImage(arr));  // Call the flipAndInvertImage method and print the result
    System.out.println();  // Print an empty line

    int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};  // Input matrix
    print(sol.flipAndInvertImage(arr2));  // Call the flipAndInvertImage method and print the result
  }
}
