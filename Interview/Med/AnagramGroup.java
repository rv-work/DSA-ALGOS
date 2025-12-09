class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();

        int cnt = 0;

        for (String str : strs) {

            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sr = new String(arr);

            if (!mp.containsKey(sr)) {
                mp.put(sr, cnt);               
                ans.add(new ArrayList<>());
                ans.get(cnt).add(str);
                cnt++;
            } 
            else {
                ans.get(mp.get(sr)).add(str);
            }
        }

        return ans;
    }
}
