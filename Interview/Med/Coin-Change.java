class Solution {

    int solve(int[] coins, int amt, int ind) {

        if (amt == 0) return 0;
        if (ind == coins.length) return -1;

        int take = -1;
        if (coins[ind] <= amt) {
            int res = solve(coins, amt - coins[ind], ind);
            if (res != -1) take = 1 + res;
        }

        int notTake = solve(coins, amt, ind + 1);

        if (take == -1) return notTake;
        if (notTake == -1) return take;

        return Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        return solve(coins, amount, 0);
    }
}








class Solution {
    int solve(int[] coins, int amt, int ind ,  int[][] dp) {

        if (amt == 0) return 0;
        if (ind == coins.length) return -1;

        if (dp[ind][amt] != -1) return dp[ind][amt];

        int take = -1;
        if (coins[ind] <= amt) {
            int res = solve(coins, amt - coins[ind], ind , dp);
            if (res != -1) take = 1 + res;
        }

        int notTake = solve(coins, amt, ind + 1 , dp);

        if (take == -1) return dp[ind][amt] = notTake;
        if (notTake == -1) return dp[ind][amt] = take;

        return dp[ind][amt] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(coins, amount, 0 , dp);
    }
}
