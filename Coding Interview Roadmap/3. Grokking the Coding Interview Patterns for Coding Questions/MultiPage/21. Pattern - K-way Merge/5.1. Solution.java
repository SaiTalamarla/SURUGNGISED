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

  public int findKthSmallest(List<List<Integer>> lists, int k) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>(
        (n1, n2) -> lists.get(n1.arrayIndex).get(n1.elementIndex)
                        - lists.get(n2.arrayIndex).get(n2.elementIndex));

    // put the 1st element of each list in the min heap
    for (int i = 0; i < lists.size(); i++) {
      if (!lists.get(i).isEmpty()) {
        minHeap.add(new Node(0, i));
      }
    }

    // take the smallest (top) element from the min heap, if the running count is equal
    // to k, return the number; if the list of the top element has more elements, add the
    // next element to the heap
    int numberCount = 0, result = 0;
    while (!minHeap.isEmpty()) {
      Node node = minHeap.poll();
      result = lists.get(node.arrayIndex).get(node.elementIndex);
      if (++numberCount == k) {
        break;
      }
      node.elementIndex++;
      if (node.elementIndex < lists.get(node.arrayIndex).size()) {
        minHeap.add(node);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    List<Integer> l1 = Arrays.asList(2, 6, 8);
    List<Integer> l2 = Arrays.asList(3, 6, 7);
    List<Integer> l3 = Arrays.asList(1, 3, 4);
    List<List<Integer>> lists = new ArrayList<>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int result = sol.findKthSmallest(lists, 5);
    System.out.print("Kth smallest number is: " + result);
  }
}
