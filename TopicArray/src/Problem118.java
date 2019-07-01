import java.util.ArrayList;
import java.util.List;

/**
 * generate Pascals's triangle I
 */
public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        ArrayList<Integer> base = new ArrayList<>();
        base.add(1);
        triangle.add(base);
        for (int i = 1; i < numRows; i += 1) {
            List<Integer> engine = triangle.get(triangle.size() - 1);
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < engine.size() - 1; j += 1) {
                row.add(engine.get(j) + engine.get(j + 1));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
