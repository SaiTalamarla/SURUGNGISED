class Solution {
  public int findSingleNumber(int[] arr) {
    int num = 0; // Initialize a variable to store the result
    for (int i = 0; i < arr.length; i++) {
      num = num ^ arr[i]; // Use XOR operation to find the single number
    }
    return num; // Return the found single number
  }

  public static void main(String args[]) {
    Solution sol = new Solution();
    System.out.println(sol.findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3})); // Call the findSingleNumber method with an example array and print the result
  }
}
