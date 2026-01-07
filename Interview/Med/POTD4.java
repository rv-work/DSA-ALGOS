class Solution {

    int MOD = 1000000007;
    long totalSum = 0;
    long ans = 0;

    void getSum(TreeNode root){
        if(root == null) return;
        getSum(root.left);
        totalSum += root.val;
        getSum(root.right);
    }

    long DFS(TreeNode root){
        if(root == null) return 0;

        long sum = root.val;
        sum += DFS(root.left);
        sum += DFS(root.right);

        ans = Math.max(ans, sum * (totalSum - sum));
        return sum;
    }

    public int maxProduct(TreeNode root) {
        getSum(root);
        DFS(root);
        return (int)(ans % MOD);
    }
}
