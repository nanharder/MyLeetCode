package Sort;

public class Problem922 {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;
        while (odd <= A.length - 1 && A[odd] % 2 == 1) {
            odd += 2;
        }
        while (even < A.length && A[even] % 2 == 0) {
            even += 2;
        }
        while (odd <= A.length - 1 && even < A.length) {
            int tmp = A[odd];
            A[odd] = A[even];
            A[even] = tmp;
            while (odd <= A.length - 1 && A[odd] % 2 == 1) {
                odd += 2;
            }
            while (even < A.length && A[even] % 2 == 0) {
                even += 2;
            }
        }
        return A;
    }
}
