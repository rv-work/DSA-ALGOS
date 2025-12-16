class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;

        int l = 0, r = 0, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        while (r < n) {

            pq.offer(nums[r]);

            // window shrink if max > right
            while (!pq.isEmpty() && pq.peek() > right) {
                pq.remove(nums[l++]);
            }

            // 🔥 COUNT LOOP: window ke andar subarrays check karo
            if (!pq.isEmpty() && pq.peek() <= right) {

                int max = Integer.MIN_VALUE;

                // r se peeche jaate hue subarrays check
                for (int i = r; i >= l; i--) {
                    max = Math.max(max, nums[i]);

                    if (max >= left && max <= right) {
                        ans++;
                    }
                }
            }

            r++;
        }

        return ans;
    }
}
