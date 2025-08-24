// [Majority Element II](https://leetcode.com/problems/majority-element-ii/)


// nlogn
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int cnt = 1;
        int el = nums[0];
        if(cnt > n/3  ) ans.add(el);
        for(int i = 1; i< n ; i++){
          if(nums[i] == el){
            cnt ++;
           if(cnt > n/3){
            if(ans.size() > 0) {
                if(ans.get(ans.size() - 1 ) != el){
                   ans.add(el);
            }
            } else {
               ans.add(el);
            }
           }
            

          } else {
            el = nums[i];
            cnt = 1;
           if(cnt > n/3){
            if(ans.size() > 0) {
                if(ans.get(ans.size() - 1 ) != el){
                   ans.add(el);
            }
            } else {
               ans.add(el);
            }
           }
          }
        }


        return ans;

    }
}