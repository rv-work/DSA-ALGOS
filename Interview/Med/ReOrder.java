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





class Solution {
    public int minReorder(int n, int[][] connections) {

        // out[u] = nodes that u points to (original edges u -> v)
        // in[v]  = nodes that point to v (original edges u -> v)
        List<List<Integer>> out = new ArrayList<>();
        List<List<Integer>> in  = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            out.add(new ArrayList<>());
            in.add(new ArrayList<>());
        }

        // Fill out[] and in[]
        for (int[] e : connections) {
            int u = e[0], v = e[1];
            out.get(u).add(v); // original direction u -> v
            in.get(v).add(u);  // reverse direction info
        }

        boolean[] canReach0 = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        // --------------------------------------------------------
        // Step A: Find nodes that can ALREADY reach 0 (BFS on reversed edges)
        // --------------------------------------------------------

        canReach0[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();

            // incoming edges p -> node means on reverse graph node -> p
            for (int p : in.get(node)) {
                if (!canReach0[p]) {
                    canReach0[p] = true;
                    q.add(p);
                }
            }
        }

        // --------------------------------------------------------
        // Step B: Expand from reachable nodes
        // Reverse outgoing edges that go away from reachable set
        // --------------------------------------------------------

        int ans = 0;
        Queue<Integer> bfs = new LinkedList<>();

        // Start BFS from all nodes that can reach 0
        for (int i = 0; i < n; i++) {
            if (canReach0[i]) bfs.add(i);
        }

        while (!bfs.isEmpty()) {
            int u = bfs.poll();

            // original outgoing edges u -> v
            for (int v : out.get(u)) {
                if (!canReach0[v]) {
                    // this edge goes away from 0 direction ⇒ reverse needed
                    ans++;
                    canReach0[v] = true;
                    bfs.add(v);
                }
            }

            // also consider incoming edges (for full expansion)
            for (int p : in.get(u)) {
                if (!canReach0[p]) {
                    canReach0[p] = true;
                    bfs.add(p);
                }
            }
        }

        return ans;
    }
}
