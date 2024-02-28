import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> quickSort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int pivot = arr.get(arr.size() / 2);
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int x : arr) {
            if (x < pivot) left.add(x);
            else if (x > pivot) right.add(x);
            else middle.add(x);
        }
        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(quickSort(left));
        sorted.addAll(middle);
        sorted.addAll(quickSort(right));
        return sorted;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(3, 6, 8, 10, 1, 2, 1);
        List<Integer> sortedArr = quickSort(arr);
        System.out.println("Sorted array: " + sortedArr);
    }
}
