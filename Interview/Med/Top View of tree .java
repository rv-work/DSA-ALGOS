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










// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Pair {
    int hd;
    Node node;
    
    Pair(Node node , int hd){
        this.node = node ;
        this.hd = hd;
    }
}

class Solution {
    
    
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer , Integer> mp = new TreeMap<>();
        if(root == null) return ans;
        
        q.add(new Pair(root , 0));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            if(!mp.containsKey(curr.hd)){
              mp.put(curr.hd , curr.node.data);
            } 
            
            if(curr.node.left != null){
                q.add(new Pair(curr.node.left , curr.hd - 1));
            }
            
            if(curr.node.right != null){
                q.add(new Pair(curr.node.right , curr.hd + 1));
            }
        }   
        
        for(int val : mp.values()){
            ans.add(val);
        }
        
        return ans;
    }
}