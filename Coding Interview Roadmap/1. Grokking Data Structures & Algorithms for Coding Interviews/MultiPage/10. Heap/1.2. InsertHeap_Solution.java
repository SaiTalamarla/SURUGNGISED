import java.util.Arrays;

public class Solution {
    public static void printMinHeap(int[] arr, int size) {
        // Function to print the min heap
        System.out.print("Min Heap: ");
        for (int index = 0; index < size; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static void heapify(int[] arr, int size, int index) {
        // Function to heapify the min heap from the given index
        int smallestValue = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && arr[leftChild] < arr[smallestValue]) {
            smallestValue = leftChild;
        }

        if (rightChild < size && arr[rightChild] < arr[smallestValue]) {
            smallestValue = rightChild;
        }

        if (smallestValue != index) {
            int temp = arr[index];
            arr[index] = arr[smallestValue];
            arr[smallestValue] = temp;
            heapify(arr, size, smallestValue);
        }
    }

    public static void insertMinHeap(int[] arr, int value, int size) {
        arr[size] = value;
        size++;

        for (int index = size / 2 - 1; index >= 0; index--) {
            heapify(arr, size,index);
        }
    }

    public static void main(String[] args) {
        int[] minHeap = new int[100]; // Assuming max heap size is 100
        int size = 0; // Current size of the heap

        // Test case 1
        insertMinHeap(minHeap, 5, size++);
        printMinHeap(minHeap, size);

        // Test case 2
        insertMinHeap(minHeap, 2, size++);
        printMinHeap(minHeap, size);

        // Test case 3
        insertMinHeap(minHeap, 8, size++);
        printMinHeap(minHeap, size);
    }
}