// class Solution {

// int ans(int [] nums , int idx , int si, int preC){
// if(idx == nums.length - 1) return 1;

// int oldChainTake = Integer.MIN_VALUE;
// int oldChainNotTake = Integer.MIN_VALUE;
// int newChain = Integer.MIN_VALUE;

// if(preC == -1 ) newChain = 1 + ans(nums , idx+1 , si, nums[idx] - nums[si]);
// if(nums[idx+1] - nums[idx] == preC) oldChainTake = 1 + ans(nums , idx+1 , si,
// preC);
// else oldChainNotTake = ans(nums , idx+1 , si, preC);

// int skip = ans(nums , idx+1 , si , preC);

// return Math.max(skip , Math.max(newChain ,Math.max(oldChainTake ,
// oldChainNotTake) ));

// }

// public int longestArithSeqLength(int[] nums) {
// int n = nums.length;
// int len = Integer.MIN_VALUE;

// for(int i = 0; i< n-1; i++){
// len = Math.max(len , ans(nums , i , i, -1));
// }

// return len;
// }
// }

// upar vala wrong kyunki
// 9 4 7 2 10
// 4 7 ka chekc kiya
// 7 2 ka same nhi to skip kiya but
// skip ke baad 2 10 ka check kr rhe galat hai na //

// 7 ka 10 se check krna hai//
// matlab i need two index fixed then ..... unke aage kitne hain jo same diff me
// hain vo dekhna hai

// niche shi hai








class Solution {

    int solve(int[] nums, int idx, Integer diff){

        int n = nums.length;
        int max = 0;

        for(int next = idx + 1; next < n; next++){

            if(diff == nums[next] - nums[idx]){
                max = Math.max(max,  1 + solve(nums, next, diff));
            }
        }

        return max;
    }

    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                ans = Math.max(ans,
                        2 + solve(nums, j, nums[j] - nums[i])); 
            }
        }

        return ans;
    }
}






class Solution {

    int solve(int[] nums, int idx, int diff, int[][] dp){

        int n = nums.length;
        int max = 0;
        int d = diff + 500; // shift to positive index

        if(dp[idx][d] != -1) 
            return dp[idx][d];

        for(int next = idx + 1; next < n; next++){
            if(nums[next] - nums[idx] == diff){
                max = Math.max(max, 1 + solve(nums, next, diff, dp));
            }
        }

        return dp[idx][d] = max;
    }

    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        int[][] dp = new int[n][1001]; // +500 to manage -ve diffrence

        for(int[] row : dp)
            Arrays.fill(row, -1);

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                ans = Math.max(ans,
                        2 + solve(nums, j, nums[j] - nums[i], dp));
            }
        }

        return ans;
    }
}





class Solution {

    int solve(int[] nums, int idx, int diff,  Map<Integer , Integer> [] dp){

        int n = nums.length;
        int max = 0;
      

        if(dp[idx].containsKey(diff)) 
            return dp[idx].get(diff);

        for(int next = idx + 1; next < n; next++){
            if(nums[next] - nums[idx] == diff){
                max = Math.max(max, 1 + solve(nums, next, diff, dp));
            }
        }

        dp[idx].put(diff , max);
        return max;
    }

    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        int ans = 0;

        Map<Integer , Integer> [] dp = new HashMap[n]; 

        for(int i = 0; i< n; i++){
            dp[i] = new HashMap<>();
        } 

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                ans = Math.max(ans,
                        2 + solve(nums, j, nums[j] - nums[i], dp));
            }
        }

        return ans;
    }
}






class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        int[][] dp = new int[n][1001];

        for(int i=n-1; i>=0; i--){
            for(int next=i+1; next<n; next++){
                int diff = nums[next] - nums[i] + 500;
                dp[i][diff] = Math.max(dp[i][diff], 1 + dp[next][diff]);
                ans = Math.max(ans, dp[i][diff] + 1);
            }
        }

        return ans;
    }
}
