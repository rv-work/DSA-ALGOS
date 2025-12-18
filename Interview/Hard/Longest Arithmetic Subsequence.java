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