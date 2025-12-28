class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans = 0;
        
        if(need1 != 0 && need2 != 0){
            
            int min = Math.min(need1 , need2);
            
            if( (long) (cost1 + cost2) < costBoth){
                ans +=  (long) (cost1 + cost2) *min;
            } else {
                ans += (long)  costBoth*min;
            }
            need1 -= min;
            need2 -= min;
        }


        if(need1 != 0){
            if(cost1 < costBoth){
                ans += (long)  cost1*need1;
            } else {
                ans += (long)  costBoth*need1;
            }
        }
        
        if(need2 != 0){
            if(cost2 < costBoth){
                ans += (long)  cost2*need2;
            } else {
                ans += (long)  costBoth*need2;
            }
        }


        return ans;
    }
}