package n_Binary_Tree;

//105. Construct Binary Tree from Preorder and Inorder Traversal
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.Arrays;

class Construct_Tree_from_Preorder_n_Inorder{

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if( preorder.length == 0 ){
            return null;
        }

        int r = preorder[0];
        int index = 0;

        for( int i=0 ; i<inorder.length; i++ ){
            if( inorder[i] == r) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(r);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index+1) );
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length) );

        return root;
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

public class y7_Construct_Tree_from_Preorder_n_Inorder {
}
