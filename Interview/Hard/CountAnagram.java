class Solution {

    static final long MOD = 1_000_000_007;

    long modPow(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    long modInverse(long a) {
        return modPow(a, MOD - 2);  
    }

    public int countAnagrams(String s) {

        String[] words = s.split(" ");

        int maxLen = 100000;
        long[] fact = new long[maxLen + 1];
        fact[0] = 1;

        for (int i = 1; i <= maxLen; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long ans = 1;

        for (String word : words) {

            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            long ways = fact[word.length()];

            for (int f : freq) {
                if (f > 1) {
                    ways = (ways * modInverse(fact[f])) % MOD;
                }
            }

            ans = (ans * ways) % MOD;
        }

        return (int) ans;
    }
}
