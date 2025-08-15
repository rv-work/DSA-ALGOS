//  [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)



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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = null;
        ListNode nex = head;

        while(nex != null){
          prev = curr;
          curr = nex;
          nex = nex.next;
          curr.next = prev;
        }

        return curr;
        
    }
}