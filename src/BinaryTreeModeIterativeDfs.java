
import java.util.*;

public class BinaryTreeModeIterativeDfs {
    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        int maxFreq = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }

        }

        for (int key : map.keySet()) {
            if (map.get(key) > maxFreq) {
                maxFreq = map.get(key);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                list.add(key);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

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
