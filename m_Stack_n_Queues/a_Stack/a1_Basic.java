package m_Stack_n_Queues.a_Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
    Stack:
    A stack is a linear data structure that stores elements in LIFO (Last In, First Out) order.
    Yes — it can store functions, objects, and primitive data types — but context matters:


    1. Stack Data Structure
        - A user-defined or built-in structure like:

            Stack<Integer> stack = new Stack<>();

        - You use this in code explicitly for things like:
            1. Undo feature
            2. Reversing elements
            3. Syntax parsing (like bracket matching)
        - You manually push/pop data


    2. Call Stack (Runtime Stack)
        - This is automatic, managed by the system behind the scenes.
        - It stores:
            1. Function calls
            2. Local variables (primitives + object references)
            3. Return addresses (where to go after a function ends)

    How they are not same :

        Feature	          Stack (Data Structure)	                Call Stack (Runtime Stack)
         Created By	        You (explicit in code)	                    JVM / OS (automatic)
         Purpose	        Store data in LIFO style	                Manage function calls and local variables
         Lifetime	        Controlled by programmer	                Exists as long as the program runs
         Content	        Any data: int, String, objects	            Function calls, parameters, local variables
         Location           in memory	Usually heap (if object)	    Stack segment (memory allocated by system)
         StackOverflow?	    Rare, unless you fill it manually	        Common if recursion goes infinite

    - both are stacks by behavior, but one we control, the other is under the hood, silently making sure our program doesn't trip over itself.
 */
public class a1_Basic {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println( stack );

        System.out.println(stack.pop());        // last element added; leaves first
        System.out.println(stack.pop());        // and so on
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());        // The element that is added first is removed in the end

//        System.out.println(stack.pop());
        // If we remove from an empty stack
        // We will get and error

        System.out.println( stack );

        // Stack is a behavior (LIFO), not a specific structure.
        // We can implement a stack using:
        // 1. Arrays (fixed/dynamic size)
        // 2. Linked Lists



        // Using Deque (Double Ended Queue)
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(10);  // addFirst()
        deque.addFirst(9);
        deque.addLast(12);

        System.out.println( deque );

        System.out.println( deque.pop() );
        System.out.println( deque.removeFirst() );
        System.out.println( deque.removeLast() );

        System.out.println( deque );

    }
}

/*
    =========================
            STACK (LIFO)
    =========================
       TOP -> i   |   30   | 3
              ii  |   20   | 2
              iii |   10   | 1
    =========================

    1-2-3    - is the order in which they got in the stack
    i-ii-iii - is the order in which they will leave the stack

    this is known as "First in Last out(FILO)" or "Last in First Out(LIFO)"

    - push(40) → adds 40 on top
    - pop()    → removes 30 (last in)
    - peek()   → sees 30 (doesn’t remove)

    push means adding a new datatype at the top
    and pop means removes the topmost datatype from the top
 */











