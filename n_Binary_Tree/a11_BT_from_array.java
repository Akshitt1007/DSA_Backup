package n_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class a11_BT_from_array {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    class BinaryTree {

        public static Node buildTree(int[] arr) {

            if (arr.length == 0)
                return null;

            Node root = new Node(arr[0]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            int i = 1;

            while (!queue.isEmpty() && i < arr.length) {

                Node current = queue.poll();

                // left child
                if (i < arr.length) {
                    current.left = new Node(arr[i]);
                    queue.add(current.left);
                    i++;
                }

                // right child
                if (i < arr.length) {
                    current.right = new Node(arr[i]);
                    queue.add(current.right);
                    i++;
                }
            }

            return root;
        }
    }

}
