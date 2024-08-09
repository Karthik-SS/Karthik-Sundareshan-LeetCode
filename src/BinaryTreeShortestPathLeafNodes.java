public class BinaryTreeShortestPathLeafNodes {
 /*
               1
              / \
             2   3
            / \
           5   4
*/
    public static int countPairs(TreeNode root, int distance) {
        return postOrder(root, distance)[11];
    }
    private static int[] postOrder(TreeNode currentNode, int distance) {
        if (currentNode == null) {
            return new int[12];
        }
        else if (currentNode.left == null && currentNode.right == null) {
            int[] current = new int[12];
            // Leaf node's distance from itself is 0
            current[0] = 1;
            return current;
        }

        // Leaf node count for a given distance i
        int[] left = postOrder(currentNode.left, distance);
        int[] right = postOrder(currentNode.right, distance);
        int[] current = new int[12];
 /*
               1
              / \
             2   3
            / \
           5   4
*/
        // Combine the counts from the left and right subtree and shift by
        // +1 distance
        for (int i = 0; i < 10; i++) {
            current[i + 1] += left[i] + right[i];
        }

        // Initialize to total number of good leaf nodes pairs from left and right subtrees.
        current[11] += left[11] + right[11];

        // Iterate through possible leaf node distance pairs
        for (int d1 = 0; d1 <= distance; d1++) {
            for (int d2 = 0; d2 <= distance; d2++) {
                if (2 + d1 + d2 <= distance) {
                    // If the total path distance is less than the given distance limit,
                    // then add to the total number of good pairs
                    current[11] += left[d1] * right[d2];
                }
            }
        }

        return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        //root.right.left = new TreeNode(9);
        //root.right.right = new TreeNode(10);

        int distance = 3;
        int numberOfShortestPaths = countPairs(root, distance);
        System.out.println("numberOfShortestPaths = " +numberOfShortestPaths);
    }
}
