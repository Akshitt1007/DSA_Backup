package n_Binary_Tree;


/*

        BFS - Breadth First

        - Breadth-First Search (BFS) is a graph traversal algorithm.
        - It explores a graph level by level (or layer by layer), starting from a source node and
          visiting all its immediate neighbors before moving to the next level.

                                        5
                                       /  \
                                      4    3
                                     / \  / \
                                    1  2  7  8

                        BFS - 5 -> 4 -> 3 -> 1 -> 2 -> 7 -> 8

        It is mainly used for:

        - Finding the shortest path in an unweighted graph.
        - Checking connectivity of a graph.
        - Solving problems like "minimum number of steps", "levels of nodes", etc.

        When to use it:

        1. When the answers near the root node
        2. When we to find answer level by level ( like give the sum of every node level by level)
 */

import java.util.*;

class BFS{

//  https://leetcode.com/problems/binary-tree-level-order-traversal/
//  102. Binary Tree Level Order Traversal

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        // If the tree is empty
        if( root == null ){
            return result;
        }

        Queue<Node> q = new LinkedList<>();

        q.add( root );

        while ( !q.isEmpty() ){

            int size = q.size();
            ArrayList currentLevel = new ArrayList<>();

            for( int i=0 ; i < size ; i++ ){

                Node currNode = q.poll();

                currentLevel.add( currNode.value );

                if ( currNode.left != null ){
                    q.offer( currNode.left );
                }

                if ( currNode.right != null ){
                    q.offer( currNode.right );
                }
            }
            result.add( currentLevel );
        }
//        result.reversed();
        return result;
    }



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
    public BFS() {

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

public class a9_BFS {
    public static void main(String[] args) {

    }
}
