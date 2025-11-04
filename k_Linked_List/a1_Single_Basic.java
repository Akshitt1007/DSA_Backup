package k_Linked_List;

/*
                ** draw the Linked List and see the nodes connection and what needs to delete/insert and work on what we have **

        Linked List?

            -> A Linked List is a linear data structure where each element (called a node) is connected to the next one through a reference (a pointer).
            -> Unlike arrays, which sit in one big block of memory like soldiers in a line, linked lists are scattered across memory —
               each node knows where the next one lives, and that’s all it needs to stay connected.

        How a Linked List Looks in Memory:

            10 → 20 → 30 → null
            head = 10
            tail = 30
            Each node:
            [10 | *] -> [20 | *] -> [30 | null]
            Each * is a pointer (reference) to the next node.

        Types of Linked Lists:

        1. Singly Linked List
            -> One-way street
            -> Each node points to the next
            -> Can only go forward

        2. Doubly Linked List
            -> Two-way highway
            -> Each node has:
                - next pointer
                - prev pointer

        3. Circular Linked List
            -> The tail node points back to the head
            -> Forms a loop
            -> Used in round-robin schedulers, buffer rotations, etc.
 */

public class a1_Single_Basic {
    public static void main(String[] args) {

        a2_Single_LinkedList list = new a2_Single_LinkedList();

        list.InsertAtFirst( 3 );
        list.InsertAtFirst( 2 );
        list.InsertAtFirst( 1 );
        list.InsertAtFirst( 0 );
//        list.Display();
//
//        list.InsertAtLast( 4 );
//        list.Display();
//
//        list.InsertAtLast_withNoTail( 5 );
//        list.Display();
//
//        list.Insert( 2, 4);
//        list.Display();
//
//        list.DeleteFirst();
//        list.Display();
//
//        list.DeleteLast();
//        list.Display();
//
//        list.Delete(2);
//        list.Display();

        a3_Demo_Single_List demo = new a3_Demo_Single_List();
        demo.InsertFirst(7);
        demo.InsertFirst(6);
        demo.InsertFirst(5);
        demo.InsertFirst(4);
        demo.InsertFirst(3);
        demo.InsertFirst(2);
        demo.InsertFirst(1);
        demo.Display();

//        demo.exchange(demo,3, 5);
        demo.Display();

//        demo.Display();
//        System.out.println( "\n" + demo.FindElement(40));
//
//        demo.InsertLast(50);
//        demo.Display();
//
//        System.out.println();
//        demo.Insert( 35, 3 );
//        demo.Display();
//
//        System.out.println();
//        demo.DeleteFirst();
//        demo.Display();
//
//        System.out.println();
//        demo.DeleteLast();
//        demo.Display();
//
//        System.out.println();
//        demo.Delete(3);
//        demo.Display();

    }
}


/*
        These nodes are not continuous and can be anywhere in the heap memory
        that's why each node have the path of their next node so that they can visit them,
        and we are provided with head - so that we can start from somewhere ie start

        class Node{
            int value;
            Node next;
        }

        here value - is the numeric number it would be storing
             next - is the reference variable storing the ref. of another node(obj) which comes after it
                    this is same like ref. type we studied in OOPS
                    next is type Node because it points to another node from the same class. Every node is made from the Node class,
                    so next has to be a reference to another node just like itself. This way, all the nodes connect together in a chain.

            if we want to transverse the LL then we have to move from first node
            ie head,
            head = head.next => next node, but this is wrong since we are changing the head and destroying the structure of LL
                                This moves the head reference itself to the next node — which means you lose the original starting point.
            so;
                Node temp = head;
                temp = temp.next => next node, since it;s a temp ref it doesn't matter much and also the structure remains same
                                    we move the temporary pointer, along the list. The head remains untouched, so the entire linked list stays intact.


        arr[] → Pointer to Contiguous Memory
        -> Points to a continuous block
        -> Compiler knows memory layout
        -> Can do pointer math: arr + 1, arr[i]

        head → Reference to First Node in Linked List
        -> Points to a scattered node
        -> Each node links to the next: head.next → next → ...
        -> No pointer arithmetic — just follow the breadcrumb trail 🍞
 */
