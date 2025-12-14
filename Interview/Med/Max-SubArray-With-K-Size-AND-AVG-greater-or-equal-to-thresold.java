class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int target = k * threshold;

        int sum = 0;
        int ans = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum >= target) ans++;

        for (int i = k; i < n; i++) {
            sum += arr[i];       
            sum -= arr[i - k];  

            if (sum >= target) ans++;
        }


        return ans;
    }
}
