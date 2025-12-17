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









class Solution {

    Map<String, Integer> dp = new HashMap<>();

    int sol(int[] nums, int x, int i, int j) {

        if (x == 0) return 0;
        if (x < 0) return Integer.MAX_VALUE;
        if (i > j) return Integer.MAX_VALUE;

        String key = i + "|" + j + "|" + x;
        if (dp.containsKey(key)) return dp.get(key);

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

        int ans = Math.min(takeI, takeJ);
        dp.put(key, ans);
        return ans;
    }

    public int minOperations(int[] nums, int x) {
        int ans = sol(nums, x, 0, nums.length - 1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}








class Solution {

    int ans = Integer.MAX_VALUE;

    void backtrack(int[] nums, int i, int j, int x, int ops) {

        // success case
        if (x == 0) {
            ans = Math.min(ans, ops);
            return;
        }

        // invalid cases
        if (i > j || x < 0) return;

        // pruning (optional but logical)
        if (ops >= ans) return;

        // take from left
        backtrack(nums, i + 1, j, x - nums[i], ops + 1);

        // take from right
        backtrack(nums, i, j - 1, x - nums[j], ops + 1);
    }

    public int minOperations(int[] nums, int x) {
        backtrack(nums, 0, nums.length - 1, x, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
