import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Initialize sets to keep track of the numbers in each row, column, and box.
        HashSet<String> rows = new HashSet<>();
        HashSet<String> columns = new HashSet<>();
        HashSet<String> boxes = new HashSet<>();

        // Iterate through each cell in the 9x9 board.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Formulate keys for the row, column, and box.
                    String rowKey = "row" + i + "(" + num + ")";
                    String colKey = "col" + j + "(" + num + ")";
                    String boxKey = "box" + (i / 3 * 3 + j / 3) + "(" + num + ")";
                    // Check the corresponding sets for these keys.
                    if (!rows.add(rowKey) || !columns.add(colKey) || !boxes.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Test the algorithm with three example inputs.
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(sol.isValidSudoku(board1)); // Output: true
    }
}
