class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int l = 0, r = 0;
        int cnt = 0, ans = 0;

        while (r < nums.length) {

            if ((nums[r] & 1) == 1) k--;

            while (k < 0) {
                if ((nums[l] & 1) == 1) k++;
                l++;
            }

            ans += r - l + 1;
            r++;
        }

        return ans;
    }
}
