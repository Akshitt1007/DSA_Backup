package n_Binary_Tree;

/*
    Why need Segment Trees?

        - If we want to find range queries (like sum, min, max, gcd, etc.)

        - A naïve approach: iterate from start to end for each query
            - Best Case : O(1)   → when start == end (single element)
            - Worst Case: O(N)   → when query covers the entire array

        - If we have many queries (like range [1..1000] repeatedly),
          this becomes too slow and inefficient

        - To solve this, we use Segment Trees:
            - Preprocess the array into a binary tree structure
            - Query Time  : O(log N)
            - Update Time : O(log N)   (unlike prefix sums which break after updates)

    ====================================================
    SEGMENT TREE:

        A Segment Tree is a Binary Tree data structure
        that stores information about intervals of an array.
        - Each node represents an interval [L..R].
        - Each node stores some operation result over its interval
          (like SUM, MIN, MAX, GCD, etc.).
        - Commonly used for:
              • Answering range queries
              • Performing range updates efficiently

        Example:
            arr = { 3, 8, 7, 6, -2, -8, 4, 9 }

            If we build a segment tree for SUM:

                                   [0..7] = 27      <- here 2 is query and [0..7] is interval
                                 /               \
                       [0..3] = 24               [4..7] = 3
                      /         \               /         \
               [0..1]=11       [2..3]=13   [4..5]=-10    [6..7]=13
               /     \         /      \    /      \      /      \
        [0..0]=3 [1..1]=8 [2..2]=7 [3..3]=6 [4..4]=-2 [5..5]=-8 [6..6]=4 [7..7]=9

    ====================================================
    HOW QUERYING WORKS (example: find sum in [2..6]):

        There are 3 possible cases when querying:

            1) TOTAL OVERLAP
               - Node interval is completely inside query interval.
               - Directly take the value of that node.
               - Example: [4..5] lies completely inside [2..6] → take -10.

            2) NO OVERLAP
               - Node interval is completely outside query interval.
               - Ignore this node.
               - Example: [0..1] lies outside [2..6] → skip.

            3) PARTIAL OVERLAP
               - Node interval partially overlaps with query interval.
               - Recurse into its children and combine their results.
               - Example: [2..3] partially overlaps with [2..6] → go deeper.

    ====================================================
    Updating a node in Segment Tree:

        Example: update index = 3 with value = 14

            1) CHECK RANGE
                - At the root [0..7], check if index (3) lies inside
                  the current node’s interval.
                - If not in range → return without doing anything.
                - If yes → continue recursion into children.

            2) TRAVERSE LEFT / RIGHT CHILD
                - Go into the left child [0..3] since index (3) is
                  inside this range.
                - If an interval does not contain index (3), skip it.

            3) RECURSIVE SEARCH
                - Keep going down until you reach the leaf node where:
                      start == end == index
                - In this example → node [3..3].

            4) UPDATE LEAF NODE
                - Replace the old value with the new value (14).

            5) BACKTRACK (UPDATE PARENTS)
                - When recursion returns back to the parent node,
                  update its value based on its children.
                - Formula:
                         parent.data = leftChild.data + rightChild.data

            6) PROPAGATE UPWARDS
                - Keep updating all ancestors of the modified node
                  until you reach the root node.


    ====================================================
    WHY SEGMENT TREE IS POWERFUL?

         - Query Complexity: O(log N)
         - Update Complexity: O(log N)
         - Space Complexity: O(4N) (safe upper bound)

         Useful when:
         - We need repeated queries (sum/min/max/gcd) on array ranges.
         - We need frequent updates to elements.

    ====================================================
    BREAKDOWN OF QUERY [2..6] ON OUR TREE

        Query Interval = [2..6]

        Traverse Tree:
          • Start at [0..7]
            -> partial overlap → go to children

          • Left Child [0..3]
            -> partial overlap → go deeper
               - [0..1] → no overlap → skip
               - [2..3] → total overlap → take 13

          • Right Child [4..7]
            -> partial overlap → go deeper
               - [4..5] → total overlap → take -10
               - [6..7] → partial overlap
                    • [6..6] → total overlap → take 4
                    • [7..7] → no overlap → skip

        Final Answer = 13 + (-10) + 4 = 7
*/

