package k_Linked_List;

public class c2_main {
    public static void main(String[] args) {

        c1_Circular_LinkedList demo = new c1_Circular_LinkedList();

        demo.Insert(10);
        demo.Insert(20);
        demo.Insert(30);
        demo.Insert(40);
        demo.display();

        demo.Delete( 30 );
        demo.display();
    }
}
