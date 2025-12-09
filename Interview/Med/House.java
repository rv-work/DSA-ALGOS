class Solution {
    
    int ans(int[] nums , int n , int house , int[] dp){
        if(house >= n) return 0;
        if(dp[house] != -1) return dp[house];
        return dp[house] =  Math.max( nums[house] + ans(nums , n , house + 2 , dp) ,  ans(nums , n , house + 1 , dp)) ;
        
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int dp [] = new int [n];
        Arrays.fill(dp , -1);
        return ans(nums , n , 0  , dp);
    }
}