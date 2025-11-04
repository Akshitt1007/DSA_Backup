package n_Binary_Tree;
import java.util.LinkedList;
import java.util.Queue;

//  993. Cousins in Binary Tree
//  https://leetcode.com/problems/cousins-in-binary-tree/description/

class Cousin_In_Binary_tree{

    public boolean isCousins(Node root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();

                // If both are on same level
                // They will be become true
                if (temp.val == x) {
                    foundX = true;
                }
                if (temp.val == y){
                    foundY = true;
                }

                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }

            //  This won't work
            // because the contain method does not compare with int value

//                 if( q.contains(x) && q.contains(y) ){
//                     check = siblingCheck(root, x, y);
//                     break;
//                 }

            // if both values found at this level
            if (foundX && foundY) {

                // To check if siblings or not
                if (!siblingCheck(root, x, y)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean siblingCheck(Node node, int x, int y) {

        if (node == null) {
            return false;
        }

        if (node.left != null && node.right != null) {
            if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                return true;
                // If this is returned as True.
                // we will know it's a sibling
                // therefore we will return false in main method
            }
        }

        return siblingCheck(node.left, x, y) || siblingCheck(node.right, x, y);
    }

    private Node rootNode;
    public class Node{
        private int val;
        private Node left;
        private Node right;
        private int height;

        public Node( int value ){
            this.val = value;
        }

        public int getValue(){
            return val;
        }
    }
}

public class x5_Cousins_in_Binary_Tree {
    public static void main(String[] args) {

    }
}
