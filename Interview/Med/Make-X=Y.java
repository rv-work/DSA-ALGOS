class Solution {
  public int minimumOperationsToMakeEqual(int x, int y) {

    if (x <= y)
      return y - x;

    int limit = Math.max(x, y) * 2;

    Queue<Integer> q = new LinkedList<>();
    boolean[] vis = new boolean[limit + 1];

    q.add(x);
    vis[x] = true;

    int steps = 0;

    while (!q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        int node = q.poll();

        if (node == y)
          return steps;

        if (node % 11 == 0) {
          int nxt = node / 11;
          if (nxt >= 0 && !vis[nxt]) {
            vis[nxt] = true;
            q.add(nxt);
          }
        }

        if (node % 5 == 0) {
          int nxt = node / 5;
          if (nxt >= 0 && !vis[nxt]) {
            vis[nxt] = true;
            q.add(nxt);
          }
        }

        if (node + 1 <= limit && !vis[node + 1]) {
          vis[node + 1] = true;
          q.add(node + 1);
        }

        if (node - 1 >= 0 && !vis[node - 1]) {
          vis[node - 1] = true;
          q.add(node - 1);
        }
      }

      steps++;
    }

    return -1;
  }
}
