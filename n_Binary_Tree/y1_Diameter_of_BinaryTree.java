package n_Binary_Tree;

//  543. Diameter of Binary Tree
//  https://leetcode.com/problems/diameter-of-binary-tree/


// 1. This is Post Order traversal type of Question
// 2. Since we first find left side and then right side of tree
// 3. then returning the greatest side

class Diameter_of_BT{

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height( root );
        return diameter-1;
    }

    public int height(TreeNode root ){

        if( root == null ){
            return 0;
        }

        int leftHeight = height( root.left );
        int rightHeight = height( root.right );

        int tempDiameter = leftHeight + rightHeight + 1;
        if( tempDiameter > diameter ){
            diameter = tempDiameter;
        }

        return Math.max( leftHeight, rightHeight) + 1;
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
public class y1_Diameter_of_BinaryTree {
    public static void main(String[] args) {

    }
}
