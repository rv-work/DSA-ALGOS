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










class Solution {

  boolean ans(int[] stones, int idx, int lastJumped, 
              Map<Long, Integer> mp, Map<Long, Boolean>[] dp) {

      if (idx == stones.length - 1)
          return true;

      if (dp[idx].containsKey((long) lastJumped))
          return dp[idx].get((long) lastJumped);

      boolean op = false;

      // lastJumped - 1
      if (lastJumped - 1 > 0) {
          long nextStone = (long) stones[idx] + lastJumped - 1;
          if (mp.containsKey(nextStone)) {
              int nextIdx = mp.get(nextStone);
              if (nextIdx > idx) {
                  if (ans(stones, nextIdx, lastJumped - 1, mp, dp)) {
                      dp[idx].put((long) lastJumped, true);
                      return true;
                  }
              }
          }
      }

      // lastJumped
      {
          long nextStone = (long) stones[idx] + lastJumped;
          if (mp.containsKey(nextStone)) {
              int nextIdx = mp.get(nextStone);
              if (nextIdx > idx) {
                  if (ans(stones, nextIdx, lastJumped, mp, dp)) {
                      dp[idx].put((long) lastJumped, true);
                      return true;
                  }
              }
          }
      }

      // lastJumped + 1
      {
          long nextStone = (long) stones[idx] + lastJumped + 1;
          if (mp.containsKey(nextStone)) {
              int nextIdx = mp.get(nextStone);
              if (nextIdx > idx) {
                  if (ans(stones, nextIdx, lastJumped + 1, mp, dp)) {
                      dp[idx].put((long) lastJumped, true);
                      return true;
                  }
              }
          }
      }

      dp[idx].put((long) lastJumped, false);
      return false;
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










class Solution {

  boolean ans(int[] stones, int idx, int lastJumped, Map<Long, Integer> mp, Map<Long, Boolean>[] dp) {
      if (idx == stones.length - 1)
          return true;

      if (dp[idx].containsKey((long) lastJumped))
          return dp[idx].get((long) lastJumped);

      for (int d = -1; d <= 1; d++) {

          int nextJump = lastJumped + d;
          if (nextJump <= 0) continue;

          long nextStone = stones[idx] + nextJump;
          if (!mp.containsKey(nextStone)) continue;

          int nextIndex = mp.get(nextStone);
          if (nextIndex <= idx) continue;

          if (ans(stones, nextIndex, nextJump, mp, dp)) {
              dp[idx].put((long) lastJumped, true);
              return true;
          }
      }

      dp[idx].put((long) lastJumped, false);
      return false;
  }

  public boolean canCross(int[] stones) {

      int n = stones.length;

      if (n > 1 && stones[1] != 1)
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



class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        
        if (stones[1] != 1)
            return false;

        HashSet<Integer>[] dp = new HashSet[n];

        for (int i = 0; i < n; i++)
            dp[i] = new HashSet<>();

        dp[1].add(1);

        for (int i = 2; i < n; i++) {

            for (int j = i - 1; j >= 0; j--) {

                int diff = stones[i] - stones[j];

                if (diff > j + 1) break; 

                if (dp[j].contains(diff) ||
                    dp[j].contains(diff - 1) ||
                    dp[j].contains(diff + 1)) {

                    dp[i].add(diff);

                    if (i == n - 1) return true;
                }
            }
        }

        return !dp[n - 1].isEmpty();
    }
}



class Solution {

    

    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] !=  1)
            return false;

        Map<Long, Boolean>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) dp[i] = new HashMap<>();
        
        dp[0].put((long)stones[0] , true);
        dp[0].put((long)stones[1] , true);

        boolean ans = false;

        for(int i = 1; i<n; i++){
            for(int j = i-1; j>=0; j--){
              int jumpNeed = stones[i] - stones[j];

              if(dp[j].containsKey((long)jumpNeed) && dp[j].get((long)jumpNeed)){
                for(int jump = jumpNeed - 1; jump <= jumpNeed + 1; jump++){
                    dp[i].put((long)jump  , true);
                    if(stones[n-1] == jump + stones[i]) ans = true;
                }
              }

            } 
        }     
       return ans;
    }
}



