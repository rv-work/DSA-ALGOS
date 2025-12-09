class Solution {
    
    void dfs( boolean vis[] , int[][] isConnected , int node){

        vis[node] = true;

        for(int i = 0; i< isConnected[node].length; i++){
            if(i != node && !vis[i] && isConnected[node][i] == 1)
            dfs(vis , isConnected , i);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int  n = isConnected.length;
        boolean vis[] = new boolean[n];
        int ans = 0;

        for(int i = 0; i< n; i++){
            if(!vis[i]){
                dfs(vis , isConnected , i);
                ans++;
            }
        }


        return ans ;
    }
}