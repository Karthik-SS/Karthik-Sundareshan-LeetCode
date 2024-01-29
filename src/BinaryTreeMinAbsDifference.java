public class BinaryTreeMinAbsDifference {
    static int minVal = Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }

      // minVal = Math.min(Math.min(Math.abs((root.val - getMinimumDifference(root.left))), Math.abs(root.val - getMinimumDifference(root.right))), minVal);
        minVal = Math.min(Math.min((root.val - getMinimumDifference(root.left)), (root.val - getMinimumDifference(root.right))), minVal);

        return minVal;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        //root.left.left = new TreeNode(1);
        //root.left.right = new TreeNode(3);

        root.right = new TreeNode(48);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);

        int outPut = getMinimumDifference(root);
        System.out.println("OutPut = " +outPut);
    }
}
