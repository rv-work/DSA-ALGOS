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
