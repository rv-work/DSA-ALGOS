// [Implement strStr()](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)


// class Solution {
//     public int strStr(String h, String n) {
//         if(!h.contains(n)) return -1;

//         for(int i = 0; i < h.length(); i++){
//             if(h.charAt(i) == n.charAt(0) && h.length() - i  >= n.length()){
//                 boolean ch = true;
//                 for(int j = 0; j< n.length(); j++){
//                     if(h.charAt(j+i) != n.charAt(j)){
//                         ch = false;
//                         break;
//                     } 
//                 }
//                 if(ch == true)
//                 return i;
//             }
//         }

//         return -1;
//     }
// }




class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}