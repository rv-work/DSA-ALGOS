
class Solution {
  public int repeatedNTimes(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();

    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
      if (freq.get(num) > 1) {
        return num;
      }
    }
    return -1; // never reached as per constraints
  }
}
