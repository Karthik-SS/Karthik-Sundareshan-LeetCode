import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleDynamicProgramming {
    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        if (numRows == 1) {
            List<List<Integer>> firstRow = new ArrayList<List<Integer>>(); //new ArrayList<>();
            firstRow.add(Arrays.asList(1));
            return firstRow;
        }

        List<List<Integer>> result = generate(numRows - 1);
        List<Integer> newRow = new ArrayList<>();
        List<Integer> prevRows = result.get(result.size() - 1);

        newRow.add(1);

        for (int j = 1; j < numRows - 1; j++) {
            newRow.add(prevRows.get(j) + prevRows.get(j - 1));
        }

        newRow.add(1);
        result.add(newRow);
        return result;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> answer = generate(numRows);

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
        }
    }
}
