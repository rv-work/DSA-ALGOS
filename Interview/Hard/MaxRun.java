class Solution {
  public long maxRunTime(int n, int[] batteries) {
    long right = 0, left = 0;

    for (int b : batteries) {
      right += b;
    }
    right /= n;

    while (left < right) {
      long mid = (left + right + 1) / 2;

      if (check(n, batteries, mid)) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }

    return left;
  }

  public boolean check(int n, int[] batteries, long T) {
    long total = 0;

    for (int b : batteries) {
      total += Math.min(b, T);
      if (total >= (long) n * T) {
        return true;
      }
    }

    return total >= (long) n * T;
  }
}