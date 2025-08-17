package k_Linked_List;

public class x8_Sorting_LinkedList {
    private Node head;
    private int size;

    public void insertFirst( int value ){
        Node node = new Node( value );
        node.next = head;
        head = node;
        size++;
    }
    public void insertLast( int value ){
        if( head == null ){
            insertFirst(value);
            return;
        }
        Node node = new Node( value );
        Node temp = head;
        while( temp.next != null ){
            temp = temp.next;
        }
        temp.next = node;
        node.next = null;
        size++;
    }
    public void insert( int value , int index ){
        Node node = new Node(value);
        Node temp = head;

        for ( int i=0 ; i<index-1 ; i++){
            temp=temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
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

//    https://leetcode.com/problems/sort-list/description/

//    public Node usingMergeSort(Node head){
//
//    }
//
//    public Node mergeList( Node list1, Node list2 ){
//    }
//
//    public Node middleNode( Node x ){
//    }

    public static void main(String[] args) {

    }
}
