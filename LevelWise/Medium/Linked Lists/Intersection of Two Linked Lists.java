//  [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;

        ListNode tempA = headA;
        while(tempA != null){
            tempA = tempA.next;
            sizeA++;
        }

        ListNode tempB = headB;
        while(tempB != null){
            tempB = tempB.next;
            sizeB++;
        }

        tempA = headA;
        tempB = headB;

        if(sizeA > sizeB){
            for(int i = 0; i < sizeA - sizeB; i++){
                tempA = tempA.next;
            }
        } 

        else{
            for(int i = 0; i < sizeB - sizeA; i++){
                tempB = tempB.next;
            }
        }

         while(tempA != tempB){
                tempA = tempA.next;
                tempB = tempB.next;
            }

            return tempA;
    }
}