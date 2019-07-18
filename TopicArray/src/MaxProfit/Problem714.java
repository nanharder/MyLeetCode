package MaxProfit;

public class Problem714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 1) {
            return 0;
        }
        int s1 = -prices[0];
        int s2 = 0;
        for (int i = 1; i < prices.length; i += 1) {
            int pre1 = s1;
            int pre2 = s2;
            s1 = Math.max(pre2 - prices[i], pre1);
            s2 = Math.max(pre1 + prices[i] - fee, pre2);
        }
        return Math.max(s1, s2);
    }
}
