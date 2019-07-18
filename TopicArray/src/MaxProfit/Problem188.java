package MaxProfit;

import java.util.Arrays;

public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        //avoid the condition of high k
        if (k > prices.length / 2) {
            int tmp = 0;
            for (int i = 1; i < prices.length; ++i) {
                tmp += Math.max(0, prices[i] - prices[i - 1]);
            }
            return tmp;
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k];
        for (int n = 0; n < k; n += 1) {
            sell[n] = -prices[0];
        }
        for (int i = 1; i < prices.length; i+= 1) {
            int[] lastBuy = buy.clone();
            int[] lastSell = sell.clone();
            for (int j = 0; j < k; j += 1) {
                sell[j] = Math.max(lastBuy[j] - prices[i], lastSell[j]);
                buy[j + 1] = Math.max(lastSell[j] + prices[i], lastBuy[j + 1]);
            }
        }
        Arrays.sort(buy);
        return buy[k];
    }
}
