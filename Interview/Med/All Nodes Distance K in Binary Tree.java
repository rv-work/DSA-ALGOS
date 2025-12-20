class Solution {

    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        
        buildParent(root);

        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        Set<TreeNode> vis = new HashSet<>();

        vis.add(target);

        int dist = 0;

        while(!q.isEmpty()){

            int size = q.size();

            
            if(dist == k){
                while(!q.isEmpty()){
                    ans.add(q.poll().val);
                }
                return ans;
            }

            
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();

                // left
                if(cur.left != null && !vis.contains(cur.left)){
                    vis.add(cur.left);
                    q.add(cur.left);
                }

                // right
                if(cur.right != null && !vis.contains(cur.right)){
                    vis.add(cur.right);
                    q.add(cur.right);
                }

                // parent
                if(parent.containsKey(cur) && !vis.contains(parent.get(cur))){
                    vis.add(parent.get(cur));
                    q.add(parent.get(cur));
                }
            }

            dist++;
        }

        return ans;
    }



    void buildParent(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left != null){
                parent.put(node.left, node);
                q.add(node.left);
            }

            if(node.right != null){
                parent.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}
