class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        int temp = n;

        if (temp == 0) return 0;  

        StringBuilder sb = new StringBuilder();
        while (temp > 0) {
            int digit = temp % 10;
            if (digit != 0) sb.append(digit);
            temp /= 10;
        }

        sb.reverse();

        if (sb.length() == 0) x = 0;
        else x = Long.parseLong(sb.toString());

        long sum = 0;
        long t = x;
        while (t > 0) {
            sum += t % 10;
            t /= 10;
        }

        return x * sum;
    }
}