package n_Binary_Tree;


//  Q/ We are given a BT and an Array
//  We have to check how many paths does Bt contain that equals to given sum
/*
                3                   sum = 4
               / \
              5   9
                 / \
                10  12
               /    /
              16   8
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Path_Exist_from_AnyNode_to_AnyNode{

    public int demo(TreeNode root , int sum ){
        List<Integer> path = new LinkedList<>();
        return countPath( root, sum, path);
    }
    public int countPath( TreeNode root, int sum , List<Integer> path ){

        if( root == null ){
            return 0;
        }

        path.add( root.value );
        int count = 0;
        int currSum = 0;

        // To count the paths
        // ListIterator is an interface that allows you to iterate over elements of a List in both directions
        ListIterator<Integer> itr = path.listIterator();
        while ( itr.hasPrevious() ){        // Iterator from back

            currSum = currSum + itr.previous();

            if( currSum == sum ){
                count++;
            }
        }

        count = count + countPath( root.left, sum, path ) + countPath( root.right, sum, path );

        // backtrack to remove the previous stored paths
        path.remove( path.size() - 1 );

        return count;
    }

    private TreeNode rootNode;
    public class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
        private int height;

        public TreeNode( int value ){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }
}

public class z5_Path_Exist_from_AnyNode_to_AnyNode {
    public static void main(String[] args) {

    }
}
