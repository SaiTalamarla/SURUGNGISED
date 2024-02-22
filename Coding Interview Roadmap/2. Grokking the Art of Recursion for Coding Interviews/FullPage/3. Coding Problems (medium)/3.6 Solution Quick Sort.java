import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> sort(List<Integer> array) {
    quickSort(array, 0, array.size() - 1);
    return array;
  }

  private void quickSort(List<Integer> array, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(array, low, high);
      quickSort(array, low, pivotIndex - 1);
      quickSort(array, pivotIndex + 1, high);
    }
  }

  private int partition(List<Integer> array, int low, int high) {
    int pivot = array.get(high);
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (array.get(j) < pivot) {
        i++;
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
      }
    }

    int temp = array.get(i + 1);
    array.set(i + 1, array.get(high));
    array.set(high, temp);
    
    return i + 1;
  }

    public static void main(String[] args) {
        Solution quickSort = new Solution();
        
        List<Integer>[] examples = new List[]{
                Arrays.asList(4, 2, 6, 8, 3),
                Arrays.asList(10, 5, 3, 7, 2, 8, 6),
                Arrays.asList(1, 2, 3, 4, 5)
        };

        for (int i = 0; i < examples.length; i++) {
            List<Integer> list = examples[i];
            List<Integer> sortedList = quickSort.sort(list);
            System.out.println("Sorted List #" + (i + 1) + ": " + sortedList);
        }
    }
}
