package n_Binary_Tree;


class BinaryTree_Maximum_Path_Sum{

    // Just like the Diameter of Binary Tree
    // But here we will take sum of all the node
    // and if sum is greater than the global and update it

    int MaxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper( root );
        return MaxSum;
    }
    public int helper(TreeNode root ){

        if( root == null ){
            return 0;
        }

        int left = helper( root.left );
        int right = helper( root.right );

        // if any side is -ve means we don't want that side
        // Therefore we make that side 0.
        left = Math.max(0, left );
        right = Math.max(0, right );

        int pathSize = left + right + root.value;

        // if( pathSize > MaxSum ){
        //     MaxSum = pathSize;
        // }

        MaxSum = Math.max( pathSize, MaxSum );

        return Math.max(left, right) + root.value;
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

public class z3_BinaryTree_Maximum_Path_Sum {
    public static void main(String[] args) {
    }
}
