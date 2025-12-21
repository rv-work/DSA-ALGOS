class Solution {
    public long maximumScore(int[] nums, String s) {
        long sum = 0;
        int n = nums.length;
        int last = n-1;
        while(last >= 0){
            if(s.charAt(last) == '1') break; 
            last--;
        }

        if(last < 0) return 0;

        int cnt = 0;
        for(int i = 0; i<n; i++){
          if(s.charAt(i) == '1') cnt++;
        }



        Arrays.sort(nums ,0 , last+1);


        while(cnt != 0){
            sum += nums[last--];
            cnt--;
        }


        return sum ;
    }
}

// wrong because we can not go backward so ........

// Input
// nums =
// [1,8,8,4,6,2]
// s =
// "110100"
// Output
// 20
// Expected
// 17








class Solution {
    public long maximumScore(int[] nums, String s) {

        int n = nums.length;
        long sum = 0;

        // store pair (value, index)
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // sort decreasing by value
        Arrays.sort(arr, (a,b) -> b[0] - a[0]);

        // mark used indexes
        boolean[] used = new boolean[n];

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){

                // find best available value in prefix [0...i]
                for(int j = 0; j < n; j++){

                    int val = arr[j][0];
                    int idx = arr[j][1];

                    // value usable only if:
                    // 1) index <= i
                    // 2) not used
                    if(idx <= i && !used[idx]){
                        used[idx] = true;
                        sum += val;
                        break;
                    }
                }
            }
        }

        return sum;
    }
}













class Solution {
    public long maximumScore(int[] nums, String s) {

        int n = nums.length;
        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {

            // unlock nums[i]
            pq.add(nums[i]);

            if (s.charAt(i) == '1') {

                // pick highest available unused <= i
                while (!pq.isEmpty()) {
                    int top = pq.poll();

                    // ensure value from 0..i unused
                    int idx = findIndex(nums, top, used, i);

                    if (idx != -1) {
                        used[idx] = true;
                        sum += top;
                        break;
                    }
                }
            }
        }

        return sum;
    }

    private int findIndex(int[] nums, int val, boolean[] used, int limit) {

        for (int i = limit; i >= 0; i--) {
            if (!used[i] && nums[i] == val) return i;
        }
        return -1;
    }
}
