// [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)


class Solution {
    public int maxSubArray(int[] nums) {
        int cs = 0;
        int ms = Integer.MIN_VALUE; 

        for (int num : nums) {
            cs += num; 
            ms = Math.max(ms, cs); 
            if (cs < 0) cs = 0; 
        }

        return ms;
    }
}
