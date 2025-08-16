// [Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

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
    
    boolean solve(TreeNode p , TreeNode q){
        if(p == null || q == null) return p == q;
        return p.val == q.val && solve(p.left , q.right) && solve(p.right , q.left);
    }


    public boolean isSymmetric(TreeNode root) {
        return solve(root.left , root.right);
    }
}