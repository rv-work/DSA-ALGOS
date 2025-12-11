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

    int Depth(TreeNode root) {
        if(root == null) return 0;
        return 1 +  Math.max( Depth(root.left) , Depth(root.right) );
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

       int curr  = Depth(root.left) + Depth(root.right); // do not +1 . because we are calculating edges not nodes
       int left = diameterOfBinaryTree(root.left);
       int right = diameterOfBinaryTree(root.right);

       return left > right ? (left > curr ? left : curr) : (right > curr ? right : curr);
    }
}