package n_Binary_Tree;

//103. Binary Tree Zigzag Level Order Traversal
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

//import javax.swing.tree.TreeNode;
import java.util.*;

class BT_Zigzag_Level_Order_Traversal{

    // Using Reverse Method
    public List<List<Integer>> zigzagLevelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if( root == null ){
            return result;
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        int order = 0;

        while( !q.isEmpty() ){

            List<Integer> currLevel = new ArrayList<>();
            int size = q.size();

            for( int i=0 ; i<size ; i++ ){

                Node currNode = q.poll();
                currLevel.add( currNode.value );

                if( currNode.left != null ){
                    q.offer( currNode.left );
                }

                if( currNode.right != null ){
                    q.offer( currNode.right );
                }

            }

            // Because the node at odd level would always be connected in opposite direction
            if( order % 2 != 0 ){
                Collections.reverse(currLevel);
            }

            result.add( currLevel );
            order++;
        }
        return result;
    }

    // Using Deque Method
    public List<List<Integer>> zigzagLevelOrder_using_Deque(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<Node> dq = new LinkedList<>();

        dq.offer(root);
        boolean leftToRight = true; // track direction

        while ( !dq.isEmpty() ){

            int size = dq.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                if (leftToRight) {
                    // Process from front
                    Node node = dq.pollFirst();
                    currLevel.add(node.value);

                    // Normal order: left → right
                    if (node.left != null) {
                        dq.offerLast(node.left);
                    }
                    if (node.right != null) {
                        dq.offerLast(node.right);
                    }
                }
                else {
                    // Process from back
                    Node node = dq.pollLast();
                    currLevel.add(node.value);

                    // Reverse order: right → left (added to front!)
                    if (node.right != null) {
                        dq.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.offerFirst(node.left);
                    }
                }
            }

            result.add(currLevel);
            leftToRight = !leftToRight; // flip direction
        }

        return result;
    }

    private Node rootNode;
    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node( int value ){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }
}

public class x2_BT_Zigzag_Level_Order_Traversal {
    public static void main(String[] args) {

    }
}
