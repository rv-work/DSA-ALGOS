/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair {
        TreeNode node;
        int hd, lvl;
        Pair(TreeNode node, int hd, int lvl) {
            this.node = node;
            this.hd = hd;
            this.lvl = lvl;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // hd -> level -> sorted values
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            mp
                .computeIfAbsent(p.hd, x -> new TreeMap<>())
                .computeIfAbsent(p.lvl, x -> new PriorityQueue<>())
                .add(p.node.val);

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1, p.lvl + 1));

            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1, p.lvl + 1));
        }

        List<List<Integer>> res = new ArrayList<>();

        for (Map<Integer, PriorityQueue<Integer>> levels : mp.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) {
                    col.add(pq.poll());
                }
            }
            res.add(col);
        }

        return res;
    }
}
