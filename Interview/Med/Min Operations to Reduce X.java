class Solution {
    int sol(int nums[], int x, int i, int j) {
        if (x == 0) return 0;
        if (i > j) return Integer.MAX_VALUE;

        int takeI = Integer.MAX_VALUE;
        int takeJ = Integer.MAX_VALUE;

        if (nums[i] <= x) {
            int res = sol(nums, x - nums[i], i + 1, j);
            if (res != Integer.MAX_VALUE)
                takeI = 1 + res;
        }

        if (nums[j] <= x) {
            int res = sol(nums, x - nums[j], i, j - 1);
            if (res != Integer.MAX_VALUE)
                takeJ = 1 + res;
        }

        return Math.min(takeI, takeJ);
    }

    public int minOperations(int[] nums, int x) {
        int ans = sol(nums, x, 0, nums.length - 1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
