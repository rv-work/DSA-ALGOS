class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!dfs(i,1,color,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node, int currcolor,int color[],int graph[][]){
        color[node]=currcolor;
        for(int neigh:graph[node]){
            if(color[neigh]==0){
                if(!dfs(neigh,-currcolor,color,graph)){
                    return false;
                }
            }
            else if(color[neigh]==currcolor) return false;
        }
        return true;
    }
}











class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

            color[i] = 1;
            q.add(i);

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int neighbor : graph[cur]) {
                    if (color[neighbor] == 0) {
                        color[neighbor] = -color[cur];
                        q.add(neighbor);
                    } else if (color[neighbor] == color[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
