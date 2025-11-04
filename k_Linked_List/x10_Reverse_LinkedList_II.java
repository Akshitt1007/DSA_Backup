package k_Linked_List;

public class x10_Reverse_LinkedList_II {
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
    private Node getTail() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

//    https://leetcode.com/problems/reverse-linked-list-ii/

    public void reverse_II(x10_Reverse_LinkedList_II list, int left, int right) {
        if (left == right) {
            return;
        }

        Node prev = null;
        Node current = head;

        // Move 'current' to the node at position 'left'
        // 'prev' will point to the node just before 'left'
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        // Mark the nodes at the start of the sublist to be reversed
        Node last = prev;         // Node before the sublist
        Node newEnd = current;    // Will become the end of the reversed sublist

        // Reverse nodes between 'left' and 'right'
        for (int i = 0; current != null && i < right - left + 1; i++) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Reconnect the reversed sublist with the original list
        if (last != null) {
            last.next = prev;     // Connect the node before sublist to the start of reversed part
        } else {
            head = prev;          // If reversing from the head, update the head pointer
        }

        newEnd.next = current;    // Connect end of reversed sublist to the remaining list
    }

        public static void main(String[] args) {

    }
}
