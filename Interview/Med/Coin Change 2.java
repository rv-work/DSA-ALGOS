class Solution {


    int ans(int [] coins , int amt , int idx){
       if(amt == 0) return 1;
       if(idx < 0) return 0;

       int take = 0;
       if(amt >= coins[idx]) take = ans(coins , amt - coins[idx] , idx);
       int notTake = ans(coins , amt  , idx-1);

       return take + notTake;
    }

    public int change(int amount, int[] coins) {
        return ans(coins , amount , coins.length - 1); 

    }
}






class Solution {


    int ans(int [] coins , int amt , int idx , int[][] dp){
       if(amt == 0) return 1;
       if(idx < 0) return 0;
       if(dp[idx][amt] != -1) return dp[idx][amt];
       int take = 0;
       if(amt >= coins[idx]) take = ans(coins , amt - coins[idx] , idx , dp);
       int notTake = ans(coins , amt  , idx-1  , dp);

       return dp[idx][amt] =  take + notTake;
    }

    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount+1];
        for(int nums []: dp ) Arrays.fill(nums , -1);
        return ans(coins , amount , coins.length - 1 , dp);
    }
}












class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = (j % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int take = 0;
                if (j >= coins[i])
                    take = dp[i][j - coins[i]];
                int notTake = dp[i - 1][j];

                dp[i][j] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }
}













class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int [amount + 1];
        int[] curr = new int [amount + 1];

        prev[0] = 1;
        curr[0] = 1;

        for (int j = 1; j <= amount; j++) {
            prev[j] = (j % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                int take = 0;
                if (j >= coins[i])
                    take = curr[j - coins[i]];
                int notTake = prev[j];

                curr[j] = take + notTake;
            }
            prev = curr;
        }

        return prev[amount];
    }
}







class Solution {

    public int change(int amount, int[] coins) {

    int[] dp = new int[amount + 1];

    dp[0] = 1;

    for (int coin : coins) {
        for (int j = coin; j <= amount; j++) {
            dp[j] += dp[j - coin];
        }
    }

    return dp[amount];
}



}