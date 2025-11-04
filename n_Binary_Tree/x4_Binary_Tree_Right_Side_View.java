package n_Binary_Tree;
import java.util.*;


//199. Binary Tree Right Side View
//https://leetcode.com/problems/binary-tree-right-side-view/description/

class Binary_Tree_Right_Side_View{

    // Way I: Using deque
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if( root == null ){
            return result;
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer( root );

        while( !dq.isEmpty() ){
            int size = dq.size();

            // Adding the last element of dq
            TreeNode last = dq.getLast();
            result.add( last.value );

            for( int i=0 ; i<size ; i++){

                TreeNode curr = dq.poll();

                if( curr.left != null ){
                    dq.offerLast( curr.left );
                }
                if( curr.right != null ){
                    dq.offerLast( curr.right );
                }
            }
        }
        return result;
    }

    // Way II:
    public List<Integer> rightSideView_II(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i=0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == levelSize - 1) {
                    result.add(currentNode.value);
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    // Way III
    public List<Integer> rightSideView_III(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode last = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                last = curr; // last node in this level

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            // add rightmost node of this level
            result.add(last.value);
        }

        return result;
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
public class x4_Binary_Tree_Right_Side_View {
    public static void main(String[] args) {

    }
}
