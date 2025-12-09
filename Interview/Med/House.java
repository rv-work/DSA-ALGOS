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








class Solution {
    


    public int rob(int[] nums) {
        int n = nums.length;
        int dp [] = new int [n];
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        for(int i = 2; i< n; i++){
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }


        return dp[n-1];
    }
}