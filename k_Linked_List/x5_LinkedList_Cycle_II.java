package k_Linked_List;

public class x5_LinkedList_Cycle_II {
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
    
//    2nd approach for which we use the Fast and slow pointer method
//    https://leetcode.com/problems/linked-list-cycle-ii/description/

    public int cycleStartingPoint(){
        int length=0;
        Node fast = head;
        Node slow = head;

        // finding the length
        while( fast != null && fast.next != null ){
            fast=fast.next.next;
            slow=slow.next;
            if( slow == fast ){
                Node temp = slow;
                do{
                    temp=temp.next;
                    length++;
                }while ( temp != slow );
                break; // ⭐️ IMPORTANT: Break after finding cycle length!
            }
        }

        // finding the start node
        Node first = head;
        Node second = head;

        // with this loop
        // our second pointer would be placed somewhere in the loop
        while (length > 0){
            second=second.next;
            length--;
        }

        // now moving both pointer
        while( first != second ){
            first=first.next;
            second=slow.next;
        }

        // return any Node since they point at the same Node index
        return first.value;


        /*
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null|| fast.next==null){
            return null;
        }
        fast=head;
        while(slow!=fast){
        slow=slow.next;
        fast=fast.next;
        }
       return fast;
         */
    }
}
