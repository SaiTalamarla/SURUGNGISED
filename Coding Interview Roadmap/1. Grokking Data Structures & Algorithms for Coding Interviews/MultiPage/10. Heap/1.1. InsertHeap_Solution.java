import java.util.Arrays;

public class Solution {
    private int[] arr;
    private int size;

    public Solution() {
        arr = new int[10]; // Initial capacity, can be adjusted as needed
        size = 0;
    }

    public void insertMinHeap(int value) {
        /**
         * Insert a new element into the min heap.
         *
         * @param value (int): The value to be inserted into the min heap.
         */
        int n = size;
        if (size >= arr.length) {
            // Double the size of the array if it's full
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[n] = value;
        size++;

        int key = n;
        while (key > 0 && value < arr[(key - 1) / 2]) {
            arr[key] = arr[(key - 1) / 2];
            key = (key - 1) / 2;
        }

        arr[key] = value;
    }

  	//Print the min heap.
    public void printMinHeap() {
        System.out.print("Min Heap: ");
        for (int index = 0; index < size; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution minHeap = new Solution();

        // Test case 1
        minHeap.insertMinHeap(5);
        minHeap.printMinHeap();

        // Test case 2
        minHeap.insertMinHeap(2);
        minHeap.printMinHeap();

        // Test case 3
        minHeap.insertMinHeap(8);
        minHeap.printMinHeap();
    }
}