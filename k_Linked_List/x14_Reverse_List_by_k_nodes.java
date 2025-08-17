package k_Linked_List;

public class x14_Reverse_List_by_k_nodes {
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

//    https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    public void reverseKGroup(  int k){
        if ( k<=1 || head == null ){
            return;
        }

        Node prev = null;
        Node current = head;

        while ( true ){

            // To check if there are at least 7 node remaining
            Node temp = current;
            int count = 0;
            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }
            if (count < k) {
                break; // less than k nodes, don’t reverse
            }


            Node last = prev;
            Node newEnd = current;

            for ( int i=0 ; current != null && i<k ; i++ ){
                Node nxt = current.next;
                current.next = prev;
                prev = current;
                current = nxt;
            }

            if ( last != null ){
                last.next = prev;
            }
            else{
                head = prev;
            }

            newEnd.next = current;

            if ( current == null ){
                break;
            }

            prev = newEnd;
        }
    }

    public static void main(String[] args) {

        x14_Reverse_List_by_k_nodes demo = new x14_Reverse_List_by_k_nodes();
        demo.insertFirst(1);
        demo.insertLast(2);
        demo.insertLast(3);
        demo.insertLast(4);
        demo.insertLast(5);
        demo.display();

        demo.reverseKGroup( 2 );
        demo.display();
    }
}
