import java.util.ArrayList;
import java.util.List;

public class BinaryTreeModeWithNoMapWithVariables {
    public static int[] findMode(TreeNode root) {
        List<Integer> values = new ArrayList();
        dfs(root, values);

        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList();

        for (int num : values) {
            if (num == currNum) {
                currStreak++;
            } else {
                currStreak = 1;
                currNum = num;
            }

            if (currStreak > maxStreak) {
                ans = new ArrayList();
                maxStreak = currStreak;
            }

            if (currStreak == maxStreak) {
                ans.add(num);
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static void dfs(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        // Inorder traversal visits nodes in sorted order
        dfs(node.left, values);
        values.add(node.val);
        dfs(node.right, values);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);

        int[] outPut = findMode(root);
        for (int i = 0; i < outPut.length; i++) {
            if ((i + 1) == outPut.length) {
                System.out.print(outPut[i]);
            } else {
                System.out.print(outPut[i] + ", ");
            }

        }
    }
}
