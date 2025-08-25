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


// mine


class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(ans , -1);

        for (int i = 2*n - 1; i >= 0; i--) {
            int index = i % n;

            while (!st.isEmpty() && nums[st.peek()] <= nums[index]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[index] = nums[st.peek()];
            }

            st.push(index);
        }

        return ans;
    }
}
