// [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;        
    }
}



// mine


class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int index = n - 1; index >= 0; index--) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[index]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[index] = st.peek() - index;
            }

            st.push(index);
        }

        return ans;
    }
}
