import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;

// A class to store a binary tree node
class Node {
    int key;
    Node left = null, right = null;

    Node(int data) {
        this.key = data;
    }
}

public class HeightOfABinaryTreeIterative {

    // Iterative function to calculate the height of a given binary tree
    // by doing level order traversal on the tree
    public static int height(Node root) {
        // empty tree has a height of 0
        if (root == null) {
            return 0;
        }
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node front = null;
        int height = 0;
        // loop till queue is empty
        while (!queue.isEmpty()) {
            // calculate the total number of nodes at the current level
            int size = queue.size();

            // process each node of the current level and enqueue their
            // non-empty left and right child
            while (size-- > 0) {
                front = queue.poll();
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
            // increment height by 1 for each level
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        System.out.println("The height of the binary tree is " + height(root));
    }
}