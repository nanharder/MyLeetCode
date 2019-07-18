package Sort;

public class Problem905 {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        while (left < A.length && A[left] % 2 == 0) {
            left += 1;
        }
        int right = A.length - 1;
        while (right >= 0 && A[right] % 2 == 1) {
            right -= 1;
        }
        while (left < right) {
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            while (left < A.length && A[left] % 2 == 0) {
                left += 1;
            }
            while (right >= 0 && A[right] % 2 == 1) {
                right -= 1;
            }
        }
        return A;
    }
}
