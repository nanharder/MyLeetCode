package SearchSpecialNumber;

import java.util.HashMap;

public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < k) {
            HashMap<Long, Long> map = new HashMap<>();
            for (int i = 0; i < nums.length; i += 1) {
                long target = (long) nums[i];
                for (long j = target - t; j <= target + t; j += 1) {
                    if (map.containsKey(j) && Math.abs(map.get(j) - i) <= k) {
                        return true;
                    }
                }
                map.put((long) nums[i], (long) i);
            }
        } else {
            for (int i = 0; i < nums.length; i += 1) {
                for (int j = i + 1; j <= i + k; j += 1) {
                    if (j < nums.length && Math.abs((long) nums[j] - (long) nums[i]) <= t) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
