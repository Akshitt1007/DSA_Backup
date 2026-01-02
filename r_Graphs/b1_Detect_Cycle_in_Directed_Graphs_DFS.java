package r_Graphs;
/*
             DIRECTED GRAPHS

        (1)  --->  (2)  --->  (3)  --->  (4)
                    ^          |          |
                    |          v          v
                   (8)        (7)  --->  (5)  --->  (6)
                  /  ^\
                v/     \
               (9) --> (10)


        EDGE LIST (for clarity):
        ------------------------
            1  -> 2
            2  -> 3
            3  -> 4
            3  -> 7
            4  -> 5
            5  -> 6
            7  -> 5
            8  -> 2
            8  -> 9
            9  -> 10
            10 -> 8

        - Here there is no cycle in 3 - 4 - 5 - 7
        - since we cannot reach any index again
        - the only cycle present here is: 8 - 9 - 10

 */
/*
    DIRECTED GRAPH – CYCLE DETECTION USING DFS
    ----------------------------------------

        (1)  --->  (2)  --->  (3)  --->  (4)
                        ^          |          |
                        |          v          v
                       (8)        (7)  --->  (5)  --->  (6)
                      /  ^ \
                    v/     \
                   (9) ---> (10)


    HOW TO CHECK CYCLE IN A DIRECTED GRAPH
    -------------------------------------

    We use TWO boolean arrays:

    1) visited[]       → marks nodes that are visited at least once
    2) pathVisited[]   → marks nodes currently in the DFS recursion path


    STEP-BY-STEP EXPLANATION
    -----------------------

    • Start DFS traversal.

    • When visiting a node:
        visited[node] = true
        pathVisited[node] = true


    PATH 1: 3 → 4 → 5 → 6
    --------------------
    • All nodes (3,4,5,6) are marked:
        visited = true
        pathVisited = true

    • Node 6 has no outgoing edges.
      So we backtrack.

    • While backtracking:
        pathVisited[6] = false
        pathVisited[5] = false
        pathVisited[4] = false

    • Node 3 remains visited but is no longer in the current path.


    PATH 2: 3 → 7 → 5
    -----------------
    • Node 5 is already visited,
      BUT pathVisited[5] == false

    • This means:
        → 5 was visited in some previous path
        → NOT part of the current DFS path
        → NO cycle here

    • So we safely continue.


    PATH 3 (IMPORTANT): 8 → 9 → 10 → 8
    ----------------------------------
    • While traversing:
        visited[8]  = true
        pathVisited[8] = true
        visited[9]  = true
        pathVisited[9] = true
        visited[10] = true
        pathVisited[10] = true

    • From node 10, there is an edge back to 8.

    • Now we check:
        visited[8] == true
        pathVisited[8] == true

    • This means:
        → Node 8 is revisited in the SAME DFS path
        → A BACK EDGE is found
        → CYCLE DETECTED


    KEY CONDITION FOR CYCLE (DIRECTED GRAPH)
    ----------------------------------------
    If (visited[node] == true AND pathVisited[node] == true)
        → Cycle exists


    FINAL NOTE
    ----------
    • visited[] prevents reprocessing nodes
    • pathVisited[] helps detect back edges
    • This method works ONLY for directed graphs
*/


import java.util.ArrayList;

public class b1_Detect_Cycle_in_Directed_Graphs_DFS {
    public static void main(String[] args) {

    }

    public static boolean DirectedGraph(int V, ArrayList<ArrayList<Integer>> adj ){

        boolean[] visited = new boolean[V];

        boolean[] pathVisited = new boolean[V];

        for( int i=0 ; i<V; i++ ){
            if( !visited[i] ){
                boolean chck = DFS(adj, visited, pathVisited, i );
                if( chck ){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean DFS( ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node ){

        visited[node] = true;

        pathVisited[node] = true;

        ArrayList<Integer> neighbour = new ArrayList<>( adj.get(node) );

        for( int i=0 ; i<neighbour.size(); i++ ){

            int neighbourNode = neighbour.get(i);

            // If not visited, explore
            if( !visited[neighbourNode] ){

                // We store the DFS result in `chck` because a cycle might be found
                // in deeper recursive calls.
                // If a cycle is detected in the future DFS path,
                // the recursive call will return true.
                // While backtracking (unwinding the recursion stack),
                // we immediately return true from here
                // instead of continuing further traversal.
                boolean chck = DFS( adj, visited, pathVisited, neighbourNode );
                if( chck ){
                    return true;
                }
            }
            // If visited AND still in current path → cycle
            else if( visited[neighbourNode] && pathVisited[neighbourNode] ){
                return true;
            }
        }

        // Backtracking
        pathVisited[node] = false;

        return false;
    }
}
