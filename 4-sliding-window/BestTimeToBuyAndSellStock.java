
/**
 * 
 * https://neetcode.io/problems/buy-and-sell-crypto/question?list=neetcode150 
 * 
 * You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
 * You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
 * Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
 *
 * Constraints:
 * 1 <= prices.length <= 100
 *  <= prices[i] <= 100
 * 
 */ 
public class BestTimeToBuyAndSellStock() {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int t = 0;

        while(r < prices.length) {
            if (prices[l] < prices[r]) t = Math.max(t, prices[r] - prices[l]);
            else l = r;
            r++;
        }

        return t;
    }
}
