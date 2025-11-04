package n_Binary_Tree;


//101. Symmetric Tree
//https://leetcode.com/problems/symmetric-tree/description/

import java.util.LinkedList;
import java.util.Queue;

class Symmetric_Tree{

    public boolean isSymmetric_I(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer( root.left );
        q.offer( root.right );

        while( !q.isEmpty() ){

            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if( left == null && right == null ){
                continue;
            }

            if( left == null || right == null ){
                return false;
            }

            if( left.value != right.value ){
                return false;
            }

            q.offer( left.left );
            q.offer( right.right );
            q.offer( left.right );
            q.offer( right.left );
        }
        return true;
    }


    // Invert + Same combo
    // first make new tree, invert it and check if they are same
    public boolean isSymmetric_II(TreeNode root) {

        if( root == null ){
            return true;
        }

        // clone original tree
        TreeNode newTree = cloneTree(root);

        // invert the clone
        newTree = invertTree(newTree);

        // compare original vs inverted clone
        return isSameTree(root, newTree);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // both are null → same
        if( p == null && q == null ){
            return true;
        }

        // one is null, other isn’t → not same
        if( p == null || q == null ){
            return false;
        }

        // values differ → not same
        if ( p.value != q.value ){
            return false;
        }

        return isSameTree( p.left, q.left ) && isSameTree( p.right, q.right );
    }
    private TreeNode invertTree( TreeNode root ){

        if( root == null ){
            return root;
        }

        if( root.left != null && root.right != null ){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        else if ( root.right == null ){
            TreeNode temp = null;
            root.right = root.left;
            root.left = temp;
        }

        else if ( root.left == null ){
            TreeNode temp = null;
            root.left = root.right;
            root.right = temp;
        }

        invertTree( root.left ) ;
        invertTree( root.right );

        return root;
    }
    private TreeNode cloneTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode newNode = new TreeNode(root.value);

        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);

        return newNode;
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

public class x8_Symmetric_Tree {
    public static void main(String[] args) {

    }
}
