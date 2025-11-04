package n_Binary_Tree;

//  https://leetcode.com/problems/validate-binary-search-tree/submissions/1760555057/
//  98. Validate Binary Search Tree

class Validate_BinarySearchTree{

    public boolean isValidBST(TreeNode root) {
        return helper( root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
    public boolean helper( TreeNode root, long left, long right ){

        if ( root == null ){
            return true;
        }

        if ( root.value >= right ){
            return false;
        }

        if( root.value <= left ){
            return false;
        }

        boolean leftTree = helper( root.left, left, root.value );
        boolean rightTree = helper( root.right, root.value, right );

        return leftTree && rightTree;
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
public class y4_Validate_BST {
    public static void main(String[] args) {

    }
}
