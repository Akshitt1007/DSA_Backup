package k_Linked_List;

public class x7_Middle_of_LinkedList {
    private Node head;
    private int size;
    public void insertFirst(int value){
        Node node = new Node( value);

        node.next = head;
        head = node;

        size++;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    private class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }

//    https://leetcode.com/problems/middle-of-the-linked-list/

    // Normal Method
    public int returnMiddleNode(){
        if( head == null ){
            return -1;
        }

        Node temp = head;
        int length = 0;

        // Step 1: Count the number of nodes
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: Find mid-index (0-based)
        int mid = length / 2;

        // Step 3: Move to the middle node
        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    // In single Pass
    public int returnMiddle(){
        if( head == null ){
            return -1;
        }

        Node slow = head;
        Node fast = head;

        while( fast != null && fast.next != null ){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow.value;
    }

    public static void main(String[] args) {
        x7_Middle_of_LinkedList list = new x7_Middle_of_LinkedList();

        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        System.out.println( list.returnMiddleNode() );
        System.out.println( list.returnMiddle() );
    }
}
