package n_Binary_Tree;


//https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
//https://www.geeksforgeeks.org/problems/floor-in-bst/1

import java.util.ArrayList;

public class y9_Floor_and_ceil_of_key_in_BST {

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


    static ArrayList<Integer> lst = new ArrayList<>();


    static int floorOf(Node root, int key) {

        lst.clear();
        order(root);

        int floor = -1;

        for( int i=0; i<lst.size(); i++ ){
            if( lst.get(i) <= key ){
                floor = lst.get(i);
            }
        }
        return floor;
    }

    static int ceilOf(Node root, int key) {

        lst.clear();
        order(root);

        int ceiling = -1;
        for( int i=lst.size()-1; i>= 0 ; i-- ){
            if( lst.get(i) >= key ){
                ceiling = lst.get(i);
            }
        }
        return ceiling;
    }

    static void order( Node root ){

        if( root == null ){
            return;
        }

        order( root.leftChild );
        lst.add( root.data);
        order( root.rightChild );
    }
}
