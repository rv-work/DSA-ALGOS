class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        
        Queue<Integer> q = new LinkedList<>();
        
        vis[0] = true;

        for(int i = 0; i< rooms.get(0).size(); i++){
            q.add(rooms.get(0).get(i));
        }

        while(!q.isEmpty()){
          int key = q.poll();
          vis[key] = true;

          for(int i = 0; i< rooms.get(key).size(); i++){
            if(!vis[rooms.get(key).get(i)])
              q.add(rooms.get(key).get(i));
          }

        }


        for(int i = 0; i< vis.length; i++){
            if(!vis[i]) return false;
        }



        return true;
    }
}








////////DFS


class Solution {
    
    void dfs (boolean vis[] , int key , List<List<Integer>> rooms){
       vis[key] = true;

        for(int i = 0; i< rooms.get(key).size(); i++){
            if(!vis[rooms.get(key).get(i)])
            dfs(vis , rooms.get(key).get(i) ,  rooms);
        }
    }



    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];
        vis[0] = true;

        for(int i = 0; i< rooms.get(0).size(); i++){
            dfs(vis , rooms.get(0).get(i) , rooms);
        }

       

        for(int i = 0; i< vis.length; i++){
            if(!vis[i]) return false;
        }

        return true;
    }
}