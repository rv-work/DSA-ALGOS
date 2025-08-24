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














// n

class Solution {
    public List<Integer> majorityElement(int[] nums) {
         int n = nums.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != nums[i]) {
                cnt1 = 1;
                el1 = nums[i];
            } else if (cnt2 == 0 && el1 != nums[i]) {
                cnt2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) cnt1++;
            else if (nums[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements: confirmation
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) cnt1++;
            if (nums[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

  

        return ls;
    }
}