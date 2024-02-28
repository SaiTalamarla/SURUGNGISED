import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncomingEdge = new boolean[n];

        // Determine nodes with incoming edges
        for (List<Integer> edge : edges) {
            hasIncomingEdge[edge.get(1)] = true;
        }

        List<Integer> result = new ArrayList<>();
        // Gather nodes without incoming edges
        for (int i = 0; i < n; i++) {
            if (!hasIncomingEdge[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        List<List<Integer>> edges1 = List.of(List.of(0,1), List.of(0,2), List.of(2,5), List.of(3,4), List.of(4,2));
        System.out.println(solution.findSmallestSetOfVertices(6, edges1));  // Expected: [0, 3]

        List<List<Integer>> edges2 = List.of(List.of(0,1), List.of(3,1), List.of(1,2));
        System.out.println(solution.findSmallestSetOfVertices(4, edges2));  // Expected: [0, 3]

        List<List<Integer>> edges3 = List.of(List.of(2,0), List.of(3,2));
        System.out.println(solution.findSmallestSetOfVertices(4, edges3));  // Expected: [1, 3]
    }
}
