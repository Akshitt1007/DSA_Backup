package n_Binary_Tree;


import java.util.LinkedList;
import java.util.Queue;

class Lowest_Common_Ancestor_of_BT{

    // Way I:
    /*
        Suppose we have given tree :

                3
               / \
              5   1
             / \   \
            7   2   8
               / \
              9   4

        - and we have to find the lowest common ancestor  for node 5, 4
        - First we will go in left part
        - and if we find any of the node like 5 here
        - we will return 5
        - Then we will go in the left part
        - If we get our another node there then we will return the root node which is common to both
        - But here our another node is node 4 which lies below the node 5 which we have earlier visited, and we can't gp below more
        - when our right side = null, meaning our another node will only be available under the left side
        - Therefore we will automatically return the node 5 which we got earlier as the common ancestor
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        // If the current node is either p or q, return it
        if (root == p || root == q) {
            return root;
        }

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both sides return non-null, current root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return whichever side is non-null
        if (left != null) {
            return left;
        }
        return right;   // covers both (right != null) and (both null)
    }

    // Way II:
    // 1. first find all the possible ways for both the node
    // 2. then comparing both the queue and returning the node that matches at the end
    // 3. because the end would be the lowest connection

    public TreeNode lowestCommonAncestor_II(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode common = null;

        Queue<TreeNode> n1 = path(root, p, new LinkedList<>());
        Queue<TreeNode> n2 = path(root, q, new LinkedList<>());

        while( !n1.isEmpty() && !n2.isEmpty() ){
            TreeNode x = n1.poll();
            TreeNode y = n2.poll();
            if( x == y ){
                common = x;
            }
        }

        return common;
    }
    public Queue<TreeNode> path( TreeNode root, TreeNode x, Queue q ){

        if( root == null ){
            return null;
        }

        q.offer( root );
        if ( root == x ){
            return new LinkedList<>(q);
        }

        Queue<TreeNode> leftPath = path(root.left, x, q);
        if (leftPath != null) return leftPath;

        Queue<TreeNode> rightPath = path(root.right, x, q);
        if (rightPath != null) return rightPath;

        q.remove(root);

        return null;
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

public class y5_Lowest_Common_Ancestor_of_BT {
    public static void main(String[] args) {

    }
}
