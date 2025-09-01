// [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)


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
     int ans  = 0;
     
     int getAns(TreeNode node  ){  
        if(node == null) return 0;
        int left  = getAns(node.left);
        int right  = getAns(node.right );
        ans = Math.max(left + right , ans);
        return Math.max(left , right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getAns(root );
       return ans;
    }
}