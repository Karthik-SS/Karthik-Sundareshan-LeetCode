public class BTreeNodeHeightOfANode {
    static int height = -1;
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

        int answer = findHeight(root, 5);
        System.out.println("Answer = " + answer);
    }
    static int findHeightUtil(TreeNode root, int x) {
        // Base Case
        if (root == null) {
            return -1;
        }
   /*
                5
               / \
              3   6
             / \   \
            2   4   8
           /       / \
          1       7   9
   */
        // Store the maximum height of
        // the left and right subtree
        int leftHeight = findHeightUtil(root.left, x);
        int rightHeight = findHeightUtil(root.right, x);
        // Update height of the current node
        int ans = Math.max(leftHeight, rightHeight) + 1;
        // If current node is the required node
        if (root.val == x) {
            height = ans;
        }
        return ans;
    }
    static int findHeight(TreeNode root, int x)
    {
        // Stores height of the Tree
        findHeightUtil(root, x);
        // Return the height
        return height;
    }
}
