package n_Binary_Tree;

import java.util.*;

class Right{

//  Level Order successor to a node
//  we have to return the node just right to the nude given

    public int nextSuccessor(Node root, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty
        if( root == null ){
            return -1;
        }

        Queue<Node> q = new LinkedList<>();

        q.add( root );

        while ( !q.isEmpty() ){

            ArrayList currentLevel = new ArrayList<>();

            Node currNode = q.poll();

            // If we found the target, the next node in the queue is its successor
            if (currNode.value == target) {
                if (q.peek() != null) {
                    return q.peek().value;
                }
                else {
                    return -1;
                }
            }

            currentLevel.add( currNode.value );

            if ( currNode.left != null ){
                q.offer( currNode.left );
            }
            if ( currNode.right != null ){
                q.offer( currNode.right );
            }

            result.add( currentLevel );
        }
        return -1;
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

public class x1_nextSuccessor {
    public static void main(String[] args) {
        Right tree = new Right();

    }
}
