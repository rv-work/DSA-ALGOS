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