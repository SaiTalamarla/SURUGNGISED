public class Solution {
    public static int countOccurrences(int[] arr, int key) {
        return countOccurrencesHelper(arr, key, 0);
    }

    private static int countOccurrencesHelper(int[] arr, int key, int index) {
        // Base case: If the array is empty, return 0
        if (index >= arr.length) {
            return 0;
        }

        // Check if the current element is equal to the key element
        int count = arr[index] == key ? 1 : 0;

        // Recursive call with the remaining subarray
        int totalCount = count + countOccurrencesHelper(arr, key, index + 1);

        return totalCount;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 4};
        int key1 = 4;
        System.out.println("Occurrences in arr1: " + countOccurrences(arr1, key1));

        int[] arr2 = {1, 3, 5, 7, 9};
        int key2 = 2;
        System.out.println("Occurrences in arr2: " + countOccurrences(arr2, key2));

        int[] arr3 = {1, 2, 2, 2, 3};
        int key3 = 2;
        System.out.println("Occurrences in arr3: " + countOccurrences(arr3, key3));
    }
}
