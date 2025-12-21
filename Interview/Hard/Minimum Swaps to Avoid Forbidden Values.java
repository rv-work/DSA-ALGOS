class Solution {

    void swap(int arr[] , int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        int swaps = 0;
        Map<Integer , List<Integer>> mp = new HashMap<>();

        for(int i = 0; i<n; i++){
            mp.computeIfAbsent(forbidden[i], k -> new ArrayList<>()).add(i);
        }

        for(int i = 0; i<n; i++){
            if(nums[i] == forbidden[i]){
                boolean swapped = false;
                int j = i+1;
                while( j < n ){
                    if(nums[j] == forbidden[j]){

                       List<Integer> listFJ = mp.get(forbidden[j]);
                       List<Integer> listNI = mp.get(nums[i]);

                       if( (listFJ != null && listFJ.contains(i)) ||
                           (listNI != null && listNI.contains(j)) ){
                           j++;
                           continue;
                       }

                       swap(nums , i , j);
                       swaps++;
                       swapped = true;
                       break;
                    }

                    j++;
                }

                if(!swapped){
                    j = 0;
                    while(j < n){

                        List<Integer> listNJ = mp.get(nums[j]);
                        List<Integer> listNI = mp.get(nums[i]);

                        if( (listNJ != null && listNJ.contains(i)) ||
                            (listNI != null && listNI.contains(j)) ){
                            j++;
                            continue;
                        }

                        swap(nums , i , j);
                        swaps++;
                        swapped = true;
                        break;
                    }
                }

               if(!swapped) return -1;
            }
        }

        return swaps;
    }
}


// kyunki best possibility nhi deta

// Input
// nums =
// [104,13,82,116,72,43,101,45,6,6,31]
// forbidden =
// [10,13,82,116,14,73,85,45,6,6,36]

// Use Testcase
// Output
// 4
// Expected
// 3






















class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;

        Map<Integer, Integer> cntNums = new HashMap<>();
        Map<Integer, Integer> cntForb = new HashMap<>();

        for (int x : nums)
            cntNums.put(x, cntNums.getOrDefault(x, 0) + 1);
        for (int x : forbidden)
            cntForb.put(x, cntForb.getOrDefault(x, 0) + 1);

        // Feasibility check
        for (int val : cntNums.keySet())
            if (cntNums.get(val) + cntForb.getOrDefault(val, 0) > n)
                return -1;

        int bad = 0;
        Map<Integer, Integer> cntBad = new HashMap<>();

        for (int i = 0; i < n; ++i) 
            if (nums[i] == forbidden[i]) {
                bad++;
                int v = nums[i];
                cntBad.put(v, cntBad.getOrDefault(v, 0) + 1);
            }

        if (bad == 0) return 0;

        int maxFreq = 0;
        // just to ensure that in bad we are not swapping the same element ...so for that maxFreq......
        for (int freq : cntBad.values())
            maxFreq = Math.max(maxFreq, freq);

        return Math.max((bad + 1) / 2, maxFreq); 
       
    }
}