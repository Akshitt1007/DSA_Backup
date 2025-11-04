package n_Binary_Tree;

//  Q/ We are given a BT and an Array
//  We have to check whether the BT contains path of that exact array from root to leaf node
/*
                3                   arr = [ 3, 9, 12, 8 ]
               / \
              5   9
                 / \
                10  12
               /    /
              16   8
 */

class Path_Exist_from_BT_to_Leaf{

    public void demo(TreeNode root ){
        boolean chck = PathExist( root, new int[]{3, 9, 12, 8} , 0);
    }
    public boolean PathExist( TreeNode root, int[] arr, int i){

        if (root == null) {
            return false;
        }

        // Prevent array index out of bounds
        if (i >= arr.length) {
            return false;
        }

        // If mismatch → fail
        if (root.value != arr[i]) {
            return false;
        }

        // If at leaf and last element matched
        if (root.left == null && root.right == null && i == arr.length - 1) {
            return true;
        }

        return PathExist( root.left, arr , i+1) || PathExist( root.right, arr , i+1 );
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
public class z4_Path_Exist_from_Root_to_Leaf {
    public static void main(String[] args) {

    }
}
