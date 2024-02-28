import java.util.*;

class OrderedSetJava {
    private TreeSet<Integer> set;

    public OrderedSetJava(Comparator<Integer> comparator) {
        set = new TreeSet<>(comparator);
    }

    public void add(int element) {
        set.add(element);
    }

    public Integer find_by_order(int k) {
        if (k < 0 || k >= set.size()) return null;
        return (Integer)set.toArray()[k];
    }

    public int order_of_key(int element) {
        return set.headSet(element, true).size();
    }
}

public class Solution {
       public static void main(String[] args) {
        OrderedSetJava orderedSet = new OrderedSetJava(Comparator.reverseOrder());

        orderedSet.add(5);
        orderedSet.add(1);
        orderedSet.add(2);

        System.out.println(orderedSet.find_by_order(1)); // Find 2nd element in reverse order
        System.out.println(orderedSet.order_of_key(3));  // Elements less than or equal to 3 in reverse order
    }
}