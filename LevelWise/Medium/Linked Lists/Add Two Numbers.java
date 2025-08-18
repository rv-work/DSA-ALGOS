// [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = null ;
        ListNode temp = new ListNode(0);
        int carry = 0;
        while(temp1 != null || temp2 != null || carry != 0){
            int f = 0, s = 0 , num = 0;
            int  digit = 0;

            if(temp1 != null) f = temp1.val;
            if(temp2 != null) s = temp2.val; 
            
            if(f+s+carry >= 10){
              digit = (f+s+carry) % 10;
              carry = 1;
            }
            else {
              digit = (f+s+carry) ;
              carry = 0;
            } 
        
            
            ListNode node = new ListNode(digit);
            temp.next = node;
            temp = node;
            if(head == null) head = temp;

            if(temp1 != null ) temp1 = temp1.next;
            if(temp2 != null ) temp2 = temp2.next;
        }

        return head;
    }
}