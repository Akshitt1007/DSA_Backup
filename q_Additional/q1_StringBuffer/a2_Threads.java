package q_Additional.q1_StringBuffer;


/*

                Threads — The Soul of Concurrency
                ---------------------------------

    1. The Origin — One Thing at a Time

        - Early computers could only run one task at a time.
        - If a program waited for input or a file, the CPU sat idle.
        - This wasted processing power since the CPU wasn’t doing anything else.

    2. Multitasking — Doing More with Time

        - We introduced processes: each process = one running program with its own memory.
        - The OS switches between processes very fast, creating an illusion of parallel work.
        Example: Chrome, Spotify, VS Code — all processes sharing CPU time.

    3. Threads — Smaller Workers Inside a Process

        - A single process can have multiple threads.
        - Threads share the same memory and resources of their parent process.
        - Analogy → Process = Restaurant, Threads = Cooks sharing same kitchen and tools.
        - This allows different parts of a program to work simultaneously.

    4. Why Threads Are Needed

        Threads make programs faster and responsive by running tasks concurrently.

        Example:
        - One thread downloads data.
        - One updates progress.
        - One listens for user input.

        This prevents freezing or delays during long operations.

    5. How Threads Work

        - The OS creates threads and schedules their execution.
        - A scheduler decides which thread gets CPU time.
        - The CPU switches between them so quickly it seems like they run together.
        - On multi-core CPUs, multiple threads can literally run at the same time.

    6. The Risk — Shared Memory Problems

        - Threads share the same variables and memory.
        - If two threads modify the same data at once → inconsistent results.

        Example:
            int count = 0;
            Thread t1 = new Thread(() -> count++);
            Thread t2 = new Thread(() -> count++);

        Expected count = 2, but might get 1 due to both reading old value → Race Condition.
        Solution: Use synchronization (`synchronized`, locks, semaphores).

    7. Thread Lifecycle

        States of a thread:
        New → Runnable → Running → Waiting/Blocked → Terminated.
        Threads move between these depending on CPU time or waiting for tasks.

    8. The Big Picture

        Threads are mini-programs inside a program.
        They help achieve:
            - Multitasking
            - Responsiveness
            - Efficient CPU usage
        But they bring challenges: race conditions, deadlocks, and synchronization issues.
        High-level tools like Executors, ForkJoinPool, and async/await simplify thread handling.
 */

public class a2_Threads {
}
