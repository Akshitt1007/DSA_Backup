package k_Linked_List;

public class b2_Main {
    public static void main(String[] args) {

        b1_Double_LinkedList list = new b1_Double_LinkedList();

        list.InsertFirst(30);
        list.InsertFirst(20);
        list.InsertFirst(10);
        list.InsertFirst(0);

        list.display();

        list.InsertLast_noTail(40);
        list.display();
        list.displayReverse();

        list.Insert( 25, 4);
        list.display();

        list.InsertAfterValue( 15, 10);
        list.InsertAfterValue( 15, 40);
        list.display();
    }
}
