// [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)


class Solution {
    public int fib(int n) {
        int dp[] = new int[n + 1];
        return fibbo(n, dp);
    }

    int fibbo(int n, int dp[]) {
        if (n <= 1) return n;

        if (dp[n] != 0) return dp[n];
        
        return dp[n] = fibbo(n - 1, dp) + fibbo(n - 2, dp);
    }
}
