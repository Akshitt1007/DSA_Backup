package n_Binary_Tree;
// Linked Implementation


import java.util.Scanner;

class Binary_Tree{

    private static Node RootNode;

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node( int value ){
            this.value = value;
        }
    }

    // Inserting the value in BT
    public void populate( Scanner scanner ){

        System.out.println("Enter the Root Node value ");
        int value = scanner.nextInt();

        RootNode = new Node( value );           // To assign the value to the root node

        populate( scanner, RootNode );          // Recursive call to fill the Left/Right value of the Nodes
    }
    private void populate( Scanner scanner, Node Node ){

        System.out.println("Do you want to enter left of " + Node.value );
        boolean left = scanner.nextBoolean();

        // Adding for left
        if ( left ){                            // If the left is true only then we will enter the value

            System.out.println("Enter the value");
            int leftValue = scanner.nextInt();

            Node.left = new Node( leftValue );  // Assign the new node to the left of its parent node

            populate( scanner, Node.left );     // Recursive call to check if we want to add again to the left node or not
        }

        System.out.println("Do you want to enter right of " + Node.value );
        boolean right = scanner.nextBoolean();

        // Adding for right
        if ( right ) {                            // If the right is true only then we will enter the value

            System.out.println("Enter the value");
            int rightValue = scanner.nextInt();

            Node.right = new Node(rightValue);  // Assign the new node to the right of its parent node

            populate(scanner, Node.right);     // Recursive call to check if we want to add again to the right node or not
        }
    }

    // Display Function
    public void display( ){
        display( RootNode, "");
    }
    public void display( Node node, String indent ) {

        if (node == null) {
            return;
        }

        System.out.println(indent + node.value);

        display(node.left, indent + "\t");        // First we will print all the values to left of node until there is no left node present
        display(node.right, indent + "\t");       // After all the left Node is displayed we will display the right node value
    }
/*
        That "\t" in your code is a tab character (a horizontal space)
        like :
            10
                5
                    2
                    7
                15
                    12
                    20

             1. 10 is the root node
             2. 5 and 15 are sibling
             3. and 2,7 are children of 5
             4. and 12,20 are children of 15
 */

    // Display the Binary Tree in tree format
    public void prettyDisplay() {
        prettyDisplay( RootNode, 0);
    }
    public void prettyDisplay( Node node, int level ){

        if ( node == null ){
            return;
        }

        prettyDisplay( node.right, level+1 );

        if( level != 0 ){
            for( int i=0 ; i<level-1; i++ ){
                System.out.print( "|\t\t" );
            }
            System.out.println( "|----->" + node.value );
        }
        else{
            System.out.println( node.value );
        }

        prettyDisplay( node.left, level+1 );

    }

}
public class a5_Implementation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Binary_Tree tree1 = new Binary_Tree();

        tree1.populate( sc );

        tree1.display();

        tree1.prettyDisplay();



    }
}

