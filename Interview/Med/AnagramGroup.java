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





class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            String key = Arrays.toString(freq);

            // map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }

        return new ArrayList<>(map.values());
    }
}
