package n_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  2415. Reverse Odd Levels of Binary Tree
//  https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

class Reverse_odd_level_of_BT{

    public TreeNode reverseOddLevels(TreeNode root) {

        if (root == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;

        while (!q.isEmpty()) {

            List<TreeNode> currLevel = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                currLevel.add(curr);

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }

            }

            if( level % 2 == 1 ){
                int left = 0;
                int right = currLevel.size() - 1;

                while( left < right ){
                    int temp = currLevel.get(left).value;
                    currLevel.get(left).value = currLevel.get(right).value;
                    currLevel.get(right).value = temp;

                    left++;
                    right--;
                }
            }
            level++;
        }
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

public class x9_Reverse_odd_level_of_BT {
    public static void main(String[] args) {

    }
}
