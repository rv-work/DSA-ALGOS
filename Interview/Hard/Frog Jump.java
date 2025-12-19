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

















class Solution {

  boolean ans(int[] stones, int idx, int lastJumped, Map<Long, Integer> mp) {
    if (idx >= stones.length - 1)
      return true;

    for (int d = -1; d <= 1; d++) {

      int nextJump = lastJumped + d;
      if (nextJump <= 0) continue;

      long nextStone = stones[idx] + nextJump;
      if (!mp.containsKey(nextStone)) continue;

      int nextIndex = mp.get(nextStone);
      if (nextIndex <= idx) continue;

      if (ans(stones, nextIndex, nextJump, mp)) {
          return true;
      }

      return false;
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




class Solution {

  boolean ans(int[] stones ,  int idx , int lastJumped , 
           Map<Long , Integer> mp , Map<Long , Boolean> [] dp) {

   if(idx == stones.length - 1) 
       return true;

   if(dp[idx].containsKey((long) lastJumped)) 
       return dp[idx].get((long) lastJumped);

   boolean op1 = false;
   boolean op2 = false;
   boolean op3 = false;

   // lastJumped - 1
   if(lastJumped - 1 > 0)
   {
       long nextStone = stones[idx] + lastJumped - 1;
       if(mp.containsKey(nextStone))
       {
           int nextIdx = mp.get(nextStone);
           if(nextIdx > idx)
               op1 = ans(stones , nextIdx , lastJumped - 1 , mp , dp);
       }
   }

   // lastJumped
   {
       long nextStone = stones[idx] + lastJumped;
       if(mp.containsKey(nextStone))
       {
           int nextIdx = mp.get(nextStone);
           if(nextIdx > idx)
               op2 = ans(stones , nextIdx , lastJumped , mp , dp);
       }
   }

   // lastJumped + 1
   {
       long nextStone = stones[idx] + lastJumped + 1;
       if(mp.containsKey(nextStone))
       {
           int nextIdx = mp.get(nextStone);
           if(nextIdx > idx)
               op3 = ans(stones , nextIdx , lastJumped + 1 , mp , dp);
       }
   }

   boolean ans = op1 || op2 || op3;

   dp[idx].put((long) lastJumped , ans);

   return ans;
}

public boolean canCross(int[] stones) {

   int n = stones.length;

  if (stones[1] - stones[0] > 1)
 return false;

   Map<Long, Boolean>[] dp = new HashMap[n];
   for (int i = 0; i < n; i++)
       dp[i] = new HashMap<>();

   Map<Long, Integer> mp = new HashMap<>();
   for (int i = 0; i < n; i++)
       mp.put((long) stones[i], i);

   return ans(stones, 1, 1, mp, dp);
}
}
