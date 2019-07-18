public class Problem1004 {
    public int longestOnes(int[] A, int K) {
        int max = 0;
        int zeroCount = 0;
        int start = 0;
        for (int end = 0; end < A.length; end += 1) {
            if (A[end] == 0) {
                zeroCount += 1;
            }
            while (zeroCount > K) {
                if (A[start] == 0) {
                    zeroCount -= 1;
                }
                start += 1;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
