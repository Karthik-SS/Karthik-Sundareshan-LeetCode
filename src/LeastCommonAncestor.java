public class LeastCommonAncestor {
    private static TreeNode LCA(TreeNode root, int p, int q) {
        if(root == null) {
            return null;
        }
/*
                       3
                    /     \
                   5        1
                 /   \     /  \
                6     2   0    8
                     /  \
                    7    4
*/

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if(root.val == p || root.val == q || (left != null && right != null)) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        int p = 8, q = 6;
        TreeNode lca = LCA(root, p, q);
        System.out.println("LCA = " +lca.val);
    }
}
