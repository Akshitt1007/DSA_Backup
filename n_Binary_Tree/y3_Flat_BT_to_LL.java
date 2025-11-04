package n_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

//  114. Flatten Binary Tree to Linked List
//  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Flat_BT_to_LL{

    // Way I:
    public void flatten(TreeNode root) {

        if ( root == null ){
            return;
        }

        flatten( root.left );
        flatten( root.right );
        /*
                when I will be out of this flatten(root.right);

                    1
                   / \
                  2   5
                 / \   \
                3   4   7

                I will be at root 2 (not at root 3)

                then I will store all the tree to the right of tree in temp
                and put the root 3 at the root.right.

                then tree would be like:

                    1                       temp =   \
                   / \                                4
                  2   5
                   \   \
                    3   7

                 since I am at root 2 but to connect this root 2 to temp
                 I have to reached to the end ie root 3 here
                 But there can be many nodes connected further to 3

                 Therefore, we will go to the end of root 2 tree
                 after reaching the end we will simply connect that to temp
         */
        TreeNode temp = root.right;

        root.right = root.left;
        root.left = null;

        TreeNode curr = root;

        // With this we would be at the last node
        while( curr.right != null ){
            curr = curr.right;
        }

        // Connecting
        curr.right = temp;

    }

    // Way II: just storing all the nodes in a queue using pre-order traversal
    public void flatten_Using_Queue(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        stored(q, root);

        while ( !q.isEmpty() ){
            TreeNode temp = q.poll();
            temp.right = q.peek();
            temp.left = null;
        }
    }
    public void stored( Queue<TreeNode> q, TreeNode root ){

        if( root == null ){
            return;
        }

        q.offer( root );
        stored( q, root.left );
        stored( q, root.right );
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
public class y3_Flat_BT_to_LL {
    public static void main(String[] args) {

    }
}
