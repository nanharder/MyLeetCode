import java.util.HashSet;

public class Problem532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        if (k == 0) {
            HashSet<Integer> done = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num) && !done.contains(num)) {
                    count += 1;
                    done.add(num);
                }
                set.add(num);
            }
        } else {
            for (int num : nums) {
                if (set.contains(num)) {
                    continue;
                }
                if (set.contains(num + k)) {
                    count += 1;
                }
                if (set.contains(num - k)) {
                    count += 1;
                }
                set.add(num);
            }
        }
        return count;
    }
}
