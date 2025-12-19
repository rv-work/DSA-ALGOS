class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        boolean[] vis = new boolean[V];
        int [] idg = new int[V];
        List<Integer> topo = new ArrayList<>();


        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            idg[e[1]]++;
        } 
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<V; i++){
            if(idg[i] == 0){
                q.add(i);
            }
        }
        
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i< size; i++){
                
                int node = q.poll();
                topo.add(node);
                
                for(int j = 0; j<adj.get(node).size(); j++){
                    int nei = adj.get(node).get(j);
                    idg[nei]--;
                    if(idg[nei] == 0) q.add(nei);
                }
            }
        }
        
        
        return topo.size() != V;
    }
}









class Solution {

    public boolean isCyclic(int V, int[][] edges) {

        boolean[] vis = new boolean[V];
        int [] idg = new int[V];
        List<Integer> topo = new ArrayList<>();


        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            idg[e[1]]++;
        } 
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<V; i++){
            if(idg[i] == 0){
                q.add(i);
            }
        }
        
        
        while(!q.isEmpty()){
                int node = q.poll();
                topo.add(node);
                
                for(int j = 0; j<adj.get(node).size(); j++){
                    int nei = adj.get(node).get(j);
                    idg[nei]--;
                    if(idg[nei] == 0) q.add(nei);
                }
        }
        
        
        return topo.size() != V;
    }
}
