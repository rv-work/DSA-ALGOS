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























/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    // Count the number of nodes in the current group
    ListNode node = head;
    int count = 0;
    while (node != null && count < k) {
      node = node.next;
      count++;
    }

    // If there are fewer than k nodes, return the head as is
    if (count < k) {
      return head;
    }

    // Reverse the k-group
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;
    int cnt = 0;

    while (curr != null && cnt < k) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      cnt++;
    }

    // Recursively reverse the next groups and attach them
    if (next != null) {
      head.next = reverseKGroup(next, k);
    }

    // Return the new head of the reversed list
    return prev;
  }
}
