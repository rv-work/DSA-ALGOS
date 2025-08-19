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




// class Solution {
//     public int strStr(String haystack, String needle) {
//         for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
//             if(haystack.substring(i,j).equals(needle)){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }





class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int n = haystack.length();
        int m = needle.length();

        // Step 1: Build LPS array
        int[] lps = buildLPS(needle);

        int i = 0; // haystack index
        int j = 0; // needle index

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return i - j; // match found
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1]; // jump using lps
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] buildLPS(String needle) {
        int m = needle.length();
        int[] lps = new int[m];

        int len = 0; 
        int i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; 
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
