package r_Graphs;


/*
    ┌──────────────────────────────────────────────┐
    │        CYCLIC UNDIRECTED GRAPH (ASCII)       │
    └──────────────────────────────────────────────┘

    WHAT IS A CYCLE?

    - If we start from a node and come back to the **same node** again
      through a different path (without repeating nodes),
      then the graph contains a **cycle**.

               (0)
              /   \
             /     \
          (1)       (2)
           |         |
           |         |
          (3)       (4)
            \       /
             \     /
               (5)
                |
               (6)

        ADJACENCY LIST:
        ----------------
        0 : 1, 2
        1 : 0, 3
        2 : 0, 4
        3 : 1, 5
        4 : 2, 5
        5 : 3, 4, 6
        6 : 5

    CYCLE DETECTION USING BFS:

    - Start BFS from node 0
        → Adjacent nodes: 1 and 2

    - From node 1 → adjacent nodes = {0, 3}
      (skip 0 because that is the parent)

    - From node 2 → adjacent nodes = {0, 4}
      (skip 0 again)

    - Now we discover:
        Node 3 → connects to 5
        Node 4 → also connects to 5

    - ⚔️🔥 OBSERVATION (Key Insight)
      We reached node 5 by **two different paths**:
        Path A: 0 → 1 → 3 → 5
        Path B: 0 → 2 → 4 → 5

      If BFS or DFS reaches the **same node** from two
      different parents, that confirms a **cycle**.

    WHY THIS PROVES A CYCLE?

    - In an undirected graph, revisiting an already visited node
      that is **not your parent** means:
         → another path exists
         → the graph loops
         → cycle detected
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class x{
    int node;
    int parent;
    public x(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

public class a11_Detect_Cycle_in_Undirected_Graph_using_BFS {
    public static void main(String[] args) {

    }


    public static boolean CyclicCheck(int nodes, ArrayList<ArrayList<Integer>> edges ){

        boolean[] visited = new boolean[nodes];

        Queue<x> q = new LinkedList<>();

        q.add( new x(0, -1) );
        visited[0] = true;

        while( !q.isEmpty() ){

            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();

            ArrayList<Integer> neighbour = edges.get(node);

            for( int i=0 ; i<neighbour.size(); i++ ){

                int adj = neighbour.get(i);

                if( visited[adj] == false ){
                    q.add( new x(adj, node ) );
                    visited[adj] = true;
                }
                else if( parent != adj ){
                    return true;
                }
                /*
                    Here we will check whether if this is the node though we just came
                    - yes then we do nothing
                    - if no then there must a cycle somewhere in graph only because this node is visited before reached here
                 */
            }
        }

        return false;
    }
}

/*
     Initialize:

    visited = { false, false, false, false, false, false, false }
    Queue = empty

    Start BFS from node 0
    Visited[0] = true
    Queue = [(0, -1)]

--------------------------------------------------------------
    Step 1: process node 0
    Pop (0, -1)
    Neighbours: 1, 2

    - Adj = 1
        visited[1] == false → mark visited, push
        Queue = [(1, 0)]
        visited = { true, true, false, false, false, false, false }

    - Adj = 2
        visited[2] == false → mark visited, push
        Queue = [(1,0), (2,0)]
        visited = { true, true, true, false, false, false, false }

--------------------------------------------------------------
    Step 2: process node 1

    Pop (1, 0)
    Neighbours: 0, 3

    - Adj = 0
        visited[0] == true && parent != 0?
        parent = 0 → ignore

    - Adj = 3
        visited[3] == false → mark visited, push
        Queue = [(2,0), (3,1)]
        visited = { true, true, true, true, false, false, false }

--------------------------------------------------------------
    Step 3: process node 2

    Pop (2, 0)
    Neighbours: 0, 4

    - Adj = 0
        visited and parent = 0 → ignore

    - Adj = 4
        visited[4] == false → push
        Queue = [(3,1), (4,2)]
        visited = { true, true, true, true, true, false, false }

--------------------------------------------------------------
    Step 4: process node 3

    Pop (3, 1)
    Neighbours: 1, 5

    - Adj = 1
        visited and parent == 1 → ignore

    - Adj = 5
        visited[5] == false → push
        Queue = [(4,2), (5,3)]
        visited = { true, true, true, true, true, true, false }

--------------------------------------------------------------
    Step 5: process node 4

    Pop (4, 2)
    Neighbours: 2, 5

    - Adj = 2
        visited and parent == 2 → ignore

    - Adj = 5
        visited[5] == true and parent != 5
        parent of current node = 2

        adj (5) is NOT 2 → already visited but not parent → cycle detected

    CYCLE FOUND HERE

--------------------------------------------------------------
    Reason:
        3 → 5
        4 → 5

    Two different branches meet at node 5.

    Queue processing stops.
    Cycle confirmed.

 */