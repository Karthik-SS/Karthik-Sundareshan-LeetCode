import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveNQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> answer = new ArrayList<List<String>>();
        answer = solveNQueens(n);

        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
    private static int size;
    private static List<List<String>> solutions = new ArrayList<List<String>>();

    public static List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(
                0,
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                emptyBoard
        );
        return solutions;
    }

    // Making use of a helper function to get the
    // solutions in the correct output format
    private static List<String> createBoard(char[][] slate) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(slate[row]);
            board.add(current_row);
        }

        return board;
    }

    private static void backtrack(
            int row,
            Set<Integer> diagonals,
            Set<Integer> antiDiagonals,
            Set<Integer> cols,
            char[][] slate
    ) {
        // Base case - N queens have been placed
        if (row == size) {
            solutions.add(createBoard(slate));
            return;
        }

        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            // If the queen is not placeable
            if (
                    cols.contains(col) ||
                            diagonals.contains(currDiagonal) ||
                            antiDiagonals.contains(currAntiDiagonal)
            ) {
                continue;
            }

            // "Add" the queen to the board
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            slate[row][col] = 'Q';

            // Move on to the next row with the updated board state
            backtrack(row + 1, diagonals, antiDiagonals, cols, slate);

            // "Remove" the queen from the board since we have already
            // explored all valid paths using the above function call
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            slate[row][col] = '.';
        }
    }
}
