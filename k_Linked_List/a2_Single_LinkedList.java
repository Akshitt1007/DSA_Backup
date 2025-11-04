package k_Linked_List;

public class a2_Single_LinkedList {

    public void Display() {
        Node temp = head ;
        while ( temp != null ){
            System.out.print( temp.value + " -> " );
            temp = temp.next ;
        }
        System.out.println( "List Ended" );
    }

    // This method will return reference pointer to that node of the index given
    public Node get( int index ){
        Node temp = head;
        for ( int i=0 ; i<index ; i++ ){    //Working from 1-index
            temp = temp.next;
        }
        return temp;
    }

    public int findElement( int ans ){
        Node temp = head;
        int i = 1;
        while ( temp != null ){
            if ( temp.value == ans ){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public a2_Single_LinkedList(){
        this.size=0;            // When every a list is formed this constructor will set the size to 0
    }

    private Node head;
    private Node tail;
    private int size;

    public void Insert( int val, int index ){

        if ( index == 0 ){          // if index=0 => inserting at first index only
            InsertAtFirst( val );
            return;
        }
        if ( index == size ){       // // if index=size => inserting at end of list => Last index
            InsertAtLast( val );
            return;
        }

        Node temp = head;
        for ( int i = 1 ; i < index ; i++ ){
            temp = temp.next;
        }

        Node node = new Node( val, temp.next );

        temp.next = node;

//        better:
//        Node new_Node = new Node(value);
//        Node temp = getIndex( index-1 );
//        new_Node.next=temp.next;
//        temp.next=new_Node;

        /*
                When inserting a new node between 'temp' and 'temp.next',
                    first set  -> node.next = temp.next;
                    after that -> temp.next = node;

                    Why?

                    If you do it in the opposite order:
                        temp.next = node;
                        node.next = temp.next;

                    Then 'temp.next' points to 'node', so
                    'node.next = temp.next' sets 'node.next' to itself,
                    causing a self-referential loop and breaking the list structure.
         */
        size ++;
    }

    public void InsertAtFirst( int val ){

        Node node = new Node( val );
        node.next = head;           // Head = 0 , therefore it will put at first
        head = node;

        if ( tail == null ){        // There is only first one element in Node
            tail = head;            // Head and Tail point to same Node
        }

        size += 1;
    }

    public void InsertAtLast( int val ){

        if ( tail == null ){    // empty list
            InsertAtFirst( val );
            return;             // don't run below part
        }
        Node node = new Node( val );
        tail.next = node;
        tail = node;

        size += 1;
    }

    public void InsertAtLast_withNoTail( int val ){

        Node node = new Node( val );
        Node temp = head;

        while ( temp.next != null ){
            temp = temp.next;
        }
        temp.next = node;
        tail = node;

        size += 1;
    }


    private class Node{
        private int value;          // the data it carries
        private Node next;          // the reference to the next node in the chain
                                    // If next is null, it means you're at the end of the line.

        public Node(int value){
            this.value = value;
        }
        public Node( int value, Node next ){
            this.value = value;
            this.next = next;
        }
         /*
                Not written "Next" with value constructor:
                because there are two cases:
                    i) value and obj - if we pass the value and next obj ref. then both the constructor will be called
                                       and value will be solved

                    ii) only value  - if we pass only the value then only the value will be stored
                                      and the next will default = null
                                      meaning it would be the First or last node
         */
    }

    public void DeleteFirst(){

        int val = head.value;
        System.out.println( val + " is removed.");

//        Node temp = head;
//        head = temp.next;
//        temp.next = null;
        head = head.next;

        if ( head == null ){        // If the list becomes empty (you just removed the only node), set tail to null too
            tail = null;
        }

        size--;         // to reduce size
    }

    public void DeleteLast(){

        if ( size <= 1 ){       // This means there is only one node, Head and Tail points to same node
            DeleteFirst();
            return;
        }

        int val = tail.value;
        System.out.println( val + " is removed." );

        Node temp = head;
        for ( int i=1 ; i < size-1 ; i++ ){
            temp = temp.next;
        }
        temp.next = null;
        tail =  temp;

        size --;
    }

    public void Delete( int index ){

        Node previous = get( index-1 );
        Node target = get( index );

        System.out.println( target.value + " is removed" );

//        previous.next = target;           // if we do, get( index + 1 ) - next to target element node
//        previous.next = previous.next.next;
        previous.next = target.next;

        size --;
    }
}

/*
        How It Works:
            -> head = head.next;

            1. This shifts the head to the next node, effectively removing the first node from the list.
            2. The old node ([10]) still exists in memory temporarily, but…

        Java Garbage Collection (GC):
            -> Java has automatic memory management.
            -> If no variable in your code points to the old node anymore (like [10]), it's considered unreachable.
            -> Even if [10] points to [20], if nothing points to [10], it becomes eligible for GC.
            -> Java doesn't require manual deletion like C++.

        Optional Cleanup (if you’re neat):
            You can manually sever the connection like this:

            Node temp = head;
            head = head.next;
            temp.next = null; // Manually cut the link

            But it's not necessary. Java’s GC will handle it anyway.
 */
