class Solution {

  int MODULO = 1000000007;

  int getAll(int[][] dp, int row, int[] colors) {
    if (row < 0)
      return 1;

    int ans = 0;

    for (int a : colors) {

      if (a == dp[row + 1][0])
        continue;

      for (int b : colors) {
        if (a == b || b == dp[row + 1][1])
          continue;

        for (int c : colors) {
          if (b == c || c == dp[row + 1][2])
            continue;

          dp[row][0] = a;
          dp[row][1] = b;
          dp[row][2] = c;

          ans += (getAll(dp, row - 1, colors) % MODULO);
        }
      }
    }

    return ans;

  }

  public int numOfWays(int n) {

    int[] colors = { 1, 2, 3 };
    int dp[][] = new int[n][3];
    int ans = 0;

    for (int a : colors) {
      for (int b : colors) {
        if (a == b)
          continue;
        for (int c : colors) {
          if (b == c)
            continue;
          dp[n - 1][0] = a;
          dp[n - 1][1] = b;
          dp[n - 1][2] = c;

          ans += (getAll(dp, n - 2, colors) % MODULO);
        }
      }
    }
    return ans;
  }
}