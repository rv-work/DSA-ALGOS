class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        Map<String, Integer> mp = new HashMap<>();
        int[] freq = new int[26];

        int l = 0;
        int unique = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {

            int idx = s.charAt(r) - 'a';
            if (freq[idx] == 0) unique++;
            freq[idx]++;

            if (r - l + 1 > minSize) {
                int leftIdx = s.charAt(l) - 'a';
                freq[leftIdx]--;
                if (freq[leftIdx] == 0) unique--;
                l++;
            }

            if (r - l + 1 == minSize && unique <= maxLetters) {
                String sub = s.substring(l, r + 1);
                mp.put(sub, mp.getOrDefault(sub, 0) + 1);
                ans = Math.max(ans, mp.get(sub));
            }
        }

        return ans;
    }
}







class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        int[] freq = new int[26];
        int unique = 0;

        Map<String, Integer> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int l = 0, ans = 0;

        for (int r = 0; r < n; r++) {

            char ch = s.charAt(r);
            sb.append(ch);

            int idx = ch - 'a';
            if (freq[idx] == 0) unique++;
            freq[idx]++;

            if (sb.length() > minSize) {
                char left = sb.charAt(0);
                sb.deleteCharAt(0);  

                int li = left - 'a';
                freq[li]--;
                if (freq[li] == 0) unique--;
                l++;
            }

         
            if (sb.length() == minSize && unique <= maxLetters) {
                String key = sb.toString();  
                mp.put(key, mp.getOrDefault(key, 0) + 1);
                ans = Math.max(ans, mp.get(key));
            }
        }

        return ans;
    }
}







class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int n = s.length();
        int[] freq = new int[26];
        int unique = 0;

        // rolling hash variables
        long hash = 0;
        long base = 27;
        long mod = 1_000_000_007;
        long power = 1;

        // precompute base^(minSize-1)
        for (int i = 1; i < minSize; i++) {
            power = (power * base) % mod;
        }

        Map<Long, Integer> count = new HashMap<>();
        int ans = 0;

        int l = 0;

        for (int r = 0; r < n; r++) {

            // add right char to freq
            int idx = s.charAt(r) - 'a';
            if (freq[idx] == 0) unique++;
            freq[idx]++;

            // add right char to hash
            hash = (hash * base + (idx + 1)) % mod;

            // keep window size == minSize
            if (r - l + 1 > minSize) {
                int leftIdx = s.charAt(l) - 'a';

                // remove left char from hash
                hash = (hash - (leftIdx + 1) * power % mod + mod) % mod;

                // remove left char from freq
                freq[leftIdx]--;
                if (freq[leftIdx] == 0) unique--;

                l++;
            }

            // valid window
            if (r - l + 1 == minSize && unique <= maxLetters) {
                count.put(hash, count.getOrDefault(hash, 0) + 1);
                ans = Math.max(ans, count.get(hash));
            }
        }

        return ans;
    }
}
