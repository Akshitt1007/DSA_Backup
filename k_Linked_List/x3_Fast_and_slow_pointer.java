/*

    FAST AND SLOW POINTER:
    (Floyd’s Cycle Detection Algorithm)

        We use Fast and Slow pointer approach when:
            1. Cycle Detection is needed
            2. Finding a node in a cycle

        Why Use Fast and Slow Pointers to Detect a Cycle?
            Imagine a linked list like a racetrack. Some racers go slow, some go fast. If there's a loop in the track,
            no matter how big it is, eventually, the fast racer will lap the slow one.

        Setup:
        We initialize two pointers at the head of the linked list:
            🐢 Slow Pointer – moves one step at a time.
            🐇 Fast Pointer – moves two steps at a time.

        Process:
        -> On each iteration:
            a. Slow goes one node ahead.
            b. Fast leaps two nodes ahead.
        -> If there is no cycle, the fast pointer will reach the end (null) and the loop stops.
        -> But if there is a cycle, the fast pointer will eventually circle around and meet the slow pointer inside the loop.

         Why?
         Because the fast pointer gains one step over the slow pointer each round.
         Eventually, like a comet catching a planet, it must collide with it — unless the path ends (i.e., no cycle).

         Two possibilities:
            1. [f][s] (fast is just behind slow)
                - then after the iteration
                - f will move 2 node and s will move 1 node
                - since [][][fs] they will meet

            2. [f][][s] (fast in one node behind slow)
                - then after 1 iteration
                - [][][f][s] this will be the case
                - and this is same as 1 possibility





 */
