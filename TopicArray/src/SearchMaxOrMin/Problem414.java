package SearchMaxOrMin;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem414 {
    public int thirdMaxV1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                pq.offer(num);
                set.add(num);
            }
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        if (pq.size() == 2) {
            pq.poll();
        }
        return pq.peek();
    }

    public int thirdMaxV2(int[] nums) {
        Integer[] max = new Integer[]{null, null, null};
        for (Integer num : nums) {
            if (num.equals(max[0]) || num.equals(max[1]) || num.equals(max[2])) {
                continue;
            }
            if (max[0] == null || num > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (max[1] == null || num > max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (max[2] == null || num > max[2]) {
                max[2] = num;
            }
        }
        return max[2] == null ? max[0] : max[2];
    }

    public static void main(String[] args) {
        Problem414 p = new Problem414();
        int[] test = new int[]{2,2,3,1};
        p.thirdMaxV2(test);
    }
}
