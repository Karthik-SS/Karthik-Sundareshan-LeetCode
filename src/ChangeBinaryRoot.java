
import java.util.LinkedList;
import java.util.Queue;

public class ChangeBinaryRoot {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public void PrintInOrder(TreeNode outPut){
        if(outPut == null){
            return;
        }
        PrintInOrder(outPut.left);
        System.out.print(outPut.val+", ");
        PrintInOrder(outPut.right);
    }
    public  TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = increasingBST(root.left);
        queue.offer(root);
        TreeNode right = increasingBST(root.right);

        return root;
    }

    public void printQueue(Queue<TreeNode> queue){
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+", ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.right.right.right = new TreeNode(9);

        ChangeBinaryRoot obj = new ChangeBinaryRoot();
        TreeNode outPut = obj.increasingBST(root);
        obj.printQueue(obj.queue);
        System.out.println();
        System.out.print("++++++++++++++++++++++++++");
        System.out.println();
        obj.PrintInOrder(outPut);
    }
}