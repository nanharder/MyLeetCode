package MaxProfit;

public class Problem123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int res = 0;
        int min = prices[0];
        int[] profit = new int[prices.length];
        for (int i = 1; i < prices.length; i += 1) {
            profit[i] = Math.max(prices[i] - min, profit[i - 1]);
            min = Math.min(prices[i], min);
        }
        int max = prices[prices.length - 1];
        int lastprofit = 0;
        for (int i = prices.length - 2; i >= 0; i -= 1) {
            lastprofit = Math.max(max - prices[i], lastprofit);
            profit[i] += lastprofit;
            max = Math.max(prices[i], max);
            res = Math.max(res, profit[i]);
        }
        return res;
    }

    public int maxProfitV2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] buy = new int[]{0, 0, 0};
        int[] sell = new int[]{-prices[0], -prices[0]};
        for (int i = 1; i < prices.length; i+= 1) {
            int[] lastBuy = buy.clone();
            int[] lastSell = sell.clone();
            sell[0] = Math.max(lastBuy[0] - prices[i], lastSell[0]);
            sell[1] = Math.max(lastBuy[1] - prices[i], lastSell[1]);
            buy[1] = Math.max(lastSell[0] + prices[i], lastBuy[1]);
            buy[2] = Math.max(lastSell[1] + prices[i], lastBuy[2]);
        }
        return Math.max(buy[1], buy[2]);
    }
}
