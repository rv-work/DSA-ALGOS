import java.util.*;

class Solution {
  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, (a, b) -> a[1] - b[1]);
    int[] arr = new int[1001];

    for (int[] trip : trips) {
      int passengers = trip[0];
      int start = trip[1];
      int end = trip[2];

      // Pickup
      arr[start] += passengers;
      // Drop off
      arr[end] -= passengers;
    }

    int passengers = 0;
    for (int i = 0; i < 1001; i++) {
      passengers += arr[i];
      if (passengers > capacity)
        return false;
    }

    return true;
  }
}
