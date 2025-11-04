package n_Binary_Tree;

//  297. Serialize and Deserialize Binary Tree
//  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

class Serialize_and_Deserialize_BT{

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        helper( root, str );
        return str.toString();
    }
    private StringBuilder helper( TreeNode root, StringBuilder str ){

        if (root == null) {
            str.append("null,");
            return str;
        }

        str.append(root.value).append(",");
        helper(root.left, str);
        helper(root.right, str);

        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder sb = new StringBuilder(data);
        return helper(sb);
    }

    private TreeNode helper(StringBuilder sb) {

        // find first comma
        int idx = sb.indexOf(",");
        String token = sb.substring(0, idx);
        sb.delete(0, idx + 1); // consume this token + comma

        if (token.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = helper(sb);
        node.right = helper(sb);

        return node;
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

public class y8_Serialize_and_Deserialize_BT {
}
