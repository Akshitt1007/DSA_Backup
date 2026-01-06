package n_Binary_Tree;


//https://www.geeksforgeeks.org/dsa/evaluation-of-expression-tree/

public class x12_Evaluation_of_expression_tree {

    class Node {
        int data; // data used as key value
        Node leftChild;
        Node rightChild;
        public Node()
        {
            data=0;
        }
        public Node(int d)
        {
            data=d;
        }
    }

    public static int evaluateTree(Node root) {

        if (root == null)
            return 0;

        if (root.leftChild == null && root.rightChild == null)
            return root.data;

        int leftVal = evaluateTree(root.leftChild);
        int rightVal = evaluateTree(root.rightChild);

        if (root.data == 43) {
            return leftVal + rightVal;
        }
        else if (root.data == 45){
            return leftVal - rightVal;
        }
        else if (root.data == 42) {
            return leftVal * rightVal;
        }
        else if (root.data == 47) {
            return leftVal / rightVal;
        }

        return 0;
    }
}
