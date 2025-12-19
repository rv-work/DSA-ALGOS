class Solution {

  boolean ans(int[] stones, int idx, int lastJumped, Map<Long, Integer> mp) {
    if (idx >= stones.length - 1)
      return true;

    boolean op1 = false;
    boolean op2 = false;
    boolean op3 = false;

    if (lastJumped - 1 > 0 &&
        mp.containsKey((long) (stones[idx] + lastJumped - 1)) &&
        mp.get((long) (stones[idx] + lastJumped - 1)) > idx) {
      op1 = ans(stones, mp.get((long) (stones[idx] + lastJumped - 1)), lastJumped - 1, mp);
    }

    if (mp.containsKey((long) (stones[idx] + lastJumped))) {
      op2 = ans(stones, mp.get((long) (stones[idx] + lastJumped)), lastJumped, mp);
    }

    if (mp.containsKey((long) (stones[idx] + lastJumped + 1))) {
      op3 = ans(stones, mp.get((long) (stones[idx] + lastJumped + 1)), lastJumped + 1, mp);
    }

    return op1 || op2 || op3;
  }

  public boolean canCross(int[] stones) {
    int n = stones.length;
    if (stones[1] - stones[0] > 1)
      return false;

    Map<Long, Integer> mp = new HashMap<>();
    for (int i = 0; i < n; i++) {
      mp.put((long) stones[i], i);
    }

    return ans(stones, 1, 1, mp);
  }
}
