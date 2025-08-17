// [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)










class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        

        int max = 1;
        String S = s.substring(0, 1);

        for (int i = 0; i < n; i++) {
            
            // odd length palindrome
            int j = i, k = i;
            while (j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                if (k - j + 1 > max) {
                    max = k - j + 1;
                    S = s.substring(j, k + 1);
                }
                j--;
                k++;
            }

            // even length palindrome
            j = i - 1; 
            k = i;
            while (j >= 0 && k < n && s.charAt(j) == s.charAt(k)) {
                if (k - j + 1 > max) {
                    max = k - j + 1;
                    S = s.substring(j, k + 1);
                }
                j--;
                k++;
            }
        }

        return S;
    }
}
