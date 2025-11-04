package h_OOPS.Collection_Vector_Enum;

/*
    - The Java Collection Framework (JCF) is a unified architecture for representing and manipulating collections,
    making programming in Java more efficient and less error-prone.

    🌱 Core Idea:
         - A Collection in Java is an object that groups multiple elements into a single unit (such as a List, Set, or Queue).
         - The Collection Framework provides a standard set of interfaces, implementations (classes), and algorithms to work with these collections.
         - It eliminates the need for programmers to write their own data structures from scratch for common use cases.

    🔑 Key Concepts:
         - Common operations such as add, remove, contains, size, iteration, and sorting are standardized across data structures.
         - The Collection interface defines essential methods: add(), remove(), contains(), size(), iterator().
         - Concrete classes like ArrayList, LinkedList, HashSet, TreeSet, PriorityQueue, and others implement these interfaces.
         - Collections utility classes (like java.util.Collections and java.util.Arrays) provide algorithms for sorting, searching, and manipulating collections.

    ⚡ Advantages:
         - Reduces programming effort and improves code quality by providing reusable, tested implementations.
         - Promotes consistency and interoperability between different collection types.
 */

import h_OOPS.Interfacee.Extended_interface.A;

import java.util.*;

public class a1_Collection_Framework {
    public static void main(String[] args) {

        //  - List is an interface that acts as a parent type for various implementations.
        //  - ArrayList, LinkedList, and Stack are concrete (child) classes that implement the List interface.
        //    We create objects using the child classes, but we can reference them using the parent List type.

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> stack = new Stack<>();

        // Using the List reference allows you to use any implementation interchangeably within the same class.
        // This promotes flexibility and makes code easier to maintain and extend.
        // List is an interface implemented by ArrayList, LinkedList, Stack, Queue, and others.


        List<Integer> ListI = new ArrayList<>();
        ArrayList<Integer> ListII = new ArrayList<>();
//          List<Integer> arrayList → You are coding to the interface (List).
//              - This is more flexible → tomorrow we can switch to LinkedList<Integer> or Vector<Integer> without changing much code.

//          ArrayList<Integer> list → You are coding to the concrete class (ArrayList).
//              - Less flexible → if we want to change to LinkedList, you must rewrite the left-hand side.

    }
}
