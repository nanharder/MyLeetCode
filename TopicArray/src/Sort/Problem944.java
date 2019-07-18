package Sort;

public class Problem944 {
    public int minDeletionSize(String[] A) {
        int len = A[0].length();
        int count = 0;
        for (int j = 0; j < len; j += 1) {
            for (int i = 0; i < A.length - 1; i += 1) {
                if (A[i].charAt(j) > A[i + 1].charAt(j)) {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}
