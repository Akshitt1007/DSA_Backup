package n_Binary_Tree;

//104. Maximum Depth of Binary Tree
//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

// This is the type of Post order Traversal
// 1. first we will calculate the height of both the children
// 2. then move toward the parent node to chck which is greater and again doing the same till we reach root node

class Maximum_Depth_of_BT{

    public int maxDepth(TreeNode root) {
        return getHeight( root );
    }

    public int getHeight( TreeNode root ){

        if( root == null ){
            return 0;
        }

        int leftHeight = getHeight( root.left );
        int rightHeight = getHeight( root.right );

        int greater = Math.max( leftHeight, rightHeight ) + 1;

        return greater ;
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


public class y2_Maximum_Depth_of_BT {
    public static void main(String[] args) {

    }
}
