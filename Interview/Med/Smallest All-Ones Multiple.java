class Solution {
    public int minAllOneMultiple(int k) {
        int rem = 0;
        int ans = 0;
        Set<Integer> st = new HashSet<>();

        while(!st.contains(rem)){ // reminder repeat matlab .... KHATAM
            st.add(rem);
            rem = (rem * 10 + 1) % k;
            ans++;
            if(rem == 0) return ans;
        }

        return -1;
    }
}







class Solution {
    public int minAllOneMultiple(int k) {
        if(k % 2 == 0 || k % 5 == 0) return - 1;
        int rem = 0;
        for(int i = 1; i <= k; i++) {
            rem = (rem * 10 + 1) % k;
            if(rem == 0) return i;
        }
        return -1;
    }
}