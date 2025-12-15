class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int l = 0;
        int maxLen = 0;

        Map<Character, Integer> mp = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            while (true) {

                int total = 0;
                int Lmax = 0;

                for (int val : mp.values()) {
                    Lmax = Math.max(Lmax, val);
                    total += val;
                }

                int needToChange = total - Lmax;

                if (needToChange <= k) break;

                char leftChar = s.charAt(l);
                mp.put(leftChar, mp.get(leftChar) - 1);
                if (mp.get(leftChar) == 0)
                    mp.remove(leftChar);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}









class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int l = 0;
        int maxLen = 0;

        Map<Character, Integer> mp = new HashMap<>();
        int maxFreq = 0;  

        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, mp.get(c));

            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                mp.put(leftChar, mp.get(leftChar) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}






class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int l = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {

            int idx = s.charAt(r) - 'A';
            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            int windowSize = r - l + 1;

            if (windowSize - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
