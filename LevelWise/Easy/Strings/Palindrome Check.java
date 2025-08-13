// [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

class Solution {
    public boolean isPalindrome(String s) {
        // StringBuilder cleaned = new StringBuilder();

        // for (int i = 0; i < s.length(); i++) {
        //     char c = Character.toLowerCase(s.charAt(i));

        //      int val = c - 'a';
        //     if ((val >= 0 && val <= 25) || (c >= '0' && c <= '9')) {
        //         cleaned.append(c);
        //     }


        //     // if (Character.isLetterOrDigit(c)) {
        //     //     cleaned.append(c);
        //     // }
        // }

        // String original = cleaned.toString();
        // String reversed = cleaned.reverse().toString();

        // return original.equals(reversed);




        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        return true;





    }
}
