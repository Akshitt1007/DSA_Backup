package n_Binary_Tree;


import java.util.Stack;

/*
                    Node
                    /   \
                 Left   Right

    Traversal Method:

        1. Pre Order:       node -> left child -> right child

            - Used when we to perform something at that node
              and then move down


        2. In Order:       left child -> node -> right child

            - Used when we want the lowest value in a BT


        3. Post Order:       left child -> right child -> node

            - Used when we have to perform on root node at last
            - like: deleting any rootNode( first we have to remove its children only the we would be able to remove the root node)
 */
public class a10_DFS {

    private TreeNode rootNode;
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

    public static void main(String[] args) {

    }

    // dfs using stack
    void dfsStack(TreeNode node) {
        if(node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {

            TreeNode removed = stack.pop();
            System.out.print(removed.val + " ");

            if(removed.right != null) {
                stack.push(removed.right);
            }
            if(removed.left != null) {
                stack.push(removed.left);
            }
        }
    }

}
