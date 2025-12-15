class Solution {
  public int lengthOfLongestSubstring(String s) {

    int n = s.length();
    if (n <= 1)
      return n;
    int l = 0;
    int r = 0;
    int max = Integer.MIN_VALUE;
    Map<Character, Integer> map = new HashMap<>();
    while (r < n) {
      char ch = s.charAt(r);
      if (!map.containsKey(ch)) {
        map.put(ch, 1);
      } else {
        while (ch != s.charAt(l)) {
          map.remove(s.charAt(l++));
        }
        l++;
      }

      max = Math.max(max, r - l + 1);
      r++;
    }

    return max;
  }
}

class Solution {
  public int lengthOfLongestSubstring(String s) {

    int n = s.length();
    if (n <= 1)
      return n;
    int l = 0;
    int r = 0;
    int max = Integer.MIN_VALUE;
    Set<Character> set = new HashSet<>();
    while (r < n) {
      char ch = s.charAt(r);
      if (!set.contains(ch)) {
        set.add(ch);
      } else {
        while (ch != s.charAt(l)) {
          set.remove(s.charAt(l++));
        }
        l++;
      }

      max = Math.max(max, r - l + 1);
      r++;
    }

    return max;
  }
}