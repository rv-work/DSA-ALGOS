class Solution {

    int rec(int[] prices, int idx, boolean canBuy, int fee) {
        if (idx >= prices.length) return 0;

        if (canBuy) {
            int buy = -prices[idx] - fee + rec(prices, idx + 1, false, fee);
            int notBuy = rec(prices, idx + 1, true, fee);
            return Math.max(buy, notBuy);
        } else {
            int sell = prices[idx]  + rec(prices, idx + 1, true, fee);
            int notSell = rec(prices, idx + 1, false, fee);
            return Math.max(sell, notSell);
        }
    }

    public int maxProfit(int[] prices, int fee) {
        return rec(prices, 0, true, fee);
    }
}