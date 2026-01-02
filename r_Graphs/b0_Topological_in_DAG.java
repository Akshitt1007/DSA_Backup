package r_Graphs;
/*

        =========================================================
                 TOPOLOGICAL SORT — LAYMAN NOTES
        =========================================================

        1. BASIC IDEA (VERY IMPORTANT)
        ---------------------------------------------------------
        • In real life, some tasks must be done BEFORE others
        • This “before–after” relationship is called dependency
        • Topological Sort helps us find the CORRECT order

        Example:
        • Study DSA before Advanced Algorithms
        • Chop vegetables before cooking



        2. WHAT PROBLEM DOES IT SOLVE?
        ---------------------------------------------------------
        • Given many tasks with dependencies
        • We need to arrange them in a safe order
        • No task should be done before its prerequisite

        In simple words:
        • “Who comes first and who comes later?”



        3. HOW WE REPRESENT THIS (GRAPH IDEA)
        ---------------------------------------------------------
        • Each task is treated as a node
        • An arrow means dependency

        Arrow meaning:
        • A → B means A must be done before B



        4. TYPE OF GRAPH USED
        ---------------------------------------------------------
        • Directed graph (arrows exist)
        • No cycles allowed
        • Such a graph is called DAG
          (Directed Acyclic Graph)



        5. WHAT IS TOPOLOGICAL SORT?
        ---------------------------------------------------------
        • Topological Sort is arranging tasks in a straight line
        • Every task appears before the tasks that depend on it
        • It converts dependency chaos into clear order



        6. WHY TOPOLOGICAL SORT IS NEEDED
        ---------------------------------------------------------
        • To handle dependencies correctly
        • To avoid doing tasks in wrong order
        • To prevent logical errors and failures
        • To plan execution safely



        7. REAL LIFE EXAMPLES
        ---------------------------------------------------------
        A) Cooking:
           Buy → Cut → Cook → Eat

        B) Software Compilation:
           Helper File → Logic File → Main File

        C) College Courses:
           Basics → DSA → Advanced DSA → Placement Prep



        8. IMPORTANT RULE (CYCLE NOT ALLOWED)
        ---------------------------------------------------------
        • If a task depends on itself indirectly, it creates a cycle
        • Cycles cause infinite confusion
        • If cycle exists → Topological Sort NOT possible

        Example of cycle:
        • A → B → C → A



        9. KEY OBSERVATIONS
        ---------------------------------------------------------
        • Order matters
        • Multiple valid orders may exist
        • Used only when dependencies are present



        10. ONE-LINE EXAM DEFINITION
        ---------------------------------------------------------
        • Topological Sort is a method of ordering tasks such that
          each task is completed before the tasks that depend on it.

        =========================================================

 */
/*
        =========================================================
        WHY TOPOLOGICAL SORT IS NOT POSSIBLE IN CERTAIN GRAPHS
        =========================================================

        1. WHY NOT POSSIBLE IN UNDIRECTED GRAPHS
        ---------------------------------------------------------
        • Topological Sort is based on the idea of dependency
        • Dependency requires a clear direction (before → after)
        • Undirected graphs do not have direction

        In an undirected graph:
        • Edge A — B means A and B are just connected
        • It does NOT mean A comes before B or vice versa

        Because:
        • There is no "start" or "end"
        • No prerequisite relationship
        • No way to decide order logically

        Conclusion:
        • Without direction, "before" and "after" do not exist
        • Hence, Topological Sort is NOT possible



        2. WHY NOT POSSIBLE IN DIRECTED GRAPHS WITH CYCLES
        ---------------------------------------------------------
        • Topological Sort requires at least one starting node
        • A starting node must have no dependencies

        In a directed cycle:
        • A → B
        • B → C
        • C → A

        Meaning:
        • A depends on C
        • C depends on B
        • B depends on A

        Logical Problem:
        • No task can be done first
        • Every task is waiting for another

        Result:
        • Infinite waiting
        • No valid ordering exists



        3. KEY DIFFERENCE BETWEEN THE TWO CASES
        ---------------------------------------------------------
        • Undirected graph:
          - No direction
          - No dependency information

        • Directed cyclic graph:
          - Direction exists
          - But dependency is contradictory



        4. FINAL SUMMARY
        ---------------------------------------------------------
        • Topological Sort works ONLY when:
          - Direction exists (Directed)
          - No loops exist (Acyclic)

        • That is why it is defined ONLY for DAGs
          (Directed Acyclic Graphs)



        5. ONE-LINE EXAM ANSWERS
        ---------------------------------------------------------
        • Undirected graph:
          Topological Sort is not possible because there is no
          direction to define dependency order.

        • Directed cyclic graph:
          Topological Sort is not possible because cycles create
          circular dependencies, making ordering impossible.

        =========================================================

 */
