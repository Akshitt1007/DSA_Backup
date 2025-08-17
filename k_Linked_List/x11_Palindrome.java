package k_Linked_List;

public class x11_Palindrome {
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

//    https://leetcode.com/problems/palindrome-linked-list/description/

    public boolean chckPalindrome(){
        if (head == null || head.next == null) return true;

        Node mid = getMid(head);

        Node current = mid;
        Node prev = null;

        while ( current != null ){
            Node nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }

        // prev is now the head of reversed second half
        Node secondHead = prev;
        Node firstHead = head;

        // This only to print the after reversing
        // original : 1 -> 2 -> 3 -> 2 -> 1
        // after : 1 -> 2 -> 1 -> 2 -> 1
//        Node temp = head;
//        while ( temp.next != mid ){
//            temp=temp.next;
//        }
//        Node last = temp;
//        last.next = prev;

        // checking the first half and second half
        // first half end at mid
        // if both the half are same
        // return true else false
        Node firstHalf = head;
        Node secondHalf = prev;

        while ( firstHalf != null ){
            if ( firstHalf.value != secondHalf.value ){
                return false;
            }
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }

        // Restore the reversed second half
        current = prev;
        prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        mid.next = prev;            // Attach it back to the mid

        return true;
    }

    // Method to get the mid-node
    public Node getMid(Node head){
        if( head == null ){
            return head;
        }
        Node fast = head;
        Node slow = head;
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        x11_Palindrome demo = new x11_Palindrome();
        demo.insertFirst(1);
        demo.insertLast(2);
        demo.insertLast(3);
        demo.insertLast(2);
        demo.insertLast(1);

        System.out.println( demo.chckPalindrome() );

        x11_Palindrome demo2 = new x11_Palindrome();
        demo2.insertFirst(1);
        demo2.insertLast(2);
        demo2.insertLast(3);
        demo2.insertLast(2);
        demo2.insertLast(1);
        demo2.insertLast(0);

        System.out.println( demo2.chckPalindrome() );
    }
}


