public class BTreeDepthOfANode {
    /*
                   5
                  / \
                 3   6
                / \   \
               2   4   8
              /       / \
             1       7   9
   */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        //root.right.left = new TreeNode(12);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        int answer = findDepth(root, 1);
        System.out.println("Answer = " + answer);
    }

    static int findDepth(TreeNode root, int x) {
        // Base case
        if (root == null)
            return -1;
        // Initialize distance as -1
        int dist = -1;
        // Check if x is current node=
        if ((root.val == x) ||
                // Otherwise, check if x is
                // present in the left subtree
                (dist = findDepth(root.left, x)) >= 0 ||
                // Otherwise, check if x is
                // present in the right subtree
                (dist = findDepth(root.right, x)) >= 0) {
            return dist + 1;
        }
        // Return depth of the node
        return dist;
    }
}
