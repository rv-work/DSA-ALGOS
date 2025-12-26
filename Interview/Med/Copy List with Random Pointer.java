/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;

        while (curr != null) {

            if (!map.containsKey(curr)) {
                map.put(curr, new Node(curr.val));
            }

            Node clone = map.get(curr);

            
            if (curr.next != null) {
                if (!map.containsKey(curr.next)) {
                    map.put(curr.next, new Node(curr.next.val));
                }
                clone.next = map.get(curr.next);
            }

            // handle random
            if (curr.random != null) {
                if (!map.containsKey(curr.random)) {
                    map.put(curr.random, new Node(curr.random.val));
                }
                clone.random = map.get(curr.random);
            }

            curr = curr.next;
        }

        return map.get(head);
    }
}
