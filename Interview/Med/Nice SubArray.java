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




















class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int l = 0, r = 0;

        int cntOdd = 0;      // window ke andar odd count
        int ans = 0;
        int firstEvenCount = 0;   // left side pe kitne even hain (before first odd)

        while (r < n) {

            // Right pointer se odd count
            if ((nums[r] & 1) == 1) {
                cntOdd++;
                firstEvenCount = 0;   // new odd mila → even streak reset
            }

            // Jab window me exactly k odd ho jaye
            if (cntOdd == k) {

                // Count how many leading evens on left
                while ((nums[l] & 1) == 0) {
                    firstEvenCount++;
                    l++;
                }

                // Ab l ek odd pr hai → ye subarray k-th odd se start hota hai
                ans += firstEvenCount + 1;
            }

            // Jab cntOdd > k — window shrink karo
            while (cntOdd > k) {

                if ((nums[l] & 1) == 1) cntOdd--;
                l++;

                // New window me exactly k odds hone par leading evens count karo
                if (cntOdd == k) {
                    firstEvenCount = 0;
                    while ((nums[l] & 1) == 0) {
                        firstEvenCount++;
                        l++;
                    }
                    ans += firstEvenCount + 1;
                }
            }

            r++;
        }

        return ans;
    }
}


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int prefix = 0; 
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); 

        for (int num : nums) {

            // convert to 0/1 (odd → 1)
            prefix += (num % 2);

            ans += map.getOrDefault(prefix - k, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return ans;
    }
}
