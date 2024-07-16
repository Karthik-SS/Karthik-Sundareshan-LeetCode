import java.util.ArrayList;
import java.util.List;

/*
                 1
                / \
               0  48
                 /  \
                12  49
 */

public class BinaryTreeMinAbsDifferenceInOrder {
    static List<Integer> list = new ArrayList<>();

    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public static int getMinimumDifference(TreeNode root){
        inOrder(root);
        int minDifference = Integer.MAX_VALUE;

        for(int i = 1; i < list.size(); i++){
            minDifference = Math.min(minDifference, Math.abs(list.get(i) - list.get(i - 1)));
        }
         return minDifference;
    }
/*
                 1
                / \
               0  48
                 /  \
                12  49
 */

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
