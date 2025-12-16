/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {

    public ArrayList<Integer> topView(Node root) {

    ArrayList<Integer> ans = new ArrayList<>();
    if (root == null) return ans;

    Map<Integer, Integer> mp = new TreeMap<>(); 
    Queue<Node> q = new LinkedList<>();
    Queue<Integer> hdq = new LinkedList<>();

    q.offer(root);
    hdq.offer(0);

    while (!q.isEmpty()) {
        Node curr = q.poll();
        int hd = hdq.poll();

        if (!mp.containsKey(hd)) {
            mp.put(hd, curr.data);  
        }

        if (curr.left != null) {
            q.offer(curr.left);
            hdq.offer(hd - 1);
        }

        if (curr.right != null) {
            q.offer(curr.right);
            hdq.offer(hd + 1);
        }
    }

    for (int val : mp.values()) ans.add(val);
    
    return ans;
    
    }

}