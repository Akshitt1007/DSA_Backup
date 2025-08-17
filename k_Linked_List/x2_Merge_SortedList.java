package k_Linked_List;

public class x2_Merge_SortedList {
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

//    https://leetcode.com/problems/merge-two-sorted-lists/description/

    private void insertLast(int value){
        if( head == null ){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        while ( temp.next != null ){
            temp = temp.next;
        }
        temp.next = node;
    }
    public x2_Merge_SortedList mergeTwoLists(x2_Merge_SortedList first, x2_Merge_SortedList second){

        Node f1 = first.head;
        Node s2 = second.head;

        x2_Merge_SortedList ans = new x2_Merge_SortedList();

        if ( f1 == null ){
            return second;
        }
        if( s2 == null ){
            return first;
        }

        while( f1 != null && s2 != null ){

            if( f1.value > s2.value){
                ans.insertLast(s2.value);
                s2=s2.next;
            }
            else{
                ans.insertLast(f1.value);
                f1=f1.next;
            }
        }
        while ( f1 != null ) {
            ans.insertLast( f1.value );
            f1=f1.next;
        }
        while ( s2 != null ){
            ans.insertLast( s2.value );
            s2=s2.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        x2_Merge_SortedList node = new x2_Merge_SortedList();
        node.insertFirst(5);
        node.insertFirst(3);
        node.insertFirst(1);

        x2_Merge_SortedList node2 = new x2_Merge_SortedList();
        node2.insertFirst(14);
        node2.insertFirst(9);
        node2.insertFirst(2);
        node2.insertFirst(1);

        x2_Merge_SortedList ans = new x2_Merge_SortedList().mergeTwoLists( node, node2);
        ans.display();
    }
}
