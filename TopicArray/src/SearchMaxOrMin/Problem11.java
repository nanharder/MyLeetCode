package SearchMaxOrMin;

public class Problem11 {
    public int maxAreaV1(int[] height) {
        int globalMax = 0;
        for (int left = 0; left < height.length - 1; left += 1) {
            int right = height.length - 1;
            while (right > left) {
                if (height[right] >= height[left]) {
                    globalMax = Math.max(globalMax, height[left] * (right - left));
                    break;
                }
                globalMax = Math.max(globalMax, height[right] * (right - left));
                right -= 1;
            }
        }
        return globalMax;
    }

    public int maxAreaV2(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left += 1;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right -= 1;
            }
        }
        return max;
    }

}
