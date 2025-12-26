/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        if (n < k) return head;

        ListNode ans = null;
        ListNode prevGroupTail = null;
        ListNode nex = head;

        int i = 0;
        while (i + k <= n) {

            ListNode PREV = nex;
            ListNode prev = null;
            curr = nex;

            int cnt = k;
            while (cnt-- > 0) {
                curr = nex;
                nex = nex.next;
                curr.next = prev;
                prev = curr;
            }

            if (ans == null) ans = curr;
            else prevGroupTail.next = curr;

            PREV.next = nex;
            prevGroupTail = PREV;

            i += k;
        }

        return ans;
    }
}




