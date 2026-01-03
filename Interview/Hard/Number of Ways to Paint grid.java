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






class Solution {

    int MODULO = 1000000007;

    int getAll(int[]prev, int row ,  int[] colors) {

        if (row < 0)return 1;

        int curr[] = new int[3];
        
        int ans = 0;

        for (int a : colors) {
            
            if(a == prev[0]) continue;

            for (int b : colors) {
                if (a == b || b == prev[1] )continue;
                
                for (int c : colors) {
                    if (b == c || c == prev[2] )continue;

                    curr[0] = a; 
                    curr[1] = b; 
                    curr[2] = c; 

                    ans +=  (getAll(curr, row-1, colors) % MODULO);
                }
            }
        }

      return ans;

    }

    public int numOfWays(int n) {

        int[] colors = { 1, 2, 3 };
        int prev[] = new int[3];
        int ans = 0;

        for (int a : colors) {
            for (int b : colors) {
                if (a == b)continue;
                for (int c : colors) {
                    if (b == c)continue;
                    prev[0] = a; 
                    prev[1] = b; 
                    prev[2] = c; 

                    ans += (getAll(prev, n - 2, colors ) % MODULO);
                }
            }
        }
        return ans;
    }
}




















class Solution {

    int MODULO = 1000000007;

    int getAll(
        int[] prev,
        int row,
        int[] colors,
        int[][][][] preComputes
    ) {

        if (row < 0) return 1;

       
        if (preComputes[row][prev[0]][prev[1]][prev[2]] != -1) {
            return preComputes[row][prev[0]][prev[1]][prev[2]];
        }

        int ans = 0;

        for (int a : colors) {
            if (a == prev[0]) continue;

            for (int b : colors) {
                if (a == b || b == prev[1]) continue;

                for (int c : colors) {
                    if (b == c || c == prev[2]) continue;

                    int[] curr = new int[3];
                    curr[0] = a;
                    curr[1] = b;
                    curr[2] = c;

                    ans = (ans + getAll(curr, row - 1, colors, preComputes)) % MODULO;
                }
            }
        }

        preComputes[row][prev[0]][prev[1]][prev[2]] = ans;
        return ans;
    }

    public int numOfWays(int n) {

        int[] colors = {1, 2, 3};
        int ans = 0;

        
        int[][][][] preComputes = new int[n][4][4][4];

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < 4; a++) {
                for (int b = 0; b < 4; b++) {
                    for (int c = 0; c < 4; c++) {
                        preComputes[i][a][b][c] = -1;
                    }
                }
            }
        }

        for (int a : colors) {
            for (int b : colors) {
                if (a == b) continue;

                for (int c : colors) {
                    if (b == c) continue;

                    int[] prev = new int[3];
                    prev[0] = a;
                    prev[1] = b;
                    prev[2] = c;

                    ans = (ans + getAll(prev, n - 2, colors, preComputes)) % MODULO;
                }
            }
        }

        return ans;
    }
}












class Solution {

    int MODULO = 1_000_000_007;

    public int numOfWays(int n) {

        int[] colors = {1, 2, 3};

        // dp[row][a][b][c]
        int[][][][] dp = new int[n][4][4][4];

        // -------- BASE CASE (row = 0) --------
        for (int a : colors) {
            for (int b : colors) {
                if (a == b) continue;
                for (int c : colors) {
                    if (b == c) continue;
                    dp[0][a][b][c] = 1;
                }
            }
        }

        // -------- FILL TABLE --------
        for (int row = 1; row < n; row++) {

            for (int a : colors) {
                for (int b : colors) {
                    if (a == b) continue;

                    for (int c : colors) {
                        if (b == c) continue;

                        long ways = 0;

                        for (int pa : colors) {
                            if (pa == a) continue;

                            for (int pb : colors) {
                                if (pb == b) continue;

                                for (int pc : colors) {
                                    if (pc == c) continue;

                                    ways += dp[row - 1][pa][pb][pc];
                                }
                            }
                        }

                        dp[row][a][b][c] = (int)(ways % MODULO);
                    }
                }
            }
        }

        // -------- ANSWER --------
        int ans = 0;
        for (int a : colors) {
            for (int b : colors) {
                if (a == b) continue;
                for (int c : colors) {
                    if (b == c) continue;
                    ans = (ans + dp[n - 1][a][b][c]) % MODULO;
                }
            }
        }

        return ans;
    }
}


