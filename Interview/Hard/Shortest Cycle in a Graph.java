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
