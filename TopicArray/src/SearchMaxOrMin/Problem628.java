package SearchMaxOrMin;

public class Problem628 {
    /**
     * change array to int could be faster
     */
    public int maximumProduct(int[] nums) {
        Integer[] max = new Integer[]{null, null, null};
        Integer[] min = new Integer[]{null, null};
        for (Integer num : nums) {
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

            if (min[0] == null || num < min[0]) {
                min[1] = min[0];
                min[0] = num;
            } else if (min[1] == null || num < min[1]) {
                min[1] = num;
            }
        }

        return Math.max(max[0] * max[1] * max[2], max[0] * min[0] * min[1]);
    }
}
