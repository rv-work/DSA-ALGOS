/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {

    public int minTime(Node root, int target) {

        // Step-1: build parent map + find target node
        Map<Node, Node> parent = new HashMap<>();
        Node targetNode = buildParent(root, parent, target);

        // Step-2: BFS burning from target
        Queue<Node> q = new LinkedList<>();
        Set<Node> vis = new HashSet<>();

        q.add(targetNode);
        vis.add(targetNode);

        int time = 0;

        while(!q.isEmpty()) {

            int size = q.size();
            boolean burnedSomething = false;

            while(size-- > 0) {

                Node cur = q.poll();

                // left
                if(cur.left != null && !vis.contains(cur.left)) {
                    vis.add(cur.left);
                    q.add(cur.left);
                    burnedSomething = true;
                }

                // right
                if(cur.right != null && !vis.contains(cur.right)) {
                    vis.add(cur.right);
                    q.add(cur.right);
                    burnedSomething = true;
                }

                // parent
                Node par = parent.get(cur);
                if(par != null && !vis.contains(par)) {
                    vis.add(par);
                    q.add(par);
                    burnedSomething = true;
                }
            }

            if(burnedSomething) time++;
        }

        return time;
    }


    // Build parent links + return target node reference
    private Node buildParent(Node root, Map<Node, Node> parent, int target) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node targetNode = null;

        while(!q.isEmpty()) {

            Node cur = q.poll();

            if(cur.data == target)
                targetNode = cur;

            if(cur.left != null) {
                parent.put(cur.left, cur);
                q.add(cur.left);
            }

            if(cur.right != null) {
                parent.put(cur.right, cur);
                q.add(cur.right);
            }
        }

        return targetNode;
    }
}
