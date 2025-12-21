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