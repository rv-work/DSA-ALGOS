public class Codec {

    // Encodes a tree to single string.
    public String serialize(TreeNode root) {

        if(root == null) return "";

        List<String> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null){
                res.add("null");
                continue;
            }

            res.add(String.valueOf(node.val));
            q.add(node.left);
            q.add(node.right);
        }

        // remove trailing nulls
        int i = res.size() - 1;
        while(i >= 0 && res.get(i).equals("null")) i--;

        return res.subList(0, i+1).toString();
    }


    // Decodes string to tree.
    public TreeNode deserialize(String data) {

        if(data == null || data.length() == 0) return null;

        // Remove [ and ]
        data = data.substring(1, data.length()-1);

        // Split by comma
        String[] arr = data.split(",");

        // Root
        TreeNode root = new TreeNode(Integer.parseInt(arr[0].trim()));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while(!q.isEmpty() && i < arr.length){

            TreeNode parent = q.poll();

            // left child
            if(!arr[i].trim().equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i].trim()));
                parent.left = left;
                q.add(left);
            }
            i++;

            if(i >= arr.length) break;

            // right child
            if(!arr[i].trim().equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i].trim()));
                parent.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
    }
}
