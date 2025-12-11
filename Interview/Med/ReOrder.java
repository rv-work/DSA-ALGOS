class Solution {
    int ans = 0;

    void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis) {
        vis[node] = true;

        for (int nei : adj.get(node)) {

            if (vis[nei]) continue;

            ans++;

            adj.get(nei).add(node);

            dfs(adj, nei, vis);
        }
    }

    public int minReorder(int n, int[][] connections) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        boolean vis[] = new boolean[n];

        for (int[] c : connections) {
            adj.get(c[0]).add(c[1]);
        }

        dfs(adj, 0, vis);

        return ans;
    }
}
