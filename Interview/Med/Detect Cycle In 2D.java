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







class Solution {

    int[] row = {-1,0,1,0};
    int[] col = {0,1,0,-1};

    boolean bound(int m, int n, int i, int j){
        return i>=0 && j>=0 && i<m && j<n;
    }

    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(vis[i][j]) continue;

                Queue<int[]> q = new LinkedList<>();

                vis[i][j] = true;
                q.add(new int[]{i, j, -1, -1}); 
                // {curr_r, curr_c, parent_r, parent_c}

                while(!q.isEmpty()){

                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];
                    int pr = cur[2];
                    int pc = cur[3];

                    for(int k = 0; k < 4; k++){

                        int nr = cr + row[k];
                        int nc = cc + col[k];

                        if(!bound(m,n,nr,nc)) continue;

                        if(grid[nr][nc] != grid[cr][cc]) continue;

                        // if not visited -> push
                        if(!vis[nr][nc]){
                            vis[nr][nc] = true;
                            q.add(new int[]{nr, nc, cr, cc});
                        }

                        // if visited && not parent => cycle
                        else{
                            if(!(nr == pr && nc == pc))
                                return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