class SegmentTrees{

    private static class Node{
        int data;
        int startIndex;
        int endIndex;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval){
            this.startIndex = startInterval;
            this.endIndex = endInterval;
        }
    }

    Node rootNode;

    // Whenever the SegmentTree's class Constructor will be called
    // the tree would be automatically be made with the array given
    public SegmentTrees( int[] arr ){
        this.rootNode = constructTree( arr , 0, arr.length-1 );
    }
    public Node constructTree( int[] arr , int start, int end ){

        // If the node is at the end
        // For the individual sum of index
        if( start == end ){
            Node leaf = new Node( start, end );
            leaf.data = arr[start];
            return leaf;
        }

        // Node at any index we are at
        // with different array index
        Node node = new Node( start, end);

        int mid = ( start + end )/2;

        node.left = constructTree( arr, start, mid );
        node.right = constructTree( arr, mid+1, end );

        // when we will be at the last node
        // then the node just above the below two last node would be having the sum of the last two nodes
        node.data = node.left.data + node.right.data;

        return node;
    }

    // Public method: called by user with query range
    // queryStartIndex and queryEndIndex define the range we want the answer for
    public int query(int queryStartIndex, int queryEndIndex){
        return query( rootNode, queryStartIndex, queryEndIndex );
    }
    private int query( Node node, int queryStartIndex, int queryEndIndex){

        // Case I: total overlapping
        //         node is completely inside the query
        if( node.startIndex >= queryStartIndex && node.endIndex <= queryEndIndex ){
            return node.data;
        }

        // Case II: no overlapping
        //          node is completely outside the query
        else if ( node.startIndex > queryEndIndex || node.endIndex < queryStartIndex ){
            return 0;
        }

        // Case III: partial overlapping
        //           this will give answer when we will reach the leaf node value
        else{
            return query(node.left, queryStartIndex, queryEndIndex) + query(node.right, queryStartIndex, queryEndIndex );
        }

//        int leftSum  = query(node.left, queryStartIndex, queryEndIndex);
//        int rightSum = query(node.right, queryStartIndex, queryEndIndex);
//
//        return leftSum + rightSum;
    }

    // update
    public void update(int index, int value) {
        rootNode.data = update(rootNode, index, value);
    }
    private int update(Node node, int index, int value) {

        // Checks if the index is in the interval
        if (index >= node.startIndex && index <= node.endIndex ){

            // Base Condition: When we have reached the leaf node
            if (index == node.startIndex && index == node.endIndex ) {
                node.data = value;
                return node.data;
            }
            // If not the base condition we will check further in which left/right node our index is present
            // If any left/right node it is not present it will simply return and checks in the other half for that index
            else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        // if the node is not in the interval from the first check we will simply just return the node value
        return node.data;
    }

    // Display Method
    public void display(){
        display( rootNode  );
    }
    private void display(Node node) {
        String str = "";

        // LEFT CHILD
        if(node.left != null) {
            str = str + "Interval=[" + node.left.startIndex + "-" + node.left.endIndex + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // CURRENT NODE
        str = str + "Interval=[" + node.startIndex + "-" + node.endIndex + "] and data: " + node.data + " <= ";

        // RIGHT CHILD
        if(node.right != null) {
            str = str + "Interval=[" + node.right.startIndex + "-" + node.right.endIndex + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        // PRINT INFORMATION
        System.out.println(str + '\n');

        // RECURSION
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }

}

public class a8_Segment_Trees {
    public static void main(String[] args) {

        int[] arr = { 3, 8, 7, 6, -2, -8, 4, 9 };
        SegmentTrees tree = new SegmentTrees( arr );

//        tree.display();
        System.out.println( tree.query(1, 6));
    }
}
