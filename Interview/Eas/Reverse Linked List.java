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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null) return null;

        // store values
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }

        // build reversed list
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for(int i = arr.size() - 1; i >= 0; i--){
            curr.next = new ListNode(arr.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}

















class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nex = head.next;
        
        while(nex != null){
            curr.next = prev;
            prev = curr;
            curr = nex;
            nex = nex.next;
        }

        curr.next = prev;

        return curr;
    }
}














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

        if(head == null) return null;

        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            nodes.add(temp);
            temp = temp.next;
        }

        for(int i = nodes.size() - 1; i > 0; i--){
            nodes.get(i).next = nodes.get(i - 1);
        }

        nodes.get(0).next = null;

        return nodes.get(nodes.size() - 1);
    }
}
