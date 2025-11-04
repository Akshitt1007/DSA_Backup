package n_Binary_Tree;

//  100. Same Tree
//  https://leetcode.com/problems/same-tree/

class Same_Tree{

    public boolean isSameTree(Node p, Node q) {

        // both are null → same
        if( p == null && q == null ){
            return true;
        }

        // one is null, other isn’t → not same
        if( p == null || q == null ){
            return false;
        }

        // values differ → not same
        if ( p.val != q.val ){
            return false;
        }

        return isSameTree( p.left, q.left ) && isSameTree( p.right, q.right );
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

public class x6_Same_Tree {
    public static void main(String[] args) {

    }
}
