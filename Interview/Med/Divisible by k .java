class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;

        int ps = 0;
        mp.put(ps, 1);  

        for (int i = 0; i < n; i++) {
            ps += nums[i];

            int need = ((ps % k) + k) % k;

            ans += mp.getOrDefault(need, 0);

            mp.put(need, mp.getOrDefault(need, 0) + 1);
        }

        return ans;
    }
}