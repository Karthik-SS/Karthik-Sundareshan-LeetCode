import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeMode {
    public static int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        int maxFreq = 0;

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

    public static void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            dfs(node.left, map);
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        if (node.right != null) {
            dfs(node.right, map);
        }

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
