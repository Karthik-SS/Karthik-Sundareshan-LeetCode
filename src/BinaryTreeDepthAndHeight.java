import java.util.*;

public class BinaryTreeDepthAndHeight {
    // Java program for the above approach
    static int height = -1;
    // Initialize distance as -1
    static int dist = -1;
    // Function to find the depth of
// a given node in a Binary Tree
    static int findDepth(TreeNode root, int x) {
        // Base case
        if (root == null)
            return -1;
        //int dist = -1;
        // Check if x is current node=
       if ((root.val == x) ||
                // Otherwise, check if x is
                // present in the left subtree
                (dist = findDepth(root.left, x)) >= 0 ||
                // Otherwise, check if x is
                // present in the right subtree
                (dist = findDepth(root.right, x)) >= 0){
           return dist + 1;
       }
            // Return depth of the node
       return dist;
       }
    /*
                5
             /      \
           10       15
         /   \     /   \
        20   25  30   35
               \
               45
     */

    // Helper function to find the height
// of a given node in the binary tree
    static int findHeightUtil(TreeNode root, int x) {
        // Base Case
        if (root == null) {
            return -1;
        }
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
    // Function to find the height of
// a given node in a Binary Tree
    static int findHeight(TreeNode root, int x) {
        // Stores height of the Tree
        findHeightUtil(root, x);
        // Return the height
        return height;
    }
    // Driver Code
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

        int k = 45;

        // Function call to find the
        // depth of a given node
        System.out.println("Depth Of Node " +k +" = " + findDepth(root, k));

        // Function call to find the
        // height of a given node
        System.out.println("Height Of Node " +k +" = " + findHeight(root, k));
    }

}
