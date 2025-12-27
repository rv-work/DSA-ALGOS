class Solution {

    int solve(int[] prices , int k , int idx , boolean canBuy){
        if(k == 0 || idx >= prices.length) return 0;
        
        int buy = 0;
        int notBuy = 0;
        int sell = 0;
        int notSell = 0;
        if(canBuy){
           buy = -prices[idx] + solve(prices , k , idx+1 , false);
           notBuy =  solve(prices , k , idx+1 , canBuy);
        } else {
           sell = prices[idx] + solve(prices , k - 1, idx+1 , true);
           notSell =  solve(prices , k , idx+1 , canBuy);
        }
       
       return Math.max( Math.max(buy , notBuy) , Math.max(sell , notSell) );

    }

    public int maxProfit(int k, int[] prices) {
        return solve(prices , k , 0 , true);
    }
}













class Solution {

    int solve(int[] prices, int k, int idx, int canBuy, int[][][] dp) {
        if (k == 0 || idx == prices.length) return 0;

        if (dp[k][idx][canBuy] != -1) 
            return dp[k][idx][canBuy];

        int ans;
        if (canBuy == 1) {
            int buy = -prices[idx] + solve(prices, k, idx + 1, 0, dp);
            int skip = solve(prices, k, idx + 1, 1, dp);
            ans = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + solve(prices, k - 1, idx + 1, 1, dp);
            int skip = solve(prices, k, idx + 1, 0, dp);
            ans = Math.max(sell, skip);
        }

        return dp[k][idx][canBuy] = ans;
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[k + 1][n][2];
        for (int i = 0; i <= k; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);

        return solve(prices, k, 0, 1, dp);
    }
}
