/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
  public Node cloneGraph(Node node) {
    if (node == null)
      return null;

    Map<Node, Node> map = new HashMap<>();
    Queue<Node> q = new LinkedList<>();

    map.put(node, new Node(node.val));
    q.add(node);

    while (!q.isEmpty()) {
      Node curr = q.poll();

      for (Node nei : curr.neighbors) {

        // clone neighbor if not done
        if (!map.containsKey(nei)) {
          map.put(nei, new Node(nei.val));
          q.add(nei);
        }

        // connect clone
        map.get(curr).neighbors.add(map.get(nei));
      }
    }

    return map.get(node);
  }
}

/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * public Node() {
 * val = 0;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val) {
 * val = _val;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val, ArrayList<Node> _neighbors) {
 * val = _val;
 * neighbors = _neighbors;
 * }
 * }
 */class Solution {

  Map<Node, Node> map = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null)
      return null;

    // agar pehle se cloned hai
    if (map.containsKey(node)) {
      return map.get(node);
    }

    // step 1: current node ka clone
    Node clone = new Node(node.val);
    map.put(node, clone);

    // step 2: neighbors clone karo
    for (Node nei : node.neighbors) {
      clone.neighbors.add(cloneGraph(nei));
    }

    return clone;
  }
}
