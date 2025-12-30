class Solution {
    int ans = Integer.MAX_VALUE;

    void dfs(int node, int num[], boolean[] vis, List<List<Integer>> adj, int par) {
        vis[node] = true;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int nei = adj.get(node).get(i);
            if (nei == par)
                continue;
            if (vis[nei] && num[nei] < num[node]) { 
                // this is for ki sirf forward jate time calc ho backtrack me nhi 

//             dfs(3)
//              dfs(4)
//                dfs(5)
//                  dfs(6)
//                    sees 3 → valid cycle (4)
//                  return
//                return
//              return

                ans = Math.min(ans, num[node] - num[nei] + 1);
            }

            if (!vis[nei]) {
                num[nei] = num[node] + 1;
                dfs(nei, num, vis, adj, node);
            }
        }
    }

    public int findShortestCycle(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                number[i] = 1;
                dfs(i, number, vis, adj, -1);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}






//  A 
// / \
// B--E   
// |  |
// C--D

// in these type of cases DFS will face

// may be it visit like ... A B C D E then found cycle ... A-B-C-D-E-A ok and A-B-C-D-E-B is also ok still not shortes na 
// now when it will backtrack so on B to E it will it will found that again so it will find B-E while will be counted as B-C-D-E-B ..... which is also not shortest
// actuall ans is A-B-E-A but it will never get this in this way


// now if after B we go to E first then we will get right ans.... which depends on adj build


// That's why DFS give but not guaranteed  to be shortest.....







class Solution {
    int res = Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (steps[i] == Integer.MAX_VALUE) {
                dfs(i, -1, graph, steps, 0);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void dfs(int cur, int parent, List<Integer>[] graph, int[] steps, int step) {
        // consider example edges = [[5,6],[1,7],[3,8],[5,8],[1,8],[0,4],[8,7],[7,2],[2,5],[3,4]]
        // n = 9, the bigger cycle is detected first with length 5 and then 4
        // but the shortest cycle is 3, so can't early return with step > steps[cur]
        // must keep dfs when we see a visited node with step > step + 1
        steps[cur] = step;
        for (int next : graph[cur]) {
            if (next == parent) {
                continue;
            }
            if (steps[next] > step + 1) {
                dfs(next, cur, graph, steps, step + 1);                
            } else if (steps[next] < step){
                res = Math.min(res, step - steps[next] + 1);
            }
        }
    }
}







class Solution {
    public int findShortestCycle(int n, int[][] edges) {

        // Represent edge -> graph
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int shortest = Integer.MAX_VALUE; // ans
        for(int start=0; start<n; start++){
            int[] parent = new int[n]; // will store the parent for each nodes
            Arrays.fill(parent, -1); // initially
            int[] level = new int[n]; // will store the dist from parent node
            Arrays.fill(level, -1); // initially to mark as un-visited

            Queue<Integer> q = new LinkedList<>(); // for bfs
            q.offer(start); // start from this node
            level[start] = 0; // starting dist

            //BFS

            while(!q.isEmpty()){
                int curr = q.poll();
                for(int neighbour : graph[curr]){
                    if(level[neighbour]==-1){ // matlb abhi visited nahi h
                        level[neighbour] = level[curr] + 1; // increase dist
                        parent[neighbour] = curr; // assign parent
                        q.offer(neighbour); // add it to q for next processing
                    }else if(neighbour != parent[curr]){ // visited hai aur parent bhi nahi h, matlb back edge h (kisi ne visit kiya h pkka cycle h)
                    int currCycle = level[neighbour] + level[curr] + 1; // curr tak ka dist + curr se neighbour tak ka dist + 1 (for parent)
                        shortest = Math.min(shortest, currCycle); // update shortest
                    }
                }
            }
        }
        return shortest==Integer.MAX_VALUE? -1 : shortest;
    }
}














class Solution {
    int max = Integer.MAX_VALUE; 
    
    class Pair {
        int node, parent;
        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    };

    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            BFS(graph, i, n);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public void BFS(List<List<Integer>> graph, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node, parent = p.parent;

            for (int nbr : graph.get(node)) {
                if (nbr == parent) continue;

                if (dist[nbr] == -1) { 
                    dist[nbr] = dist[node] + 1;
                    q.add(new Pair(nbr, node));
                } else { 
                    max = Math.min(max, dist[node] + dist[nbr] + 1);
                }
            }
        }
    }
}