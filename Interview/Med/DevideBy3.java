// without dp 


class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min11 = Integer.MAX_VALUE;
        int min22 = Integer.MAX_VALUE;

        for (int x : nums) {
            sum += x;
            int r = x % 3;

            if (r == 1) {
                if (x < min1) { min11 = min1; min1 = x; }
                else if (x < min11) min11 = x;
            } 
            else if (r == 2) {
                if (x < min2) { min22 = min2; min2 = x; }
                else if (x < min22) min22 = x;
            }
        }

        int rem = sum % 3;

        if (rem == 0) return sum;

        if (rem == 1) {
            int remove1 = min1;
            int remove2 = (min2 == Integer.MAX_VALUE || min22 == Integer.MAX_VALUE)
                            ? Integer.MAX_VALUE : min2 + min22;
            int remove = Math.min(remove1, remove2);
            return (remove == Integer.MAX_VALUE) ? 0 : sum - remove;
        } 
        else {
            int remove1 = min2;
            int remove2 = (min1 == Integer.MAX_VALUE || min11 == Integer.MAX_VALUE)
                            ? Integer.MAX_VALUE : min1 + min11;
            int remove = Math.min(remove1, remove2);
            return (remove == Integer.MAX_VALUE) ? 0 : sum - remove;
        }
    }
}



/// 2




class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        
        for (int x : nums) {
            sum += x;
            if (x % 3 == 1) r1.add(x);
            else if (x % 3 == 2) r2.add(x);
        }
        
        if (sum % 3 == 0) return sum;
        
        Collections.sort(r1);
        Collections.sort(r2);
        
        int rem = sum % 3;
        int ans = 0;
        
        if (rem == 1) {
            int op1 = (r1.size() >= 1) ? sum - r1.get(0) : 0;
            int op2 = (r2.size() >= 2) ? sum - r2.get(0) - r2.get(1) : 0;
            ans = Math.max(op1, op2);
        } else { // rem == 2
            int op1 = (r2.size() >= 1) ? sum - r2.get(0) : 0;
            int op2 = (r1.size() >= 2) ? sum - r1.get(0) - r1.get(1) : 0;
            ans = Math.max(op1, op2);
        }
        
        return ans;
    }
}


//3 DP



class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, 0, 0};....

        for (int num : nums) {
            int[] prev = dp.clone();
            for (int cur : prev) {
                int s = cur + num;
                dp[s % 3] = Math.max(dp[s % 3], s);
            }
        }
        return dp[0];
    }
}