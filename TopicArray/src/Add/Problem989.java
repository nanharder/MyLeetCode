package Add;

import java.util.LinkedList;
import java.util.List;

public class Problem989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException();
        }
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        for (int i = A.length - 1; i >= 0; i -= 1) {
            int sum = carry;
            sum += A[i];
            sum += K % 10;
            K = K / 10;
            result.addFirst(sum % 10);
            carry = sum / 10;
        }
        int remain = K + carry;
        while (remain > 0) {
            result.addFirst(remain % 10);
            remain = remain / 10;
        }
        return result;
    }
}
