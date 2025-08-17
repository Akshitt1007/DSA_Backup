package k_Linked_List;

public class c1_Circular_LinkedList {

    public void Insert( int value ){
        Node node = new Node(value);

        if( head == null ){
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        tail = node;

        size++;
    }

    public void Delete( int value ){
        if( head == null ){
            System.out.println("Empty list");
            return;
        }

        if( head.value == value ){
            head = head.next;
            tail.next = head;
            return;
        }

        Node rm = getIndex( value );

        rm.next = rm.next.next;

        size--;
    }

    private Node head;
    private Node tail;
    private int size;

    public void display(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.value + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public Node getIndex(int target) {
        if (head == null) return null;

        Node temp = head;

        do {
            if (temp.next.value == target) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);

        return null; // cleaner and safer
    }

    private class Node{
        int value;
        Node next;

        Node( int value ){
            this.value=value;
        }
        Node( int value , Node next){
            this.value=value;
            this.next=next;
        }
    }
}
