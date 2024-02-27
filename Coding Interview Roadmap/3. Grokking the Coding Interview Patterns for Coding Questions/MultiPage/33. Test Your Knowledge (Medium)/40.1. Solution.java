import java.util.HashSet;

public class Solution {

    public int longestConsecutive(int[] nums) {
        // Using a HashSet to store numbers for constant time lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestSequence = 0;
        for (int num : set) {
            // Checking if current number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Extend the streak for as long as possible
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Keep track of the longest streak
                longestSequence = Math.max(longestSequence, currentStreak);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{10, 11, 14, 12, 13})); // 5
        System.out.println(sol.longestConsecutive(new int[]{3, 6, 4, 100, 101, 102})); // 3
        System.out.println(sol.longestConsecutive(new int[]{7, 8, 10, 11, 15})); // 2
    }
}
