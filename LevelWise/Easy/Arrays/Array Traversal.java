// [Find Numbers with Even Number of Digits](https://leetcode.com/problems/find-numbers-with-even-number-of-digits/)


class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int num : nums){
            String s = ""+num;
            if (( s.length() & 1)  == 0) ans++;
        }

        return ans;
    }
}

