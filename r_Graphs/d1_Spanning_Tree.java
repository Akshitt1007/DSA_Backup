package r_Graphs;

/*
                        SPANNING TREE

        - A spanning tree is a graph that has n nodes and exactly (n - 1) edges
        - Every node is reachable from every other node
        - There is exactly ONE unique path between any two nodes
        - A spanning tree contains NO cycles

        ---------------------------------------------------------
        Why only (n - 1) edges?

            - To connect two nodes, we need only 1 edge
              1 ------ 2        nodes = 2, edges = 1

            - To connect three nodes:
              1 ------ 2 ------ 3
              nodes = 3, edges = 2

            - Every time we add a new node to a connected structure,
              we need only ONE edge to connect it

            - Therefore:
              n nodes → minimum edges needed = (n - 1)

        ---------------------------------------------------------
        Why NOT n edges?

            - If we add one extra edge after connecting all nodes,
              it must connect two already-connected nodes

            - Example:
                  1 ----- 2
                  |       |
                  ---------
              nodes = 3, edges = 3

            - This creates a cycle

            - Because of the cycle:
                - There are multiple paths between nodes
                  1 → 2 → 3
                  1 → 3 (direct)

            - Cycles break the definition of a tree

        Therefore:
            - n nodes + n edges ⇒ at least one cycle
            - A graph with cycles cannot be a spanning tree
*/
/*
                    MINIMUM SPANNING TREE

        On the right, we have a connected graph with
        - 6 nodes
        - 10 edges

        There to create a spanning tree from it,
        we have to remove 5 edges

        There on remove 5 edges we get 3 possible Spanning tree

        1. first spanning tree have an edge weight = 23
        2. second spanning tree have an edge weight = 21
        3. third spanning tree have an edge weight = 15


        Therefore, the spanning tree with the least edges weight is known as Minimum spanning tree

        ---------------------------------------------------------
        To find out the Minimum Spanning Tree, we have 2 Algorithm

            1. Prim's Algorithm

            2. Kruskal Algorithm
                - in order to under kruskal we have to understand disjoint set.

 */

