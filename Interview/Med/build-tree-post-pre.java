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

    int preIdx = 0;

    private TreeNode build(
        int[] preorder,
        int[] postorder,
        int postStart,
        int postEnd
    ) {
        if (preIdx >= preorder.length || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);

        // leaf node
        if (postStart == postEnd)
            return root;

        // next preorder element = left child
        int leftRootVal = preorder[preIdx];

        // find left root in postorder (O(n))
        int idx = postStart;
        while (postorder[idx] != leftRootVal) idx++;

        // build left & right
        root.left = build(preorder, postorder, postStart, idx);
        root.right = build(preorder, postorder, idx + 1, postEnd - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, postorder.length - 1);
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
 */
class Solution {

    int preIdx = 0;
    HashMap<Integer, Integer> postMap = new HashMap<>();

    private TreeNode build(
        int[] preorder,
        int[] postorder,
        int postStart,
        int postEnd
    ) {
        if (preIdx >= preorder.length || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);

        if (postStart == postEnd)
            return root;

        int leftRootVal = preorder[preIdx];
        int idx = postMap.get(leftRootVal);

        root.left = build(preorder, postorder, postStart, idx);
        root.right = build(preorder, postorder, idx + 1, postEnd - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }

        return build(preorder, postorder, 0, postorder.length - 1);
    }
}
