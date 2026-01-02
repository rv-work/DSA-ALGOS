
class Solution {

    int rec(int[] prices, int idx, boolean canBuy) {
        if (idx >= prices.length) return 0;

        if (canBuy) {
            int buy = -prices[idx] + rec(prices, idx + 1, false);
            int skip = rec(prices, idx + 1, true);
            return Math.max(buy, skip);
        } else {
            int sell = prices[idx] + rec(prices, idx + 2, true); // cooldown
            int hold = rec(prices, idx + 1, false);
            return Math.max(sell, hold);
        }
    }

    public int maxProfit(int[] prices) {
        return rec(prices, 0, true);
    }
}
