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