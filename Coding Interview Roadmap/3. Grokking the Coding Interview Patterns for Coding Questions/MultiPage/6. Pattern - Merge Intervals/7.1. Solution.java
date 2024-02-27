import java.util.*;

// class Interval {
//   public int start;
//   public int end;

//   public Interval(int start, int end) {
//     this.start = start;
//     this.end = end;
//   }
// }

class Solution {

  public List<Interval> merge(Interval[] arr1, Interval[] arr2) {
    List<Interval> result = new ArrayList<>();
    int i = 0, j = 0;
    while (i < arr1.length && j < arr2.length) {
      // check if the interval arr[i] intersects with arr2[j]
      // check if one of the interval's start time lies within the other interval
      if ((arr1[i].start >= arr2[j].start && arr1[i].start <= arr2[j].end)
          || (arr2[j].start >= arr1[i].start && arr2[j].start <= arr1[i].end)) {
        // store the intersection part
        result.add(new Interval(Math.max(arr1[i].start, arr2[j].start), 
                                Math.min(arr1[i].end, arr2[j].end)));
      }

      // move next from the interval which is finishing first
      if (arr1[i].end < arr2[j].end)
        i++;
      else
        j++;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), 
                                        new Interval(7, 9) };
    Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
    List<Interval> result = sol.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), 
                              new Interval(9, 12) };
    input2 = new Interval[] { new Interval(5, 10) };
    result = sol.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
  }
}
