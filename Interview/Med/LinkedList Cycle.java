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
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: detect if cycle exists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){ 
                break;
            }
        }

        // no cycle
        if(fast == null || fast.next == null) 
            return null;

        // Phase 2: move slow to head, keep fast at meeting point
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;  // cycle start node
    }
}







// a = distance from head to cycle start

// b = distance from cycle start to meeting point

// c = remaining cycle distance to return to cycle start

// Cycle length = b + c

// 🔥 Step 1: Meeting point kaise banta hai?

// Slow moves 1 step,
// Fast moves 2 steps,
// So fast 2x speed pe hai.

// At meeting:

// distance slow ran  = a + b  
// distance fast ran  = a + b + n(b + c)


// fast slow se n cycles zyada daudta hai.

// So:

// 2(a + b) = a + b + n(b + c)


// Solve:

// a + b = n(b + c)
// a = n(b + c) − b
// a = (n − 1)(b + c) + c