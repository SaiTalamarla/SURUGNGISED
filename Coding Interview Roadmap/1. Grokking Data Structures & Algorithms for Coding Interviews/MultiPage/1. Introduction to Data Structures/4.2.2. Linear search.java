public class Solution {
    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 9};
        int x = 7;
        int result = linearSearch(arr, x);
        System.out.println(result != -1 ? "Element found at index " + result : "Element not found");
    }
}
