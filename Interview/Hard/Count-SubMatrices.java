class Solution {
    public int numSubmatrixSumTarget(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // Row-wise prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }

        int ans = 0;

        for (int sc = 0; sc < m; sc++) {
            for (int col = sc; col < m; col++) {

                Map<Integer, Integer> mp = new HashMap<>();
                mp.put(0, 1);
                int ps = 0;wor

                for (int row = 0; row < n; row++) {
                    ps += mat[row][col] - (sc > 0 ? mat[row][sc - 1] : 0);
                    ans += mp.getOrDefault(ps - k, 0);
                    mp.put(ps, mp.getOrDefault(ps, 0) + 1);
                }
            }
        }

        return ans;
    }
}

















