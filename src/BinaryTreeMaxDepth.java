public class BinaryTreeMaxDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);


        //root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        //[5, 3, 6, 2, 4, null, 8, 1, null, 7, 9]
        int answer = maxDepth(root);
        System.out.println("Answer = " +answer);

    }
    /*public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }*/
    /*
                   5
                  / \
                 3   6
                / \   \
               2   4   8
              /       / \
             1       7   9
   */
    public static int maxDepth(TreeNode root) {
        int depth = 1;
        if(root == null){
           return depth--;
        }
        while(root != null){
            if(root.left != null){
                root = root.left;
                depth++;
            }else {
                root = null;
            }
        }
        return depth;
    }
}

