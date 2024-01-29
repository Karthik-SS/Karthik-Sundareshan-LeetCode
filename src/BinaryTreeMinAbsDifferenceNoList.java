public class BinaryTreeMinAbsDifferenceNoList {
    static int minDifference = Integer.MAX_VALUE;
    // Initially, it will be null.
    static TreeNode prevNode;

    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        // Find the difference with the previous value if it is there.
        if (prevNode != null) {
            minDifference = Math.min(minDifference, (node.val - prevNode.val));
        }
        prevNode = node;
        inorderTraversal(node.right);
    }

    public static int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDifference;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(6);
        //root.right.left = new TreeNode(12);
        //root.right.right = new TreeNode(49);

        int outPut = getMinimumDifference(root);
        System.out.println("OutPut = " + outPut);
    }
}
