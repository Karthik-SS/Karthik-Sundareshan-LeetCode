import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeHeightUsingQueueIterative {
    public static int maxHeight(TreeNode root) {
        List<List> l1 = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int a = queue.size();
             System.out.println("Queue Size = " +queue.size());
             System.out.println("a = " +a);
            List l2 = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                TreeNode cur = queue.poll();
                    l2.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (!l2.isEmpty())
                l1.add(l2);
        }
        return l1.size() - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

       /* root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        //root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.right = new TreeNode(10);*/

        int answer = maxHeight(root);
        System.out.println("Answer = " + answer);
    }
}
