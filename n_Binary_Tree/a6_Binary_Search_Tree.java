package n_Binary_Tree;

/*

    Binary Search Tree (BST):

        - A BST is a special kind of binary tree (each node has at most 2 children: left & right), with one key rule:
        - Left child < Parent < Right child
        - Element smaller to Parent will go on left hand side
        - and element smaller to Parent will go on right hand side

    So in order to have a sorted Order:

        - we have to do "Inder order Transversal".
        - ie. left -> parent -> right
 */

import java.util.*;

class Binary_Search_Tree{

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
    public Binary_Search_Tree() {

    }

    // To get the height of that tree
    public int getHeight( Node node){
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // To check if BST exist
    public boolean isEmpty(){
        if ( rootNode == null ){
            return true;
        }
        else{
            return false;
        }
    }


    // Populate BST from user input
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


    // To insert the values in the BST
    public void insert( int value ){
        rootNode = insert( value, rootNode);
    }
    private Node insert( int value , Node node){        // value -> node we want to add       node -> parent node

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

        // if value == node.value, do nothing (no duplicates in BST)

        node.height = Math.max( getHeight(node.left), getHeight(node.right) ) + 1;
        // and to get the height
        // we don't have to traverse the entire list again
        // The height of node will be stored in its property

        return node;        // return the unchanged or updated node
    }


    // To check if the BST is balanced or not
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


    // To display the Binary Search Tree
    public void display(){
        display( rootNode, "Root Node:" );
    }
    public void display( Node node, String details ){

        if( node == null ){
            return;
        }

        System.out.println( details + node.getValue() );

        display( node.left, " The left child of " + node.getValue() + ": ");
        display( node.right, " The right  child of " + node.getValue() + ": ");
    }


}
public class a6_Binary_Search_Tree {
    public static void main(String[] args) {

        Binary_Search_Tree bsTree = new Binary_Search_Tree();
        int[] arr = {10, 5, 29, 8 , 33, 14, 7, 8 };
        bsTree.populate(arr);
        bsTree.display();

        Binary_Search_Tree bsTree2 = new Binary_Search_Tree();
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9 };
        bsTree2.populatedSorted(arr2);
        bsTree2.display();
//
//        Binary_Search_Tree bsTree3 = new Binary_Search_Tree();
//        Scanner sc = new Scanner(System.in);
//        bsTree3.populate(sc);
//        bsTree3.display();
    }

}
