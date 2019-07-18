package MaxProfit;

/**
 * important
 * @source https://blog.csdn.net/zjuPeco/article/details/76468185
 */
public class Problem309 {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int s0 = 0;
        int s1 = -prices[0];
        int s2 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i += 1) {
            int pre0 = s0;
            int pre1 = s1;
            int pre2 = s2;
            s0 = Math.max(pre0, pre2);
            s1 = Math.max(pre0 - prices[i], pre1);
            s2 = pre1 + prices[i];
        }
        return Math.max(s0, s2);
    }
}
