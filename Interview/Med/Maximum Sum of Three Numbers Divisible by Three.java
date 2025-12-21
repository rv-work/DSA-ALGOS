class Solution {
    public int maximumSum(int[] nums) {

        
        Map<Integer, List<Integer>> mp = new HashMap<>();
        mp.put(0, new ArrayList<>());
        mp.put(1, new ArrayList<>());
        mp.put(2, new ArrayList<>());

        for(int x : nums){
            mp.get(x % 3).add(x);
        }

      
        for(int r = 0; r < 3; r++){
            mp.get(r).sort((a,b) -> b-a);
        }

        int ans = 0;

      
        ans = Math.max(ans, take(mp.get(0), 3));     // (0,0,0)
        ans = Math.max(ans, take(mp.get(1), 3));     // (1,1,1)
        ans = Math.max(ans, take(mp.get(2), 3));     // (2,2,2)


        // (0,1,2)
        if(mp.get(0).size() >= 1 && mp.get(1).size() >= 1 && mp.get(2).size() >= 1){
            ans = Math.max(ans, 
                mp.get(0).get(0) + mp.get(1).get(0) + mp.get(2).get(0)
            );
        }

        return ans;
    }

    private int take(List<Integer> arr, int k){
        if(arr.size() < k) return 0;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr.get(i);
        }
        return sum;
    }
}
