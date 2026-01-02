
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






class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return num;   // repeat mil gaya
            }
            seen.add(num);
        }
        return -1; // unreachable as per problem
    }
}





class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);    

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];    
            }
        }
        return -1;
    }
}


class Solution {
    public int repeatedNTimes(int[] nums) {
     Arrays.sort(nums);

     int n = nums.length;

     if(nums[0] == nums[1]) return nums[0];
     if(nums[n-1] == nums[n-2]) return  nums[n-1];
     else return nums[n/2];

    }
}



class Solution {
    public int repeatedNTimes(int[] nums) {
     Arrays.sort(nums);

     int n = nums.length;

     if(nums[0] == nums[1]) return nums[0];
     else return nums[n/2];

    }
}



