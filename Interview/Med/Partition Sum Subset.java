class Solution {

  boolean ans(int[] nums, int target, int idx) {
    if (target == 0)
      return true;
    if (idx < 0)
      return false;

    boolean take = false;
    if (target >= nums[idx])
      take = ans(nums, target - nums[idx], idx - 1);
    boolean notTake = ans(nums, target, idx - 1);

    return take | notTake;
  }

  public boolean canPartition(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 != 0)
      return false;
    return ans(nums, sum / 2, n - 1);
  }
}











class Solution {

    boolean ans(int [] nums , int target , int idx ,  int [][] dp){
        if(target == 0) return true;
        if(idx < 0) return false;
        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean take = false;
        if(target >= nums[idx]) take = ans(nums , target - nums[idx] , idx-1 ,dp);
        boolean notTake = ans(nums , target  , idx-1 , dp);

        dp[idx][target] = ( take | notTake) ? 1 : 0;
        return take | notTake;
    }


    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int sum = 0;
       for(int num : nums) sum += num;
       int [][] dp = new int[n][sum/2 + 1];
       for(int arr[] : dp) Arrays.fill(arr , -1);
       if(sum % 2 != 0) return false;
       return ans(nums , sum/2 , n-1 , dp);
    }
}






class Solution {

    int ans(int [] nums , int target , int idx ,  int [][] dp){
        if(target == 0) return 1;
        if(idx < 0) return 0;
        if(dp[idx][target] != -1) return dp[idx][target] ;

        int take = 0;
        if(target >= nums[idx]) take = ans(nums , target - nums[idx] , idx-1 ,dp);
        int notTake = ans(nums , target  , idx-1 , dp);

        return dp[idx][target] = Math.max(take , notTake);
         
    }


    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int sum = 0;
       for(int num : nums) sum += num;
       int [][] dp = new int[n][sum/2 + 1];
       for(int arr[] : dp) Arrays.fill(arr , -1);
       if(sum % 2 != 0) return false;
       return ans(nums , sum/2 , n-1 , dp) == 1;
    }
}
























class Solution {

    int ans(int [] nums , int target , int idx ,  int [][] dp){
        if(target == 0) return 1;
        if(idx < 0) return 0;
        if(dp[idx][target] != -1) return dp[idx][target] ;

        int take = 0;
        if(target >= nums[idx]) take = ans(nums , target - nums[idx] , idx-1 ,dp);
        int notTake = ans(nums , target  , idx-1 , dp);

        return dp[idx][target] = Math.max(take , notTake);
         
    }


    public boolean canPartition(int[] nums) {
       int n = nums.length;
       int sum = 0;
       for(int num : nums) sum += num;
       if(sum % 2 != 0) return false;

       int target = sum /2;
       int [][] dp = new int[n][target + 1];
       
       for(int i = 0; i<n; i++){
         dp[i][0] = 1;
       }

       for(int i = 1; i<= target; i++){
        dp[0][i] = nums[0] == i ? 1 : 0;
       }

       for(int i = 1; i< n; i++){
        for(int j = 1; j<= target ; j++){
            int take = 0;
            if(j >= nums[i]) take = dp[i-1][j-nums[i]];
            int notTake = dp[i-1][j];

            dp[i][j] = Math.max(take , notTake);

        }
       }



       return dp[n-1][target] == 1;
       
    }
}