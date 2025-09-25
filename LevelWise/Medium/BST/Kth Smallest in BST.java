[Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)


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
    public int kthSmallest(TreeNode root, int k) {
        int i=0;
        TreeNode curr=root;
        while(curr!=null){
          if(curr.left==null){
            i++;
            if(i==k)
              return curr.val;
            curr=curr.right;
          }
          else{
            TreeNode pre=find(curr);
            if(pre.right==null){
              pre.right=curr;
              curr=curr.left;
            }
            else{
              pre.right=null;
              i++;
              if(i==k)
                return curr.val;
              curr=curr.right;
            }
          }
        }
        return -1;

    }
    public TreeNode find(TreeNode root){
      TreeNode curr=root.left;
      while(curr.right!=null && curr.right!=root)
         curr=curr.right;
        return curr;
    }
}