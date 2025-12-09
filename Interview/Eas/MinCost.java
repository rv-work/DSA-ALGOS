class Solution {
    
    int mini(int [] cost , int st , int dp[]){
     if(st >= cost.length) return 0;

     if(dp[st] != -1) return dp[st];
    
    return dp[st] =  cost[st] +  Math.min(mini(cost , st+1 , dp) , mini(cost , st+2 , dp));

    }

    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp , -1);
        return Math.min(mini(cost , 0 , dp) , mini(cost , 1  ,dp));
    }
}