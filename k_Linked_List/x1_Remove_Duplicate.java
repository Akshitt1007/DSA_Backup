package k_Linked_List;

public class x1_Remove_Duplicate {
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


//    https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/1646081894/
    public void removeDuplicate(){

        Node present = head;

        while ( present.next != null ){

            if( present.value == present.next.value ){
                present.next = present.next.next;
            }
            else{
                present = present.next;
            }
        }
    }

    public static void main(String[] args) {

        x1_Remove_Duplicate node = new x1_Remove_Duplicate();
        node.insertFirst(5);
        node.insertFirst(5);
        node.insertFirst(5);
        node.insertFirst(4);
        node.insertFirst(3);
        node.insertFirst(3);
        node.insertFirst(3);
        node.insertFirst(3);
        node.insertFirst(2);
        node.insertFirst(1);
        node.insertFirst(1);
        node.insertFirst(1);
        node.display();

        node.removeDuplicate();
        node.display();

    }
}
