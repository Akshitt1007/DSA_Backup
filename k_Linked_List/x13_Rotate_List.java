package k_Linked_List;

public class x13_Rotate_List {
    private Node head;
    private Node tail;
    private int size;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    public void insertLast(int value) {
        if (head == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        tail = node;  // update tail here
        size++;
    }
    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

//    https://leetcode.com/problems/rotate-list/description/

    public void rotateList( int k ){

        Node last = head;
        int length = 1;
        while ( last.next != null ){
            last = last.next;
            length++;
        }
        last.next = head;

        int rotation = k % length ;
        int skip = length - rotation;

        Node newLast = head;
        for ( int i=0 ; i < skip-1 ; i++ ){
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;
    }

    public static void main(String[] args) {
        x13_Rotate_List list = new x13_Rotate_List();
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);
        list.display();

        list.rotateList(2);
        list.display();
    }
}
