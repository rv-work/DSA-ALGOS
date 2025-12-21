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