// [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> dq = new ArrayDeque<>();
    int i = 0;
    int j = 0;
    while (i - j != k) {
      while (!dq.isEmpty() && dq.peekFirst() < nums[i]) {
        dq.removeFirst();
      }
      if (dq.isEmpty() || dq.peekFirst() >= nums[i]) {
        dq.addFirst(nums[i]);
      }
      i++;
    }
    int[] ans = new int[nums.length - k + 1];
    ans[j] = dq.peekLast();
    while (i != nums.length) {
      if (dq.peekLast() == nums[j]) {
        dq.removeLast();
      }
      j++;
      while (!dq.isEmpty() && dq.peekFirst() < nums[i]) {
        dq.removeFirst();
      }
      if (dq.isEmpty() || dq.peekFirst() >= nums[i]) {
        dq.addFirst(nums[i]);
      }
      i++;
      ans[j] = dq.peekLast();
    }
    return ans;
  }
}



















class Solution {
    class Item implements Comparable<Item>{
        int ele;
        int idx;
        Item(int ele, int idx){
            this.ele = ele;
            this.idx = idx;
        }
        public int compareTo(Item i2){
            // return this.ele-i2.ele;   // for ascending
            return i2.ele-this.ele;   // for descending
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n-k+1];
        if(n<k) return ans;


        // Approach - 1 : Using NGE 
        // int z = 0;
        // // using next greater elements 
        // Stack<Integer> st = new Stack<>();
        // int[] nge = new int[n];
        // st.push(n-1);
        // nge[n-1] = n;
        // for(int i = n-2;i>=0;i--){
        //     while(st.size()>0 && nums[i]>nums[st.peek()]){
        //         st.pop();
        //     }
        //     if(st.size()==0) nge[i] = n;
        //     else nge[i] = st.peek();
        //     st.push(i);
        // }
        // int j =0;
        // for(int i = 0;i<n-k+1;i++){
        //     if(j>=i+k) j = i;
        //     int max = nums[j];
        //     while(j<i+k){
        //         max = nums[j];
        //         j = nge[j];
        //     }
        //     ans[z++] = max;
        // }
        // return ans;
        

        // Approach - 2 : Using PriorityQueue (maxHeap)
        PriorityQueue<Item> pq = new PriorityQueue<>();  // max-heap based on element value
        for(int i=0;i<k;i++){  // first window
            pq.add(new Item(nums[i], i));
        }
        ans[0]=pq.peek().ele; // store maximum of the first window
        for(int i = k; i<n;i++){
            
            pq.add(new Item(nums[i], i)); // add current element with index

            // remove all elements from heap which are outside the window
            while(pq.peek().idx <= i-k){
                pq.remove();
            }

            ans[i-k+1]=pq.peek().ele; // maximum of the current window is at the top
        }
        return ans;
    }
}