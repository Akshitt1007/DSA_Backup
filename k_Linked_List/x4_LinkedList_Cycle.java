package k_Linked_List;

public class x4_LinkedList_Cycle {
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

//    https://leetcode.com/problems/linked-list-cycle/description/
// AMAZON AND MICROSOFT
    public boolean checkCycle(){
        if ( head == null ){
            return false;
        }
        if( head.next == null ){
            return false;
        }
        Node fast = head;
        Node slow = head;

        while ( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;

            if ( fast == slow ){
                return true;
            }
        }
        return false;
    }


    // Finding the length of the cycle:
    // 1. When slow == fast, a cycle is confirmed.
    // 2. Now, take a new pointer, say temp, and start it from slow.
    // 3. Move temp one step at a time, and count the steps.
    // 4. Stop when temp == slow again.
    // 5. The count is the length of the cycle.
    public int checkCycleLength(){
        Node fast = head;
        Node slow = head;

        while ( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;

            if ( fast == slow ){

                Node temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }
                while( temp != slow );
                return length;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        x4_LinkedList_Cycle obj = new x4_LinkedList_Cycle();
        obj.insertFirst(-4);
        obj.insertFirst(0);
        obj.insertFirst(2);
        obj.insertFirst(3);

        System.out.println( obj.checkCycle() );
    }
}
