class Solution {

    

    int solve(int[] coins, int amt , int[] dp) {

        if (amt == 0) return 0;
        if (amt < 0) return -1;

        if (dp[amt] != -1) return dp[amt];

        int best = Integer.MAX_VALUE;

        for (int c : coins) {
            if (c <= amt) {
                int res = solve(coins, amt - c, dp);
                if (res != -1) best = Math.min(best, 1 + res );
            }
        }

        dp[amt] = (best == Integer.MAX_VALUE) ? -1 : best;
        return dp[amt];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        return solve(coins, amount  ,dp);
    }
}








class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int c : coins) {
            for (int amt = c; amt <= amount; amt++) {
                dp[amt] = Math.min(dp[amt], 1 + dp[amt - c]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}







class Solution {

    int getMin(int[] coins, int[][] dp, int amount, int ind) {

        if (ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return Integer.MAX_VALUE;
        }

        if (dp[ind][amount] != -1) return dp[ind][amount];

        int take = Integer.MAX_VALUE;

        if (coins[ind] <= amount) {
            int res = getMin(coins, dp, amount - coins[ind], ind);
            if (res != Integer.MAX_VALUE) take = 1 + res;
        }

        int notTake = getMin(coins, dp, amount, ind - 1);

        return dp[ind][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        int ans = getMin(coins, dp, amount, n - 1);
        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
