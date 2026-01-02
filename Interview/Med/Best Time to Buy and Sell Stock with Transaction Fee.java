class Solution {

  int rec(int[] prices, int idx, boolean canBuy, int fee) {
    if (idx >= prices.length)
      return 0;

    if (canBuy) {
      int buy = -prices[idx] - fee + rec(prices, idx + 1, false, fee);
      int notBuy = rec(prices, idx + 1, true, fee);
      return Math.max(buy, notBuy);
    } else {
      int sell = prices[idx] + rec(prices, idx + 1, true, fee);
      int notSell = rec(prices, idx + 1, false, fee);
      return Math.max(sell, notSell);
    }
  }

  public int maxProfit(int[] prices, int fee) {
    return rec(prices, 0, true, fee);
  }
}

class Solution {

  int rec(int[] prices, int idx, int canBuy, int fee, int[][] dp) {
    if (idx >= prices.length)
      return 0;

    if (dp[idx][canBuy] != -1)
      return dp[idx][canBuy];

    if (canBuy == 1) {
      int buy = -prices[idx] + rec(prices, idx + 1, 0, fee, dp);
      int notBuy = rec(prices, idx + 1, 1, fee, dp);
      dp[idx][canBuy] = Math.max(buy, notBuy);
    } else {
      int sell = prices[idx] - fee + rec(prices, idx + 1, 1, fee, dp);
      int notSell = rec(prices, idx + 1, 0, fee, dp);
      dp[idx][canBuy] = Math.max(sell, notSell);
    }

    return dp[idx][canBuy];
  }

  public int maxProfit(int[] prices, int fee) {
    int[][] dp = new int[prices.length][2];
    for (int[] num : dp)
      Arrays.fill(num, -1);
    return rec(prices, 0, 1, fee, dp);
  }
}