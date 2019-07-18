package SubArray;

public class Problem978 {
    public int maxTurbulenceSizeV1(int[] A) {
        int res = 1;
        int size1 = 1;
        int size2 = 1;
        for (int i = 0; i < A.length - 1; i += 1) {
            if (A[i] == A[i + 1]) {
                size1 = 1;
                size2 = 1;
            } else if (((i % 2 == 0) && (A[i] < A[i + 1])) || (!(i % 2 == 0) && A[i] > A[i + 1])) {
                size1 += 1;
                size2 = 1;
            } else {
                size2 += 1;
                size1 = 1;
            }
            res = Math.max(res, size1);
            res = Math.max(res, size2);
        }
        return res;
    }

    public int maxTurbulenceSizeV2(int[] A) {
        int res = 1;
        int start = 0;

        for (int i = 1; i < A.length; i += 1) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (c == 0) {
                start = i;
            } else if (i == A.length - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                res = Math.max(res, i - start + 1);
                start = i;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] test = new int[]{9,4,2,10,7,8,8,1,9};
        Problem978 p = new Problem978();
        System.out.println(p.maxTurbulenceSizeV2(test));
    }

}
