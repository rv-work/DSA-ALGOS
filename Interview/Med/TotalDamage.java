class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);

        List<Integer> uniquePowers = new ArrayList<>();
        List<Long> totalDamages = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currentPower = power[i];
            long sum = currentPower;
    
            while (i + 1 < n && power[i + 1] == currentPower) {
                i++;
                sum += currentPower;
            }
    
            uniquePowers.add(currentPower);
            totalDamages.add(sum);
        }

        long[] dp = new long[uniquePowers.size() + 1];

        for (int j = uniquePowers.size() - 1; j >= 0; j--) {
            long skip = dp[j + 1];
            long take = totalDamages.get(j);
    
            int nextIndex = j + 1;
            while (nextIndex < uniquePowers.size() && 
                uniquePowers.get(nextIndex) - uniquePowers.get(j) <= 2) {
                nextIndex++;
            }
            take += dp[nextIndex];
    
            dp[j] = Math.max(skip, take);
        }

        return dp[0];
    }
}     








class Solution {

    boolean check(int num1 , int num2){
      return num1 != num2-2 && num1 != num2-1 && num1 != num2+2 && num1 != num2+1;
    }

    long ans(int [] power , int idx , int last){
        if(idx < 0){
            return 0;
        }

        long cast = Integer.MIN_VALUE;
        if(check(power[idx] , last)) cast = power[idx] + ans(power , idx-1 , power[idx]);
        long notCast = ans(power , idx-1 ,last);

        return Math.max(cast , notCast);
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        return ans(power , power.length - 1 , -2);
    }
}