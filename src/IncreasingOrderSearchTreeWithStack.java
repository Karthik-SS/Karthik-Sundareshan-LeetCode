import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IncreasingOrderSearchTreeWithStack {
    public static TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(-1);
        TreeNode target = result;
        List<Integer> tmpResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode top = stack.pop();

            result.right = new TreeNode(top.val);
            //result.left = null;
            result = result.right;

            root = top.right;
        }
        /*for (Integer i: tmpResult) {
        //    result.right = new TreeNode(i);
        //    result.left = null;
        //    result = result.right;
        }*/
        return target.right;
    }

    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + ", ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        //root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode answer = increasingBST(root);
        printInOrder(answer);


    }
}
