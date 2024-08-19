import java.util.ArrayList;
import java.util.List;

public class LeavesOfABinaryTree {

    private List<List<Integer>> solution;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        //root.right.left = new TreeNode(12);
        //root.right.right = new TreeNode(49);

        LeavesOfABinaryTree tree = new LeavesOfABinaryTree();
        List<List<Integer>> answer = tree.findLeaves(root);

        for (int j = 0; j < answer.size(); j++) {
            System.out.print(answer.get(j));
        }

    }

    private int getHeight(TreeNode root) {

        // return -1 for null nodes
        if (root == null) {
            return -1;
        }

        // first calculate the height of the left and right children
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
 /*
 *                    5
 *                  /   \
 *                 2     7
 *               /  \
 *              1    3
 *
 * */
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        /*if (this.solution.size() == currHeight && currHeight == 0) {
            this.solution.add(new ArrayList<>());
        }*/
        if (this.solution.size() == currHeight){
            this.solution.add(new ArrayList<>());
        }

        this.solution.get(currHeight).add(root.val);

        /*if(currHeight == 0){
            this.solution.get(currHeight).add(root.val);
        }*/

        return currHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.solution = new ArrayList<>();

        getHeight(root);

        return this.solution;
    }
}
