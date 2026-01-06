package n_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//https://www.geeksforgeeks.org/dsa/print-cousins-of-a-given-node-in-binary-tree/
//Print cousins of a given node in Binary Tree

public class x10_Print_Cousins_of_node {
    class Node {
        int data; // data used as key value
        Node leftChild;
        Node rightChild;
        public Node()
        {
            data=0;
        }
        public Node(int d)
        {
            data=d;
        }
    }

    static void printCousins(Node root, int key ){

        if( root == null ){
            System.out.print( -1 );
            return ;
        }

        Queue<Node> q = new LinkedList<>();
        q.add( root );

        boolean parent = false;

        while( !q.isEmpty() ){

            int size = q.size();

            ArrayList<Integer> lst = new ArrayList<>();

            for( int i=0; i<size; i++ ){

                Node curr = q.poll();

                if( (curr.leftChild != null && curr.leftChild.data == key) || (curr.rightChild != null && curr.rightChild.data == key)){
                    parent = true;
                }
                else{
                    if( curr.leftChild != null ){
                        lst.add( curr.leftChild.data );
                    }
                    if( curr.rightChild != null ){
                        lst.add( curr.rightChild.data );
                    }
                }

                if( curr.leftChild != null ){
                    q.add( curr.leftChild );
                }
                if( curr.rightChild != null ){
                    q.add( curr.rightChild );
                }
            }

            if( parent ){
                if( lst.size() == 0 ){
                    System.out.print( -1 );
                }
                else{
                    for( int i=0; i<lst.size(); i++ ){
                        System.out.print( lst.get(i) + " " );
                    }
                }
                return;
            }
        }
        System.out.print( -1 );
    }
}
