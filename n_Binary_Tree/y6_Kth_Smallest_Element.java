package n_Binary_Tree;


import java.util.LinkedList;
import java.util.Queue;

class Kth_Smallest_Element{

    // Way I:
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {

        if( root == null ){
            return -1;
        }

        kthSmallest( root.left, k );
        count++;
        if( count == k ){
            result = root.value;
        }
        kthSmallest( root.right, k );

        return result;
    }

    // Way II: storing all the node in the correct order using inorder traversal
    public int kthSmallest_II(TreeNode root, int k) {
         Queue<TreeNode> q = count( root, new LinkedList<>());

         TreeNode curr = null;
         for( int i=0 ; i<k ; i++ ){
             curr = q.poll();
         }

         return curr.value;
    }
    public Queue<TreeNode> count( TreeNode root, Queue q ){

        if( root == null){
            return q;
        }

        count( root.left, q );
        q.offer( root );
        count( root.right, q );

        return q;
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


public class y6_Kth_Smallest_Element {
    public static void main(String[] args) {

    }
}
