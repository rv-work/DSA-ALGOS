// [Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes/)

class Solution {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
