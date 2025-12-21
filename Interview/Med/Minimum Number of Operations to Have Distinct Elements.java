class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int i = n-1; 
        Set<Integer> st = new HashSet<>();
        
        while(i >= 0){
            if(st.contains(nums[i])) break;
            st.add(nums[i]);
            i--;
        }
        
        if(i < 0) return 0;

        int without = n - 1 - i;  

        int tooRemove = i + 1;

        int div = tooRemove / 3;

        if(tooRemove % 3 == 0) return div;
        else return div + 1;
    }
}














class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        Set<Integer> st = new HashSet<>();
        
        while (i >= 0) {
            if (st.contains(nums[i])) break;
            st.add(nums[i]);
            i--;
        }

        if (i < 0) return 0;

        int needRemove = i + 1;

        return (needRemove + 2) / 3;
    }
}
