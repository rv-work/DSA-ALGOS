class Solution {

    boolean dfs(List<List<Integer>> adj, int node, int par, boolean[] vis) {
        vis[node] = true;

        for (int neigh : adj.get(node)) {

            // agar visited hai aur parent nahi hai → cycle
            if (vis[neigh] && neigh != par) return true;

            // agar visited nahi hai → DFS call
            if (!vis[neigh]) {
                if (dfs(adj, neigh, node, vis)) return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {

        boolean[] vis = new boolean[V];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        // disconnected graph ke liye
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfs(adj, i, -1, vis)) return true;
        }

        return false;
    }
}
