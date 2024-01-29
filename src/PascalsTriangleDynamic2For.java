import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleDynamic2For {

    public static List<List<Integer>> generatePascal(int numRows){
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRows = triangle.get(i - 1);

            row.add(1);

            for(int j = 1; j < i; j++){
                row.add(prevRows.get(j) + prevRows.get(j - 1));
            }

            row.add(1);
            triangle.add(row);
        }
      return triangle;
    }

    public static void main(String[] args) {
        int numRows = 3;
        List<List<Integer>> result = generatePascal(numRows);

        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i)+ ", ");
        }
    }

}
