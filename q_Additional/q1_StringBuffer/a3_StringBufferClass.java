package q_Additional.q1_StringBuffer;

public class a3_StringBufferClass {
    public static void main(String[] args) {

        // Constructor 1: simple object creation
        StringBuffer buffer = new StringBuffer();
        System.out.println( buffer.capacity() );

        buffer.append( "AkshitChoudhary ");
        buffer.append( " is good.");

        buffer.insert(16, "3rd year student");

//        buffer.reverse();

        buffer.replace(0, 6, "Abhinav");

        buffer.delete(0, 7);

        String str = buffer.toString();

        System.out.println( str );
        System.out.println( buffer.capacity() );

        // Constructor 2: We already pass a string in the buffer
        StringBuffer buffer_2 = new StringBuffer("Random String");
        System.out.println( buffer_2 );

        // Constructor 3: We specify the size of the buffer
        StringBuffer buffer_3 = new StringBuffer( 30 );
        System.out.println( buffer_3.capacity() );

    }
}
/*
    💡 Advantages of StringBuffer over String:

    1. Mutable
    2. More efficient
    3. Thread safety

               Threads, Processes, and Inconsistency — The Full Picture
	            ---------------------------------------------------------

    1. Processes

        Each running application (like Chrome, Spotify, VS Code) is a separate process.
        A process has its own memory and system resources.

        The CPU switches between processes extremely fast (thousands of times per second),
        giving the illusion that all apps are running simultaneously.

        In reality:
            - On a single-core CPU → only one process runs at a time, switching rapidly.
            - On a multi-core CPU → several processes can truly run at once (one per core).

        Analogy:
        → Each process is a separate building.
        → The operating system is the city planner deciding which building gets electricity (CPU time).

    2. Threads

        Each process can create multiple threads.
        Threads are smaller units of work that share the same memory and resources of that process.

        Example:
            → In Chrome:
                - One thread handles your open tab.
                - Another plays music.
                - Another keeps the UI responsive.

        Because threads share data, they make apps faster and smoother —
        but also introduce risks of data corruption when working simultaneously.

        Analogy:
        → The process is the restaurant.
        → Each thread is a cook in the kitchen.
        → They share the same fridge (memory), stove (CPU), and utensils (resources).

    3. Thread Inconsistency

        Threads inside the same application share variables and memory.
        If two threads modify the same data simultaneously, inconsistent or corrupted results may occur.

        Example:
            int count = 0;
            Thread t1 = new Thread(() -> count++);
            Thread t2 = new Thread(() -> count++);
            t1.start();
            t2.start();

        Possible result: count = 1 (not 2).
        → Both threads read the same old value before either wrote it back.
        → This is a Race Condition.

    4. StringBuilder vs StringBuffer

        StringBuilder:
            → Fast but not thread-safe.
            → Multiple threads can modify the same data simultaneously → inconsistency.

        StringBuffer:
            → Thread-safe due to "synchronized" methods.
            → Only one thread can modify the data at a time → consistent and safe.

        Example:
            StringBuilder sb = new StringBuilder();
            Thread t1 = new Thread(() -> sb.append("A"));
            Thread t2 = new Thread(() -> sb.append("B"));
        // Possible output: corrupted or incomplete data.

            StringBuffer safeSb = new StringBuffer();
            Thread t3 = new Thread(() -> safeSb.append("A"));
            Thread t4 = new Thread(() -> safeSb.append("B"));
        // Output always consistent because threads take turns (synchronized access).

    5. Thread Synchronization

        When one thread is working inside a synchronized block or method,
        it locks the object. Other threads must wait until the first thread finishes.

        Analogy:
        → One cook locks the fridge while using it.
        → Others must wait to avoid chaos.


        */
