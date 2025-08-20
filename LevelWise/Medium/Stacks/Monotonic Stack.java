// [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/)



class Solution {
    public int[] nextGreaterElements(int[] nums) {
     
       int stack[] = new int[nums.length*2];
        int top = 0;

        for(int i = nums.length-1; i >= 0; i--){
            stack[top++] = nums[i];
        }
        int ans[] = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            while(top != 0 && stack[top-1] <= nums[i]){
                top--;
            }
            if(top != 0){
                ans[i] = stack[top-1];
            }else{
                ans[i] = -1;
            }
            stack[top++] = nums[i];
        }

        return ans;
    }
}