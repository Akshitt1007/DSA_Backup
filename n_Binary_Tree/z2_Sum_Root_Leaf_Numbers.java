package n_Binary_Tree;

import java.util.ArrayList;
import java.util.List;


//  https://leetcode.com/problems/sum-root-to-leaf-numbers/
//  129. Sum Root to Leaf Numbers

class Sum_Root_Leaf_Numbers {

    // Way I:
    List<String> l = new ArrayList<>();
     public int sumNumbers_I(TreeNode root) {
         helperI( root , "" );
         int sum = 0;

         for( int i=0 ; i<l.size() ; i++ ){
             StringBuilder sb = new StringBuilder(l.get(i));
             sb.reverse();
             int num = Integer.parseInt( sb.toString()  );
             sum = sum + num;
         }
         return sum ;
     }
     public void helperI( TreeNode root , String num){

         if ( root == null ){
             return;
         }

         num = root.value + num;

         if( root.left == null && root.right == null ){
             l.add( num );
         }

         helperI( root.left , num );
         helperI( root.right , num );
     }

     // Way II:
     int result;
     public int sumNumbers(TreeNode root) {
         helper( root, 0 );
         return result;
     }
     public void helper( TreeNode root, int sum){

         if ( root == null ){
             return;
         }

         if( root.left == null && root.right == null ){
            result = result + sum*10 + root.value;
         }
         sum = root.value + sum*10;

         helper( root.left , sum );
         helper( root.right , sum );
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

public class z2_Sum_Root_Leaf_Numbers {
    public static void main(String[] args) {

    }
}
