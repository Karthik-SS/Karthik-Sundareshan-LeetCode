public class BinaryTreeBalancedOptimized2 {
    static int minVal = Integer.MIN_VALUE;
    /*
                           5
                        /      \
                      10       15
                    /   \     /  \
                   20   25   30  35
                          \
                           45

                          5                          5
                        /   \
                      10    15
                     /
                    7
                   /
                  3
    */
    private static int checkHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == minVal) {
            return minVal;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == minVal) {
            return minVal;
        }
        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1) {
            return minVal;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private static boolean isBalanced(TreeNode root) {
        int output = checkHeight(root);
        System.out.println("checkHeight Value = "+output);
        return output != minVal;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(3);
        root.right = new TreeNode(15);
        /*root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.left.right.right = new TreeNode(45);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);*/

        boolean output = isBalanced(root);
        System.out.println("Output = "+output);
    }
}
