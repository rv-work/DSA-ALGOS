
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








class Solution {

    Integer[][] dp;

    int rec(int[] prices, int idx, int canBuy) {
        if (idx >= prices.length) return 0;

        if (dp[idx][canBuy] != null) return dp[idx][canBuy];

        int ans;
        if (canBuy == 1) {
            int buy = -prices[idx] + rec(prices, idx + 1, 0);
            int skip = rec(prices, idx + 1, 1);
            ans = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + rec(prices, idx + 2, 1); // cooldown
            int hold = rec(prices, idx + 1, 0);
            ans = Math.max(sell, hold);
        }

        return dp[idx][canBuy] = ans;
    }

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return rec(prices, 0, 1);
    }
}









class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {

            // canBuy = 1
            dp[i][1] = Math.max(
                    -prices[i] + dp[i + 1][0],
                    dp[i + 1][1]
            );

            // canBuy = 0
            dp[i][0] = Math.max(
                    prices[i] + dp[i + 2][1], // cooldown
                    dp[i + 1][0]
            );
        }

        return dp[0][1];
    }
}

