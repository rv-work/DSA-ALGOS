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

    boolean check(int num1, int num2) {
        return num1 != num2 - 2 && num1 != num2 - 1 && num1 != num2 + 2 && num1 != num2 + 1;
    }

    long ans(int[] power, int idx, int last) {
        if (idx < 0) {
            return 0;
        }

        long cast = Integer.MIN_VALUE;
        if (check(power[idx], last))
            cast = power[idx] + ans(power, idx - 1, power[idx]);
        long notCast = ans(power, idx - 1, last);

        return Math.max(cast, notCast);
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        return ans(power, power.length - 1, -2);
    }
}

class Solution {

    private long solve(int i, List<Integer> keys, Map<Integer, Long> freq, long[] dp) {
        if (i >= keys.size())
            return 0;
        if (dp[i] != -1)
            return dp[i];

        long skip = solve(i + 1, keys, freq, dp);

        long take = freq.get(keys.get(i)) * keys.get(i);

        int next = lowerBound(keys, i + 1, keys.get(i) + 3);

        take += solve(next, keys, freq, dp);

        return dp[i] = Math.max(skip, take);
    }

    // first index >= target, search range [start .. end]
    private int lowerBound(List<Integer> keys, int start, int target) {
        int l = start, r = keys.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (keys.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public long maximumTotalDamage(int[] power) {

        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }

        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        Arrays.fill(dp, -1);

        return solve(0, keys, freq, dp);
    }

}

class Solution {

    public long maximumTotalDamage(int[] power) {

        Map<Integer, Long> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }

        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            long skip = dp[i + 1];

            long take = freq.get(keys.get(i)) * keys.get(i);
            int next = lowerBound(keys, i + 1, keys.get(i) + 3);
            take += dp[next];

            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }

    // first index >= target, search range [start .. n)
    private int lowerBound(List<Integer> keys, int start, int target) {
        int l = start, r = keys.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (keys.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
