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

    int preIdx = 0;

    private TreeNode build( int[] preorder, int[] inorder, int inStart, int inEnd ) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int idx = inStart;
        while (inorder[idx] != rootVal) idx++;

        root.left  = build(preorder, inorder, inStart, idx - 1);
        root.right = build(preorder, inorder, idx + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }
}






