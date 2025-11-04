package n_Binary_Tree;

//  https://leetcode.com/problems/path-sum/
//  112. Path Sum

class Path_Sum{

    // Way I:
    // We will be passing the sum to the child method
    // if we are at the child node and the sum matches only then true would be called
    // and if the left/right leaf node doesn't equal the target
    // then the flow would be back to the parent method and there the sum would be different since sum is different in all method
    public boolean hasPathSum_I(TreeNode root, int targetSum) {
        return helper( root, targetSum, 0 );
    }

    public boolean helper( TreeNode root, int targetSum, int sum ){

        if( root == null ){
            return false;
        }

        sum = sum + root.value;

        // To check if we are at leaf node or not.
        if( root.left == null && root.right == null ){
            if( sum == targetSum ){
                return true;
            }
        }

        return helper( root.left, targetSum, sum) || helper( root.right, targetSum, sum );
    }

    // Way II:
    // 1. In this approach, instead of keeping a running sum, we pass the remaining targetSum down to the child nodes.
    // 2. At each step, we subtract the current node’s value from the targetSum.
    // 3. If we reach a leaf node, the path is valid only if the remaining targetSum becomes 0.
    // 4. This ensures that the path from root to leaf contains values that exactly add up to the original target sum.
    public boolean hasPathSum_II(TreeNode root, int targetSum) {
        return helperII( root, targetSum );
    }
    public boolean helperII( TreeNode root, int targetSum ){

        if( root == null ){
            return false;
        }

        if( root.left == null && root.right == null ){
            if( targetSum == 0 ){
                return true;
            }
        }
        targetSum = targetSum - root.value;

        return helperII( root.left, targetSum ) || helperII( root.right, targetSum );
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

public class z1_Path_Sum {
    public static void main(String[] args) {

    }
}
