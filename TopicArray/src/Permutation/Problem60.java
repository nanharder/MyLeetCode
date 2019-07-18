package Permutation;

import java.util.ArrayList;

public class Problem60 {
    public String getPermutation(int n, int k) {
        int length = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i += 1) {
            length *= i;
            list.add(i);
        }
        list.add(n);
        StringBuilder sb = new StringBuilder();
        for (int j = n - 1; j > 0; j -= 1) {
            int target = (k - 1) / length;
            sb.append(list.get(target));
            list.remove(target);
            k = k % length != 0 ? k % length : length;
            length = length / j;

        }
        sb.append(list.get(0));
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem60 p = new Problem60();
        System.out.println(p.getPermutation(3, 3));
    }
}
