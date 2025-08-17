package k_Linked_List;

public class x9_Reverse_LinkedList {
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


//    https://leetcode.com/problems/reverse-linked-list/submissions/

    // --------- RECURSIVE REVERSE  ---------
    private Node getTail() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    public void helper() {
        tail = getTail(); // Initialize the tail before recursion
        reverseRecursion(head);
    }
    private void reverseRecursion(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverseRecursion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // --------- Iterative REVERSE ---------
    public void reverseIterative(){
        Node prev = null;
        Node current = head;

        while ( current != null ){
            Node next = current.next;
            current.next = prev;
            prev=current;
            current = next;
        }
        head = prev;
        // prev would be the last non-null node
    }

    public void reverseHalf( Node mid ){
        Node current = mid;
        Node prev = null;

        // Reverse from mid to end
        while (current != null) {
            Node nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }

        // Reconnect reversed sublist back to the first part
        Node midPrev = head;
        if (midPrev == mid) {
            // If mid is head, the whole list is reversed now
            head = prev;
        } else {
            while (midPrev.next != mid) {
                midPrev = midPrev.next;
            }
            midPrev.next = prev;
        }
    }

    public static void main(String[] args) {
        x9_Reverse_LinkedList list1 = new x9_Reverse_LinkedList();

        list1.insertFirst(5);
        list1.insertLast(4);
        list1.insertLast(3);
        list1.insertLast(2);
        list1.insertLast(1);
        list1.display();        // Output: 5 4 3 2 1

        list1.helper();
        list1.display();        // Output: 1 2 3 4 5

        x9_Reverse_LinkedList list2 = new x9_Reverse_LinkedList();
        list2.insertFirst(10);
        list2.insertLast(9);
        list2.insertLast(8);
        list2.insertLast(7);
        list2.insertLast(6);
        list2.display();

        list2.reverseIterative();
        list2.display();
    }
}
