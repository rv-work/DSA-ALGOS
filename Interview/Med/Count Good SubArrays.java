class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int l = 0;
        long cnt = 0;  
        long ans = 0;

        for (int r = 0; r < n; r++) {

            int f = mp.getOrDefault(nums[r], 0);
            cnt += f;                 
            mp.put(nums[r], f + 1);

            while (cnt >= k) {
                ans += (n - r);       
                int freq = mp.get(nums[l]);
                cnt -= (freq - 1);  
                mp.put(nums[l], freq - 1);
                l++;
            }
        }

        return ans;
    }
}























class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;
        int l = 0, r = 0;
        long cnt = 0;
        long ans = 0;

        while (r < n) {

            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            if (mp.get(nums[r]) >= 2)
                cnt += mp.get(nums[r]) - 1;

            while (cnt >= k) {
                if (mp.get(nums[l]) >= 2)
                    cnt -= mp.get(nums[l]) - 1;
                mp.put(nums[l], mp.get(nums[l]) - 1);
                l++;
            }

            ans += l;

            r++;

        }

        return ans;

    }
}