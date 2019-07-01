import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * get row of Pascal's triangle
 */
public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        int next = 1;
        for (int i = 0; i < rowIndex; i += 1) {
            row[next] = 0;
            for (int j = next; j > 0; j -= 1) {
                row[j] =(row[j] + row[j - 1]);
            }
            next += 1;
        }
        return new ArrayList<>(Arrays.asList(row));
    }
}
