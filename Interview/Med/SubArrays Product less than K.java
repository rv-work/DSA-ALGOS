class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int l = 0, r = 0;
        int n = nums.length;
        int mul = 1;


        while(r < n){
          mul *= nums[r];

          while( l <=r && mul >=k) mul /= nums[l++];

          ans += r - l + 1;
          r++;
        }

        return ans;
    }
}