package n_Binary_Tree.Self_Balancing_BT;

/*
    AVL Tree (Adelson-Velsky and Landis Tree):

        - The first self-balancing Binary Search Tree (BST), invented in 1962 by Adelson-Velsky and Landis.
        - Ensures the height of the tree always remains O(log n).
        - Balancing is maintained using rotations whenever the Balance Factor (BF) of a node
          (height of left subtree - height of right subtree) becomes less than -1 or greater than +1.


    Algorithm (Insertion):

        1. Insert the new node like a regular BST.
        2. After insertion, backtrack upwards and check the Balance Factor of each node.
        3. If a node becomes unbalanced, fix it by performing appropriate rotations
           (before continuing upwards).


    Parent, Child, and Grandchild in AVL Tree Rotations:

    Parent (Z):

        - The first node that becomes unbalanced after insertion (or deletion).
        - Its balance factor is now either less than -1 or greater than +1.
        - This is the node we want to fix using rotation.
        - Think of it as the “root of the unbalanced subtree”.


    Child (Y):

        - The taller child of the parent (Z) — the side where the imbalance occurred.
        - Example: if Z’s left subtree is taller, then Y = Z.left.
        - This node helps determine which side the imbalance is leaning towards.


    Grandchild (X):

        - The child of Y that lies on the same side where the new node was inserted.
        - This node completes the rotation pattern:
            - LL → grandchild on left of left child
            - LR → grandchild on right of left child
            - RR → grandchild on right of right child
            - RL → grandchild on left of right child

    Why we need them:

        - Parent (Z) → identifies where the problem is.
        - Child (Y) → shows which side is heavy.
        - Grandchild (X) → determines the exact rotation type (single or double).


    Rotation Cases:

        AVL rotations, the “grandchild” we consider is relative to the node that became unbalanced
        and the side where the new element was inserted.

        1. Left-Left (LL Case):
            - Node, child, and grandchild all lie on the left side.
            - Perform a RIGHT ROTATION at the unbalanced node.

        2. Left-Right (LR Case):
            - Parent and child lie on the left, but grandchild is on the right.
            - Perform a LEFT ROTATION at the child,
              then a RIGHT ROTATION at the parent.

        3. Right-Right (RR Case):
            - Node, child, and grandchild all lie on the right side.
            - Perform a LEFT ROTATION at the unbalanced node.

        4. Right-Left (RL Case):
            - Parent and child lie on the right, but grandchild is on the left.
            - Perform a RIGHT ROTATION at the child,
              then a LEFT ROTATION at the parent.

    Result:

        - Guarantees O(log n) time complexity for Search, Insert, and Delete.
        - Ensures the tree never degenerates into a linked list (like an unbalanced BST).

*/

import java.util.Scanner;

class AVL{
    private Node rootNode;

    public class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node( int value ){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    // Constructor calling
    public AVL() {

    }

    // To get the height of that tree
    public int getHeight() {
        return getHeight(rootNode);
    }
    public int getHeight( Node node){
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // To check if AVL exist
    public boolean isEmpty(){
        if ( rootNode == null ){
            return true;
        }
        else{
            return false;
        }
    }


    // Populate AVL from user input
    public void populate(Scanner scanner) {
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();
            insert(value); // BST decides left/right
        }
    }

    // Populating with Array Elements
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    // Populating with Sorted Array given
    // if done through upper Method then we would be getting a skewed BST
    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }
    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    // To check if the AVL is balanced or not
    public boolean balanced() {
        return balanced(rootNode);
    }
    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs( getHeight(node.left) - getHeight(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
        // First will check in between the sibling if they are at same height or not
        // and after && recursive call to get in the subtree of the children to check they are balanced or not
    }


    // To display the AVL
    public void display(){
        display( rootNode, "Root Node:" );
    }
    public void display(Node node, String details ){

        if( node == null ){
            return;
        }

        System.out.println( details + node.getValue() );

        display( node.left, " The left child of " + node.getValue() + ": ");
        display( node.right, " The right  child of " + node.getValue() + ": ");
    }

    /*
        Same as Binary Search Tree,
        but return `rotate(node)` instead of just node.

        rotate(node):
            - Check balance factor.
            - If unbalanced, apply one of 4 rotations (LL, RR, LR, RL).
            - Else, return node as is.
    */
    public void insert( int value ){
        rootNode = insert( value, rootNode);
    }
    private Node insert(int value , Node node){        // value -> node we want to add       node -> parent node

        if( node == null ){
            return new Node(value);     // base case: found the place to insert
        }

        // To left
        if ( value < node.value ){
            node.left = insert( value, node.left );
        }

        // To right
        if ( value > node.value ){
            node.right = insert( value, node.right );
        }

        node.height = Math.max( getHeight(node.left), getHeight(node.right) ) + 1;

        return rotate(node);        // return the unchanged or updated node
    }

    // This method will only rotate the node if it is unbalanced
    private Node rotate( Node node ){

        // Determines which side is unbalanced using balance factor:
        // - left unbalance -> then the difference would be +ve and greater than 1
        // - right side unbalance -> then the difference would be -ve and greater than 1

        // Left heavy:
        if ( getHeight(node.left) - getHeight(node.right) > 1 ){

            // After knowing which side is heavy
            // we will check which subtree is  heavy
            // grandchild would be present on the heavy side of subtree

            // grandchild on left =>   left(greater) - right = +ve
            // grandchild on right =>   left - right(greater) = -ve

            // Left-Left case:
            if ( getHeight(node.left.left) - getHeight(node.left.right) > 0 ){
                return rightRotate( node );     // right rotate on parent node
            }

            // Left-Right case:
            if ( getHeight(node.left.left) - getHeight(node.left.right) < 0 ){

                node.left = leftRotate( node.left );    // left rotate on child node
                return rightRotate( node );             // right rotate on parent node
            }
        }

        // Right heavy:
        if ( getHeight(node.left) - getHeight(node.right) < -1 ){

            // Right-Right case:
            if ( getHeight(node.right.left) - getHeight(node.right.right) < 0 ){
                return leftRotate( node );                 // left rotate on parent node
            }

            // Left-Right case:
            if ( getHeight(node.right.left) - getHeight(node.right.right) > 0 ){

                node.right = rightRotate( node.right );    // right rotate on child node
                return leftRotate( node );                 // right rotate on parent node
            }
        }
        return node;
    }
    /*
        Diagram representation of right and left rotate:

                P                          C                                 P
               / \                       /   \                              / \
              C   T3     Right →        T1     P           Left →          C   T3
             / \        rotate(P)             / \          rotate(C)      / \
           T1   T2                          T2   T3                      T1  T2

     */
    public Node rightRotate( Node parent ){

        Node child = parent.left;
        Node t = child.right;       // the only which would be changed

        child.right = parent;
        parent.left = t;

        // Updating the height
        parent.height = Math.max( getHeight(parent.left), getHeight(parent.right) + 1 );
        child.height = Math.max( getHeight(child.left), getHeight(child.right) + 1 );

        return child;
    }

    public Node leftRotate( Node child ){

        Node parent = child.right;
        Node t = parent.left;       // the only which would be changed

        parent.left = child;
        child.right = t;

        // Updating the height
        parent.height = Math.max( getHeight(parent.left), getHeight(parent.right) + 1 );
        child.height = Math.max( getHeight(child.left), getHeight(child.right) + 1 );

        return parent;
    }
}
public class b2_AVL {
    public static void main(String[] args) {

        AVL tree = new AVL();

        for(int i=0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.getHeight() );

        tree.display();

    }
}

