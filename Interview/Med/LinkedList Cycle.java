/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> st = new HashSet<>();
        
        ListNode cur = head;

        while(cur != null){
            if(st.contains(cur)){
                return cur;  // jaha repeat mila that is start of cycle
            }
            st.add(cur);
            
            cur = cur.next;
        }

        return null; // no cycle
    }
}