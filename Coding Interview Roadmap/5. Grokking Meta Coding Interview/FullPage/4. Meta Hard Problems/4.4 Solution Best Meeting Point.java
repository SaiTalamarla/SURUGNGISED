import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Method to calculate the minimum total distance
    public int minTotalDistance(int[][] grid) {
        List<Integer> xCoords = new ArrayList<>();
        List<Integer> yCoords = new ArrayList<>();

        // Collecting x and y coordinates of all people
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    xCoords.add(x);
                    yCoords.add(y);
                }
            }
        }

        // Calculate minimum distance separately for x and y coordinates
        return getMinDistance(xCoords) + getMinDistance(yCoords);
    }

    // Helper method to compute minimum distance for a list of coordinates
    private int getMinDistance(List<Integer> coords) {
        Collections.sort(coords);
        int i = 0, j = coords.size() - 1, distance = 0;
        // Reducing the distance from both ends towards the median
        while (i < j) {
            distance += coords.get(j--) - coords.get(i++);
        }
        return distance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testing with Example 1
        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println("Example 1: " + solution.minTotalDistance(grid1));

        // Testing with Example 2
        int[][] grid2 = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
        System.out.println("Example 2: " + solution.minTotalDistance(grid2));

        // Testing with Example 3
        int[][] grid3 = {{1, 1, 0}, {0, 0, 1}, {0, 0, 1}};
        System.out.println("Example 3: " + solution.minTotalDistance(grid3));
    }
}
