package n_Binary_Tree;

//116. Populating Next Right Pointers in Each Node
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

import java.util.LinkedList;
import java.util.Queue;

class Populate_next_right_pointer{

    public Node connect(Node root) {

        if ( root == null ){
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer( root );

        while( !q.isEmpty() ){

            int size = q.size();

            Node prev = null;

            for( int i=0 ; i < size ; i++ ){

                Node temp = q.poll();

                if( prev != null ){
                    prev.next = temp;
                }
                prev = temp;

                if( temp.left != null ){
                    q.offer( temp.left );
                }

                if( temp.right != null ){
                    q.offer( temp.right );
                }

                prev.next = null;
            }
        }
        return root;
    }

    private Node rootNode;
    public class Node{
        private int value;
        private Node left;
        private Node right;
        private Node next;
        private int height;

        public Node( int value ){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }
}

public class x3_Populate_next_right_pointer {
    public static void main(String[] args) {

    }
}
