public class BinaryTreeBalancedOptimized {
    final static class TreeInfo {
        public final int height;
        public final boolean balanced;
        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }
    // Return whether the tree at root is balanced while also storing
    // the tree's height in a reference variable.
    private static TreeInfo isBalancedTreeHelper(TreeNode root) {
        // An empty tree is balanced and has height = -1
        if (root == null) {
            return new TreeInfo(-1, true);
        }
        // Check subtrees to see if they are balanced.
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }
        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced.
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

/*
                       5
                    /      \
                  10       15
                /   \     /  \
               20   25   30  35
                      \
                       45
*/
    public static TreeInfo isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root);
    }
    public static void main(String[] args) {
        // Binary Tree Formation
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.left.right.right = new TreeNode(45);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(35);
        TreeInfo answer = isBalanced(root);
        System.out.println("Is The Given Tree Balanced ? " +answer.balanced);
        System.out.println("The Height Of The Given Tree = " +answer.height);

    }
}
