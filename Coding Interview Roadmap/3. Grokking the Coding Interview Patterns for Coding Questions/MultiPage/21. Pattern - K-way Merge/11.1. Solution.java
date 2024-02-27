import java.util.*;

class Solution {

  public List<List<Integer>> findKLargestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<List<Integer>> minHeap = 
        new PriorityQueue<List<Integer>>((list1, list2) -> 
            (list1.get(0) + list1.get(1)) - (list2.get(0) + list2.get(1)));

    for (int i = 0; i < nums1.length && i < k; i++) {
      for (int j = 0; j < nums2.length && j < k; j++) {
        if (minHeap.size() < k) {
          List<Integer> pair = Arrays.asList(nums1[i], nums2[j]);
          minHeap.add(pair);
        } else {
          int sum = nums1[i] + nums2[j];
          int currentSum = minHeap.peek().get(0) + minHeap.peek().get(1);

          // If the sum of the current pair is smaller than the smallest (top) element of the heap,
          // we can 'break' here. Since the arrays are sorted in descending order,
          // we'll not be able to find a pair with a higher sum moving forward.
          if (sum < currentSum) {
            break;
          } 
          // else: we've a pair with a larger sum, remove the top and insert this pair in the heap
          else {
            minHeap.poll();
            List<Integer> pair = Arrays.asList(nums1[i], nums2[j]);
            minHeap.add(pair);
          }
        }
      }
    }
    
    List<List<Integer>> result = new ArrayList<>(minHeap);
    return result;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    int[] l1 = new int[] { 9, 8, 2 };
    int[] l2 = new int[] { 6, 3, 1 };
    List<List<Integer>> result = sol.findKLargestPairs(l1, l2, 3);
    System.out.print("Pairs with largest sum are: ");
    for (List<Integer> pair : result)
      System.out.print(pair + " ");
  }
}
