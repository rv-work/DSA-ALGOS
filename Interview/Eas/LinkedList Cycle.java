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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        
        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur)) return true;
            
            set.add(cur);
            cur = cur.next;
        }
        
        return false;
    }
}










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
    public boolean hasCycle(ListNode head) {

      ListNode cur = head;
    int steps = 10001;

    while(cur != null && steps-- > 0){
        cur = cur.next;
    }
    return cur != null; // true means cycle
    }
}





// cycle means null tak kabhi phuchengi hi nhi 