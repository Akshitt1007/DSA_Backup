package k_Linked_List;

// This class is only have main concept code and no edge cases

public class a3_Demo_Single_List {

    private Node head;
    private Node tail;
    public int size;

    public void InsertFirst( int value ){
        Node temp = new Node( value );
        temp.next = head;
        head = temp;

        size++;
    }
    public void InsertLast( int value ){
        Node new_Node = new Node( value );
        Node temp = head;

        while( temp.next != null ){
            temp=temp.next;
        }
        temp.next=new_Node;

        size++;
    }
    public void Insert( int value, int index ) {
        Node new_Node = new Node(value);
        Node temp = getIndex(index - 1);

        new_Node.next = temp.next;
        temp.next = new_Node;

        size++;
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    public a3_Demo_Single_List(){
        this.size=0;
    }
    public void Display(){
        Node temp = head;
        while ( temp != null ) {
            System.out.print( temp.value + " " );
            temp=temp.next;
        }
    }
    public int FindElement( int target ){
        Node temp = head;
        int node_number = 1;
        while( temp!=null ){
            if( temp.value == target ){
                return node_number;
            }
            temp = temp.next;
            node_number++;
        }
        return -1;
    }
    public Node getIndex(int index){
        Node temp = head;
        for(int i=1 ; i<index ; i++ ){
            temp=temp.next;
        }
        return temp;
    }
    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
        Node(int value, Node next ){
            this.value=value;
            this.next=next;
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

    public void DeleteFirst(){
        if ( head == null ){
            tail = null;
        }
        head=head.next;

        size--;
    }
    public void DeleteLast(){
        Node secondLast = getIndex(size-1);
        tail = secondLast;
        secondLast.next=null;

        size--;
    }
    public void Delete( int index ){
        Node previous = getIndex(index-1);
        previous.next = previous.next.next;

        size--;
    }
}