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







/*
Idea of my memoization:

1) Har row ke liye sirf 12 valid states hote hain (a,b,c),
   kyunki a!=b aur b!=c hona hi chahiye.

2) Main recursion me state ko aise define kar raha hoon:
   (row, a, b, c)
   -> row: upar kitni rows abhi fill karni hain
   -> (a,b,c): neeche wali row ke colors

3) preComputes[row][a][b][c] ka matlab:
   agar current row ke neeche (a,b,c) already painted hai,
   to upar ki 'row' rows ko paint karne ke total ways.

4) Jab kisi state (row,a,b,c) pehli baar aati hai,
   to recursion poori tarah neeche tak jaata hai
   (row = 0 tak) aur uska answer calculate karta hai.

5) Is first deep calculation ke dauran,
   almost saari (row,a,b,c) states memo table me fill ho jaati hain.

6) Jab baad me kisi aur starting state se recursion aati hai,
   to wo check karti hai:
   "kya ye (row,a,b,c) pehle calculate ho chuka hai?"

7) Agar haan, to direct memo table se value pick kar li jaati hai,
   aur dobara calculation nahi hoti.

8) Is tarah har (row,a,b,c) state sirf ek hi baar calculate hoti hai,
   baaki times sirf reuse hoti hai.
*/














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


















class Solution {

    static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {

        // base case: n = 1
        long aba = 6;  // patterns like 121
        long abc = 6;  // patterns like 123

        for (int i = 2; i <= n; i++) {

            long newAba = (aba * 3 + abc * 2) % MOD;
            long newAbc = (aba * 2 + abc * 2) % MOD;

            aba = newAba;
            abc = newAbc;
        }

        return (int) ((aba + abc) % MOD);
    }
}


