// [Single Number](https://leetcode.com/problems/single-number/)

class Solution {
  public int singleNumber(int[] nums) {
    int xor = 0;
    for (int num : nums)
      xor ^= num;
    return xor;
  }
}