class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);  

        int l = 0;
        long totalDiff = 0;     
        int ans = 1;

        for (int r = 1; r < nums.length; r++) {

            totalDiff += (long)(nums[r] - nums[r - 1]) * (r - l);

            while (totalDiff > k) {
                totalDiff -= nums[r] - nums[l];
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}








class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);   

        long total = 0;     
        int l = 0;
        int ans = 1;

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];

            while ((long)nums[r] * (r - l + 1) - total > k) {
                total -= nums[l];
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
