/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public int maxLevelSum(TreeNode root) {
    int ans = 1;
    int level = 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    long maxSum = Integer.MIN_VALUE;
    while (!q.isEmpty()) {
      level++;
      int size = q.size();
      long sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        sum += node.val;
        if (node.left != null)
          q.add(node.left);
        if (node.right != null)
          q.add(node.right);
      }

      if (sum > maxSum) {
        maxSum = sum;
        ans = level;
      }
    }

    return ans;
  }
}














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
 */class Solution {

    void dfs(TreeNode node, int level, List<Long> sum) {
        if (node == null) return;

        if (level == sum.size()) {
            sum.add((long) node.val);
        } else {
            sum.set(level, sum.get(level) + node.val);
        }

        dfs(node.left, level + 1, sum);
        dfs(node.right, level + 1, sum);
    }

    public int maxLevelSum(TreeNode root) {
        List<Long> sum = new ArrayList<>();

        dfs(root, 0, sum);

        long maxSum = Long.MIN_VALUE;
        int ans = 1;

        for (int i = 0; i < sum.size(); i++) {
            if (sum.get(i) > maxSum) {
                maxSum = sum.get(i);
                ans = i + 1; // 1-based level
            }
        }

        return ans;
    }
}
