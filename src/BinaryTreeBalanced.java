public class BinaryTreeBalanced {
        // Recursively obtain the height of a tree. An empty tree has -1 height
        private static int height(TreeNode root) {
            // An empty tree has height -1
            if (root == null) {
                return -1;
            }
            return 1 + Math.max(height(root.left), height(root.right));
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
        public static boolean isBalanced(TreeNode root) {
            // An empty tree satisfies the definition of a balanced tree
            if (root == null) {
                return true;
            }
            // Check if subtrees have height within 1. If they do, check if the
            // subtrees are balanced
            return (
                    Math.abs(height(root.left) - height(root.right)) < 2 &&
                            isBalanced(root.left) &&
                            isBalanced(root.right)
            );
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

        boolean answer = isBalanced(root);
        System.out.println("Is The Given Tree Balanced? " +answer );

    }
}
