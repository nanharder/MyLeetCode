package MaxProfit;

public class Problem121 {
    public int maxProfitV1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i += 1) {
            res = Math.max(prices[i] - min, res);
            min = Math.min(prices[i], min);
        }
        return res;
    }

    public int maxProfitV2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int res = 0;
        int sell = -prices[0];
        for (int i = 1; i < prices.length; i += 1) {
            res = Math.max(sell + prices[i], res);
            sell = Math.max( - prices[i], sell);
        }
        return res;
    }

}
