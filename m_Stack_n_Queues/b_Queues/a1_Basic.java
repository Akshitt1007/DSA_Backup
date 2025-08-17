package m_Stack_n_Queues.b_Queues;

import java.util.LinkedList;
import java.util.Queue;

/*
    Queue:
    - A Queue is a linear data structure that follows the FIFO principle:
      First In, First Out

      ===============================
         QUEUE (FIFO)
      ===============================

    Front → [ Amit ] ← Rear
    Front → [ Amit ] [ Raj ] ← Rear
    Front → [ Amit ] [ Raj ] [ Neha ] ← Rear

    - First Amit came, second Raj and third Neha
    - Not like in stack
    - here, the person who came first will be the one the also leaves first

    This is called - "First in First Out(FIFO)" or "Last In Last Out(LILO)"

    Operations:

        line.offer("Karan"); // Adds to REAR
        → [ Amit ] [ Raj ] [ Neha ] [ Karan ]

        line.poll(); // Removes from FRONT (Amit goes)
        → [ Raj ] [ Neha ] [ Karan ]

        line.peek(); // Looks at Raj (still at front)

 */
public class a1_Basic {
    public static void main(String[] args) {
//        Queue<Integer> q = new ArrayDeque();              //  Using Deque (ArrayDeque)
//        Queue<Integer> pq = new PriorityQueue();          //  PriorityQueue (Heap-based)
//        Queue<Integer> p = new ConcurrentLinkedQueue();   //  Concurrent Queues (Multithreaded)

        Queue<Integer> queue = new LinkedList();            // Using Linked List

        // Same like adding a new node at the end
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Show the first element in the Queue
        // ie the head
        System.out.println( queue.peek() );

        // Removes from the starting
        System.out.println( queue.remove() );
        System.out.println( queue.remove() );
        System.out.println( queue.remove() );
        System.out.println( queue.remove() );
        System.out.println( queue.remove() );

        // error will throw that - removing an element from an empty linked list
//        System.out.println( queue.remove() );



        // Deque
        // - A queue where we can add and remove elements from both the start and end.
    }
}

/*

    Queue is implement like an LinkedList
    Queue implemented by LL is simple and follows an FIFO

    but other implementation also exist:

    Implementation Class	- Backing Data Structure	    - Special Trait
    LinkedList	                Doubly Linked List              Simple FIFO queue
    PriorityQueue	            Heap (usually)	                Orders elements by priority
    ArrayDeque	                Resizable Array	                Faster than LinkedList in many cases
    ConcurrentLinkedQueue	    Lock-Free Linked List	        Thread-safe for concurrent use
 */



/*
    !! But shouldn't Stack be an interface?

        - YES. correct in principle.

        Just like Queue, stack is a concept, not a specific implementation.
        There are multiple ways to implement it:
            1. With an array
            2. With a linked list
            3. With a deque (ArrayDeque is killer for stack use!)

        So if Java were designed today, Stack would probably be an interface — just like Queue.
        But back then, Java was still figuring things out... and made Stack a class.
 */
