package r_Graphs;

/*
        ** INTRODUCTION TO GRAPHS **
      ================================

    Directed Graph (Edges have direction)                       Undirected Graph (Edges have no direction)

        A ----> B                                                   A ---- B
        ^       |                                                   |      |
        |       v                                                   |      |
        D <---- C                                                   D ---- C

        Meaning:                                                    Meaning:
        A → B                                                       A - B
        B → C                                                       B - C
        C → D                                                       C - D
        D → A                                                       D - A

    * The alphabets A, B, C, D are called **NODES / VERTICES**.
    * Total nodes here = 4.
    * The connecting lines/arrows between nodes are called **EDGES**.


    * In Undirected Graphs:
      - The edges have **no direction**.
      - If A is connected to B,
        then B is also connected to A (A ↔ B).

    * In Directed Graphs:
      - Edges have **one-way direction**.
      - If an arrow goes from A → B,
        there is **no flow from B → A** unless another arrow exists.


            ** CYCLES IN GRAPHS **
        ================================

                    (Root)
                       1
                     /   \
                   2       3
                 /  \     /  \
                4    5   6    7


    - This above structure is also a GRAPH.
    - A Graph does not mean it always have a cycle in it
    - Every tree is a graph,
      but every graph is not necessarily a tree.

    * If we start from a node and reach back to it
    * This means there is cycle in the graph
    * if there is even a single cycle present then the graph is named as **CYCLE UNDIRECTED GRAPH**

        A ----> B
        ^       |
        |       v
        D ----> C

    - Here it looks like a cycle
    - when we start from node A but we can't reach it back
    - we can only move in the flow the arrows are given
    - This is a ** ACYCLIC DIRECTED GRAPH **


            ** Path **
       =====================

    * A path is just a sequence of nodes, where:
    * Each node is connected to the next one
    * No teleportation, no cheating, only edges
    * eg:
        A ----> B
        ^       |
        |       v
        D ----> C

        path - ABC  = This is correct path since
        path - ABCB  = This is incorrect path since the node B is appearing twice
        path - DCBA  = This is also incorrect because how will we reach from C to B ( NO connectivity)

    * Therefore, for the path the adjacent node must have a connection


            ** DEGREE in a graph **
        ================================

    # DEGREE IN UNDIRECTED GRAPH

              A
             / \
            B---C
            |   |
            D---E

    * Edges: A-B, A-C, B-C, B-D, C-E, D-E

    * Degree = number of edges incident to the vertex (each edge counts once)

    Degrees:
    deg(A) = 2   // edges: A-B, A-C
    deg(B) = 3   // edges: B-A, B-C, B-D
    deg(C) = 3   // edges: C-A, C-B, C-E
    deg(D) = 2   // edges: D-B, D-E
    deg(E) = 2   // edges: E-C, E-D

    * For undirected graphs, every edge contributes 1 to the degree of each endpoint.
    * Sum of all degrees = 2 * (number of edges).


    # DEGREE IN DIRECTED GRAPH

            A ---> B
            ^      |
            |      v
            D <--- C ---> E

    Directed edges:
    A->B, B->C, C->E, C->D, D->A

    Definitions:
    - outDeg(v) = number of edges going out of v
    - inDeg(v)  = number of edges coming into v

    Compute for each vertex:
    A: outDeg(A) = 1   // A->B
       inDeg(A)  = 1   // D->A

    B: outDeg(B) = 1   // B->C
       inDeg(B)  = 1   // A->B

    C: outDeg(C) = 2   // C->E, C->D
       inDeg(C)  = 1   // B->C

    D: outDeg(D) = 1   // D->A
       inDeg(D)  = 1   // C->D

    E: outDeg(E) = 0
       inDeg(E)  = 1   // C->E

    Notes:
    - In directed graphs, edges are ordered pairs (u -> v).
    - Sum of all out-degrees = Sum of all in-degrees = number of edges.

 */


public class a1_Basics {
    public static void main(String[] args) {

    }
}

