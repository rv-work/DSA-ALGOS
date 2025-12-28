class Solution {
    public long maximumScore(int[] nums) {
        long ans = nums[0] - nums[1], prefix_sum = 0;
        int n = nums.length, min = nums[n - 1];
        for(int i = 0; i < n - 1; i++) prefix_sum += nums[i];
        for(int i = n - 2; i >= 0; i--) {
            ans = Math.max(ans, prefix_sum - min);
            min = Math.min(min, nums[i]);
            prefix_sum -= nums[i];
        }
        return ans;
    }
}









class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];
        for(int i = n - 2; i > 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }
        long ans = nums[0] - min[1], prefix_sum = nums[0];
        for(int i = 1; i < n - 1; i++) {
            prefix_sum += nums[i];
            ans = Math.max(ans, prefix_sum - min[i + 1]);
        }
        return ans;
    }
}