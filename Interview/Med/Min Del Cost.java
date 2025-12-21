class Solution {
  public long minCost(String s, int[] cost) {
    long sum = 0;
    long freq[] = new long[26];

    int n = cost.length;

    for (int i = 0; i < n; i++) {
      int ascii = s.charAt(i) - 'a';
      freq[ascii] += cost[i];
      sum += cost[i];
    }

    long ans = Long.MAX_VALUE;

    for (int i = 0; i < 26; i++) {
      long rem = sum - freq[i];
      ans = Math.min(ans, rem);
    }

    if (ans == sum)
      return 0;
    return ans;
  }
}