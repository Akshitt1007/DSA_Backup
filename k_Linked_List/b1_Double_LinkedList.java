package k_Linked_List;

public class b1_Double_LinkedList {

    public void InsertFirst( int value ){
        Node node = new Node( value );

        node.next = head;
        //head.prev = node;     // Here check for null pointer because what if it's the first element we are inserting
                                // then head.prev = null -> null pointer exception
                                // [6] first element   head is null not pointing to anything
                                // if we do (head.prev = [6])   null = 6: error

        // Link old head back to new node
        if( head != null ){     // This will only work if there are already present
            head.prev = node;   // [6] --> [3]-[2]-[1]
        }                       // here [3] is the head and with head.prv => 3 will be pointing to [6] prev

        head = node;
        node.prev = null; // New node has no previous node (it's now the first)

        size++;
    }

    public void InsertLast_noTail( int value ){

        if ( head == null ){
            InsertFirst(value);
            return;
        }

        Node node = new Node( value );
        Node temp = head;

        while( temp.next != null ){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        tail = node;

        size++;
    }

    public void Insert( int value, int index ){
        Node node = new Node( value );
        Node temp = head;

        for( int i=1 ; i<index-1 ; i++ ){
            temp=temp.next;
        }
        Node after = temp.next;

        node.next = temp.next;
        temp.next = node;
        node.prev = temp;
        after.prev = node;

        size++;
    }

    public void InsertAfterValue(int value, int target) {
        if (head == null) {
            System.out.println("List is empty. Cannot insert after " + target);
            return;
        }

        Node node = new Node(value);
        Node temp = head;

        while (temp.next != null) {
            if (temp.value == target) {  // Check if current node's value matches target

                node.next = temp.next;     // Same as insert code
//                temp.next.prev = node;  // May throw NullPointerException if target is last node, because temp.next would be null
                if ( temp.next != null ){
                    temp.next.prev = node;
                }
                temp.next = node;
                node.prev = temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void display(){
        Node temp = head;
        while( temp != null ){
            System.out.print( temp.value + " " );
            temp=temp.next;
        }
        System.out.println();
    }
    public void displayReverse(){
        Node temp = tail;
        while( temp != null ){
            System.out.print( temp.value + " " );
            temp = temp.prev;
        }
        System.out.println();
    }
    private Node head;
    private Node tail;
    private int size;

    private class Node{
        int value;
        Node next;
        Node prev;

        Node( int value ){
            this.value = value;
        }
        Node( int value , Node next, Node prev ){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

}
