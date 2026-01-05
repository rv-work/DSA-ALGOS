class Solution {
  public long maxMatrixSum(int[][] mat) {

    int n = mat.length;
    int maxNeg = Integer.MIN_VALUE;
    int minPos = Integer.MAX_VALUE;
    int cnt = 0;
    long sum = 0;

    for (int[] row : mat) {
      for (int num : row) {
        sum += Math.abs(num);
        if (num < 0) {
          cnt++;
          maxNeg = Math.max(maxNeg, num);
        } else {
          minPos = Math.min(minPos, num);
        }

      }
    }

    if (minPos == 0)
      return sum;
    if (cnt % 2 == 0)
      return sum;

    int sub = -Math.min(minPos, Math.abs(maxNeg));

    sum += 2 * sub;

    return sum;

  }
}