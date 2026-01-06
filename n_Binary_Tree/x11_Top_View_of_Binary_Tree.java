package n_Binary_Tree;

//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

import java.util.*;

public class x11_Top_View_of_Binary_Tree {

    static class Pair{
        TreeNode root;
        int line;
        public Pair( TreeNode root, int line ){
            this.root = root;
            this.line = line;
        }
    }
    public static ArrayList<Integer> topView(TreeNode root ){

        ArrayList<Integer> result = new ArrayList<>();

        if( root == null ){
            return result;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<Pair>();

        q.add( new Pair( root, 0) );

        while( !q.isEmpty() ){

            Pair x = q.poll();

            TreeNode temp = x.root;
            int line = x.line;

            if( map.get(line) == null ){
                map.put( line, temp.val );
            }

            if( temp.left != null ){
                q.add( new Pair( temp.left, line-1 ));
            }
            if( temp.right != null ){
                q.add( new Pair( temp.right, line+1 ));
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            result.add(entry.getValue());
        }

        return result;
    }

    private a10_DFS.TreeNode rootNode;
    public class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        private int height;

        public TreeNode( int val ){
            this.val = val;
        }

        public int getValue(){
            return val;
        }
    }
}
