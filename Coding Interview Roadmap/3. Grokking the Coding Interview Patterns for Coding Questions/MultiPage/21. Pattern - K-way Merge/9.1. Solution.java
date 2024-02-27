import java.util.*;

class Node {
  int elementIndex;
  int arrayIndex;

  Node(int elementIndex, int arrayIndex) {
    this.elementIndex = elementIndex;
    this.arrayIndex = arrayIndex;
  }
}

class Solution {

  public int[] findSmallestRange(List<List<Integer>> lists) {
    PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
        (n1, n2) -> lists.get(n1.arrayIndex).get(n1.elementIndex) -
                    lists.get(n2.arrayIndex).get(n2.elementIndex));

    int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, 
        currentMaxNumber = Integer.MIN_VALUE;
    // put the 1st element of each list in the min heap
    for (int i = 0; i < lists.size(); i++)
      if (lists.get(i) != null) {
        minHeap.add(new Node(0, i));
        currentMaxNumber = Math.max(currentMaxNumber, lists.get(i).get(0));
      }

    // take the smallest (top) element from the min heap, if it gives us a smaller range, 
    // update the ranges, if the list of the top element has more elements, insert the 
    // next element in the heap
    while (minHeap.size() == lists.size()) {
      Node node = minHeap.poll();
      if (rangeEnd - rangeStart > 
            currentMaxNumber - lists.get(node.arrayIndex).get(node.elementIndex)) {
        rangeStart = lists.get(node.arrayIndex).get(node.elementIndex);
        rangeEnd = currentMaxNumber;
      }
      node.elementIndex++;
      if (lists.get(node.arrayIndex).size() > node.elementIndex) {
        minHeap.add(node); // insert the next element in the heap
        currentMaxNumber = Math.max(currentMaxNumber, 
                                    lists.get(node.arrayIndex).get(node.elementIndex));
      }
    }
    return new int[] { rangeStart, rangeEnd };
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    List<Integer> l1 = Arrays.asList(1, 5, 8);
    List<Integer> l2 = Arrays.asList(4, 12);
    List<Integer> l3 = Arrays.asList(7, 8, 10);
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int[] result = sol.findSmallestRange(lists);
    System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
  }
}
