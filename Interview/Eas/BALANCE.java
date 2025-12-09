class Solution {

    int height(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftH = height(root.left);
        int rightH = height(root.right);

        if(Math.abs(leftH - rightH) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
