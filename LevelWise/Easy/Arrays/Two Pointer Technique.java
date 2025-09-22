// [Two Sum](https://leetcode.com/problems/two-sum/)


class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;
       int left = 0 , right = n-1;

       int[][] arr = new int [n][2];

       for(int i = 0; i<n; i++){
        arr[i][0] = nums[i];
        arr[i][1] = i;
       }

       Arrays.sort(arr , (a , b ) -> Integer.compare(a[0] , b[0]));

       while (left < right){
        int sum = arr[left][0] + arr[right][0];

        if(sum == target){
            return new int[]{arr[left][1] , arr[right][1]};
        } else if ( sum > target){
            right --;
        } else {
            left ++;
        }


       }

       return new int []{};

    }
}







class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();

        while(i < m && j < n){
            if(nums1[i][0] == nums2[j][0]){
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++; j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                result.add(nums1[i]);
                i++;
            }
            else{
                result.add(nums2[j]);
                j++;
            }
        }
        while(i < m){
            result.add(nums1[i]);
            i++;
        }
        while(j < n){
            result.add(nums2[j]);
            j++;
        }
        return result.toArray(new int[result.size()][]);
    }
}