// public class Solution {
//     public int[] findDiagonalOrder(int[][] matrix) {
//         if (matrix == null || matrix.length == 0) return new int[0];

//         int m = matrix.length, n = matrix[0].length;
//         int[] result = new int[m * n];
//         int row = 0, col = 0;

//         for (int i = 0; i < m * n; i++) {
//             result[i] = matrix[row][col];

//             if ((row + col) % 2 == 0) {
//                 if (col == n - 1) row++;
//                 else if (row == 0) col++;
//                 else { row--; col++; }
//             } else {
//                 if (row == m - 1) col++;
//                 else if (col == 0) row++;
//                 else { row++; col--; }
//             }
//         }

//         return result;
//     }
// }









class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        boolean dir = true;
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0;
        for (int i = 0; i <= m + n - 2; i++) {
            if (dir) {
                for (int x = i < m ? i : m - 1; x >= 0; x--) {                    
                    int y = i - x;
                    if (y >= n) break;
                    res[idx++] = mat[x][y];
                }
                dir = false;
            } else {
                for (int y = i < n ? i : n - 1; y >= 0; y--) {                    
                    int x = i - y;
                    if (x >= m) break;
                    res[idx++] = mat[x][y];
                }
                dir = true;
            }
        }
        return res;
    }
}







class Solution {

    boolean check(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat[0].length;
        int n = mat.length;

        int[] ans = new int[n * m];

        int d = 1; // 1 = up-right, 0 = down-left
        int i = 0, j = 0, k = 0;

        while (k < n * m) {

            while (check(i, j, m, n)) {
                ans[k++] = mat[i][j];

                if (d == 1) {
                    i--;
                    j++;
                } else {
                    i++;
                    j--;
                }
            }

           
            if (d == 1) {
                if (j >= m) {   // right wall hit
                    i += 2;
                    j = m - 1;
                } else {        // top wall hit
                    i = 0;
                }
                d = 0;
            } else {
                if (i >= n) {   // bottom wall hit
                    j += 2;
                    i = n - 1;
                } else {        // left wall hit
                    j = 0;
                }
                d = 1;
            }
        }

        return ans;
    }
}




