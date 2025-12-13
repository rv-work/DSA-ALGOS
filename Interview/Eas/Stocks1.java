class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}
class Solution {

    int[][] dp;

    int dfs(int[] prices, int i, int have) {

        if (i == prices.length) return 0;

        if (dp[i][have] != -1) return dp[i][have];

        int ans;

        if (have == 0) {
            int buy = -prices[i] + dfs(prices, i + 1, 1);
            int skip = dfs(prices, i + 1, 0);
            ans = Math.max(buy, skip);
        } else {
            int sell = prices[i];   
            int hold = dfs(prices, i + 1, 1);
            ans = Math.max(sell, hold);
        }

        return dp[i][have] = ans;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        dp = new int[n][2];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return dfs(prices, 0, 0);
    }
}
