import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        // Base Case: No rows to generate
        if (numRows == 0) {
            return new ArrayList<>();
        }

        // Base Case: First row of Pascal's Triangle
        if (numRows == 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<List<Integer>> triangle = new ArrayList<>();
            triangle.add(row);
            return triangle;
        }

        // Recursive Case: Generate previous row and calculate current row
        List<List<Integer>> triangle = generatePascalTriangle(numRows - 1);
        List<Integer> prevRow = triangle.get(numRows - 2);
        List<Integer> currRow = new ArrayList<>();
        currRow.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            int sum = prevRow.get(i - 1) + prevRow.get(i);
            currRow.add(sum);
        }
        currRow.add(1);
        triangle.add(currRow);

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> pascalTriangle = generatePascalTriangle(numRows);
        System.out.println("Pascal's Triangle for " + numRows + " rows:");
        for (List<Integer> row : pascalTriangle) {
            System.out.println(row);
        }
    }
}
