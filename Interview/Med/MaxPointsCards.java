class Solution { // space...

    int getAns(int[] p, int k , int i , int j , int [][] dp){
        if (i + (p.length - j - 1) == k) return 0;

        if(dp[i][j] != -1) return dp[i][j];

       int last = p[j] + getAns(p , k, i , j-1 , dp);
       int start = p[i] + getAns(p , k, i+1 , j , dp);

       return dp[i][j] =  Math.max(last , start);
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int [][] dp = new int [n][n];

        for(int [] arr : dp) Arrays.fill(arr , -1);

        return getAns(cardPoints , k , 0 ,  cardPoints.length - 1 , dp);
    }
}







class Solution {

    public int maxScore(int[] p, int k) {
        int n = p.length;

        int[][] dp = new int[k + 1][k + 1];

        // build bottom-up
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {

                if (i + j > k) continue;

                if (i > 0) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        dp[i - 1][j] + p[i - 1]
                    );
                }

                if (j > 0) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        dp[i][j - 1] + p[n - j]
                    );
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, dp[i][k - i]);
        }

        return ans;
    }
}






