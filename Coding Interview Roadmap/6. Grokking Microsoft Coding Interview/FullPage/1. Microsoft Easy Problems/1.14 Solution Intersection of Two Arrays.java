import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        // Add elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }
        // Add elements of nums2 to set2
        for (int num : nums2) {
            set2.add(num);
        }
        // Manually find intersection
        Set<Integer> intersection = new HashSet<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersection.add(num);
            }
        }
        // Convert intersection set to an array
        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{3,1,2,6,7,8}, new int[]{2,3,4,5,7,9})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{1,2,3}, new int[]{4,5,6})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{7,8,9,10}, new int[]{10,9,8,7})));
    }
}
