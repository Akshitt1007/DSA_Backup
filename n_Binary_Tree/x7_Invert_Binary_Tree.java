package n_Binary_Tree;

//  226. Invert Binary Tree
//  https://leetcode.com/problems/invert-binary-tree/


// 1. This is a type of Pre order Traversal
// 2. Visit the node (do some work)
// 3. Traverse the left subtree
// 4. Traverse the right subtree

class Invert_BT{

    public TreeNode invertTree(TreeNode root) {

        if( root == null ){
            return root;
        }

        if( root.left != null && root.right != null ){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        // for cases like:          2
        //                         /  \
        //                        3    4

        else if ( root.right == null ){
            TreeNode temp = null;
            root.right = root.left;
            root.left = temp;
        }
        // for cases like:          2
        //                         /  \
        //                        3   null

        else if ( root.left == null ){
            TreeNode temp = null;
            root.left = root.right;
            root.right = temp;
        }
        // for cases like:          2
        //                         /  \
        //                      null   3

        invertTree( root.left ) ;
        invertTree( root.right );

        return root;
    }

    public TreeNode invertTree_Short(TreeNode root) {

        if ( root == null ){
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree( root.left );
        invertTree( root.right );

        return root;
    }

    private TreeNode rootNode;
    public class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        private int height;

        public TreeNode( int value ){
            this.val = value;
        }

        public int getValue(){
            return val;
        }
    }
}

public class x7_Invert_Binary_Tree {
    public static void main(String[] args) {

    }
}
