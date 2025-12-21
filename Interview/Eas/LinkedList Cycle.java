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

        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;          
            fast = fast.next.next;     

            if(slow == fast) return true;   
        }

        return false; 
    }
}





// cycle means null tak kabhi phuchengi hi nhi 