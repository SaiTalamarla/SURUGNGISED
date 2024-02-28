import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the array in ascending order
        int i = 0; // Pointer for the lightest person
        int j = people.length - 1; // Pointer for the heaviest person
        int boats = 0; // Count of boats

        while (i < j) {
            if (people[i] + people[j] <= limit) {
                // If the lightest and heaviest person can share a boat
                i++; // Move to the next lightest person
            }
            j--; // Move to the next heaviest person
            boats++; // Increment boat count
        }
        // When last person is left.
        if(i == j) {
            boats++;
        }
        return boats; // Return the total number of boats needed
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] people = {10, 55, 70, 20, 90, 85};
        int limit = 100;

        int result = solution.numRescueBoats(people, limit);
        System.out.println("Minimum number of boats required: " + result);
        // Expected output: "Minimum number of boats required: 2"
    }
}
