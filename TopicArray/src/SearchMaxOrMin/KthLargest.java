package SearchMaxOrMin;

import java.util.PriorityQueue;

/**
 * problem703
 */
public class KthLargest {
    private int k;
    private PriorityQueue<Integer> max;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        max = new PriorityQueue<>();
        for (int num : nums) {
            max.offer(num);
            if (max.size() > k) {
                max.poll();
            }
        }
    }


    public int add(int val) {
        if (max.size() < k) {
            max.offer(val);
        }else if (val > max.peek()) {
            max.offer(val);
            max.poll();
        }
        return max.peek();
    }

    public static void main(String[] args) {
        int[] t = new int[]{4,5,8,2};
        KthLargest test = new KthLargest(3, t);
        test.add(3);
    }
}

