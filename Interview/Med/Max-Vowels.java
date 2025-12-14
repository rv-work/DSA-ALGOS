class Solution {

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int maxVowels(String s, int k) {
        int n = s.length();

        int l = 0, r = 0;
        int curr = 0;

        // first window
        while (r < k) {
            if (isVowel(s.charAt(r++))) curr++;
        }

        int max = curr;

        while (r < n) {
            if (isVowel(s.charAt(r++))) curr++;
            if (isVowel(s.charAt(l++))) curr--;

            max = Math.max(max, curr);
        }

        return max;
    }
}
