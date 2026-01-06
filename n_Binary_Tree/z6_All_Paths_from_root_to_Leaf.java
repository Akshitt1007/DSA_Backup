package n_Binary_Tree;

import java.util.ArrayList;

public class z6_All_Paths_from_root_to_Leaf {

    class Node{
        int data; // data used as key value
        Node left;
        Node right;
        public Node()
        {
            data=0;
        }
        public Node(int d)
        {
            data=d;
        }
    }

    static public int totalNum = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> totalPath = new ArrayList<>();

    static void printAllPaths(Node root) {

        if (root == null) {
            return;
        }

        x(root);

        // print paths
        for (int i = 0; i < totalPath.size(); i++) {
            for (int j = 0; j < totalPath.get(i).size(); j++) {
                System.out.print(totalPath.get(i).get(j) + " ");
            }
            System.out.print( totalPath.get(i).size()-1 );
            System.out.println();
        }
        System.out.print(totalNum);
    }

    static void x ( Node root ){

        if( root == null ){
            return;
        }

        list.add( root.data );

        if( root.left == null && root.right == null ){
            totalNum ++;
            totalPath.add( new ArrayList<>(list) );
        }

        x( root.left );
        x( root.right );

        list.remove( list.size() - 1 );
    }
}
