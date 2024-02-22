import java.util.ArrayList;
import java.util.List;

// NestedInteger class represents either a single integer or a nested list of integers
class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;
    private boolean isSingleInteger;

    // Constructor for a single integer
    public NestedInteger(int value) {
        this.value = value;
        this.isSingleInteger = true;
    }

    // Constructor for an empty nested list
    public NestedInteger() {
        this.list = new ArrayList<>();
        this.isSingleInteger = false;
    }

    // Returns true if this NestedInteger holds a single integer
    public boolean isInteger() {
        return isSingleInteger;
    }

    // Returns the single integer that this NestedInteger holds, if it holds a single integer
    public Integer getInteger() {
        return isSingleInteger ? value : null;
    }

    // Adds a NestedInteger to this nested list
    public void add(NestedInteger ni) {
        if (!isSingleInteger) {
            this.list.add(ni);
        }
    }

    // Returns the nested list that this NestedInteger holds, if it holds a nested list
    public List<NestedInteger> getList() {
        return isSingleInteger ? new ArrayList<>() : list;
    }
}

// Solution class with a method to calculate the nested list weight sum
public class Solution {

    // Calculates the sum of integers in the nested list, weighted by their depth
    private int nestedSum(List<NestedInteger> nestedList, int depth) {
        int totalSum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                // If it's a single integer, add its value multiplied by its depth
                totalSum += ni.getInteger() * depth;
            } else {
                // If it's a nested list, recursively calculate its sum
                totalSum += nestedSum(ni.getList(), depth + 1);
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Modified Example 1: [[2, [3, 4]], [5, 6], 7]
        // Creating the nested list structure
        NestedInteger list1Sublist = new NestedInteger();
        list1Sublist.add(new NestedInteger(3));
        list1Sublist.add(new NestedInteger(4));

        NestedInteger list1 = new NestedInteger();
        list1.add(new NestedInteger(2));
        list1.add(list1Sublist);

        NestedInteger list2 = new NestedInteger();
        list2.add(new NestedInteger(5));
        list2.add(new NestedInteger(6));

        List<NestedInteger> modExample1 = new ArrayList<>();
        modExample1.add(list1);
        modExample1.add(list2);
        modExample1.add(new NestedInteger(7));

        // Calculating and printing the sum
        System.out.println("Output: " + solution.nestedSum(modExample1, 1));
    }
}
