public class LeastCommonAncestor {
    private static TreeNode LCA(TreeNode root, int p, int q) {
        if(root == null) {
            return null;
        }

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

        int p = 7, q = 4;
        TreeNode lca = LCA(root, p, q);
    }
}
