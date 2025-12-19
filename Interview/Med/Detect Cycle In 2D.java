class Solution {

    int[] row = {-1,0,1,0};
    int[] col = {0,1,0,-1};

    boolean boundy(int m , int n , int i , int j){
        return i>= 0 && j >= 0 && i < m && j< n;
    }

    boolean dfs( boolean vis[][] , boolean cp[][] , char[][] grid , int i , int j ,int len , int pi , int pj){
        int m = grid.length , n = grid[0].length;
        vis[i][j] = true;
        cp[i][j] = true;
        
        for(int k = 0; k<4; k++){
            int nextR =  i+row[k];
            int nextC =  j+col[k];
            if(!boundy(m , n ,nextR , nextC)) continue;
            if(grid[i][j] != grid[nextR][nextC]) continue;
            if(nextR == pi && nextC == pj ) continue;
            if(cp[nextR][nextC] && len >= 4) return true;
            if(!vis[nextR][nextC] && dfs(vis , cp , grid , nextR , nextC  , len+1, i , j)) return true;
        }
        
        cp[i][j] = false;
        return false;
        
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean vis [][] = new boolean[m][n];
        boolean currPath [][] = new boolean[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(!vis[i][j] && dfs(vis, currPath , grid , i , j , 1 , -1, -1)) return true;
            }
        }
        return false;
    }
}



