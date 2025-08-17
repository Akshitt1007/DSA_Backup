package k_Linked_List;

public class x12_Reorder_list {
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

//    https://leetcode.com/problems/reorder-list/description/

    public void reOrder(){
        if (head == null || head.next == null) return;

        Node mid = getMid(head);
        Node current = mid;
        Node prev = null;
        while ( current != null ){
            Node nxt = current.next;
            current.next = prev;
            prev = current;
            current=nxt;
        }

        Node firstHead = head;
        Node secondHead = prev;

        while( secondHead.next != null ){
            Node h1 = firstHead.next;
            firstHead.next = secondHead;
            firstHead = h1;

            Node s2 = secondHead.next;
            secondHead.next = firstHead;
            secondHead = s2;
        }

        secondHead.next = null;
        // because after the above loop will end
        // our last node will point to backwards nodes
        // therefore since it is the last node we will make it tail
    }
    public Node getMid(Node head){
        Node fast = head;
        Node slow = head;
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        x12_Reorder_list demo = new x12_Reorder_list();
        demo.insertFirst(1);
        demo.insertLast(2);
        demo.insertLast(3);
        demo.insertLast(4);
        demo.insertLast(5);
        demo.insertLast(6);
        demo.insertLast(7);
        demo.reOrder();
        demo.display();
    }
}
