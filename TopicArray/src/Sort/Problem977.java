package Sort;

public class Problem977 {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i += 1) {
            A[i] = A[i] * A[i];
        }
        int left = 0;
        int right = A.length - 1;
        int[] res = new int[A.length];
        int j = A.length - 1;
        while (left <= right) {
            int min;
            if (A[left] <= A[right]) {
                min = A[right];
                right -= 1;
            } else {
                min = A[left];
                left += 1;
            }
            res[j] = min;
            j -= 1;
        }
        return res;
    }
}
