import java.util.Arrays;

public class Solution {
    public static int[] mergeSort(int[] arr) {
      mergeSortRecursive(arr, 0, arr.length - 1);
      return arr;
    }
    
    public static void mergeSortRecursive(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortRecursive(arr, start, mid); // Recursive call for the left half
            mergeSortRecursive(arr, mid + 1, end); // Recursive call for the right half
            merge(arr, start, mid, end); // Merge the sorted halves
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i)
            left[i] = arr[start + i];
        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 1, 6};

        System.out.println("Input Array:");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
