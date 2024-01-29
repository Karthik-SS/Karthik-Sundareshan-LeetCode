import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleRecursive {

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(1));
            return result;
        }

        List<List<Integer>> prevRows = generate(numRows - 1);
        List<Integer> newRow = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            newRow.add(1);
        }

        for (int j = 1; j < numRows - 1; j++) {
            newRow.set(j, prevRows.get(prevRows.size() -1).get(j) + prevRows.get(prevRows.size() - 1).get(j - 1));
        }

        prevRows.add(newRow);
        return prevRows;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> answer = generate(numRows);

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
        }
    }
}
