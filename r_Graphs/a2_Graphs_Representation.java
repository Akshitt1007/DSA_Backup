package r_Graphs;


/*
              A
             / \
            B---C
            |   |
            D---E

    -----------------------------------------
    HOW GRAPH INPUT IS GENERALLY PROVIDED
    -----------------------------------------

    When solving graph problems (especially in coding),
    the question usually gives:

    1) Number of Nodes (N)
    2) Number of Edges (E)

       Example:
           N = 5
           E = 6

    3) Next E lines contain the edges:

           A - B
           A - C
           B - C
           B - D
           C - E
           D - E

    WHAT THIS MEANS

    * There are 5 nodes → {A, B, C, D, E}
    * There are 6 edges connecting them.
    * Since edges have no direction, this is
      an UNDIRECTED GRAPH.
 */


/*
    ========================================================
              STORING A GRAPH USING A 2D MATRIX
                 (Adjacency Matrix Explanation)
    ========================================================

    Suppose we have an UNDIRECTED GRAPH with nodes:
        1, 2, 3, 4

    And edges:
        1 - 2
        2 - 3
        3 - 4
        1 - 4


    --------------------------------------------------------
    HOW AN ADJACENCY MATRIX WORKS
    --------------------------------------------------------

    * We create a 2D matrix:   int adj[N+1][N+1];
    - N+1 because index starts from 0 and so that we would have index 5

    * If there is an edge between:
            u and v
      then we store:
            adj[u][v] = 1
            adj[v][u] = 1        (because it is undirected)

    --------------------------------------------------------
    EXAMPLE WITH EDGE 1 - 2
    --------------------------------------------------------

        1 - 2 exists, so:

            adj[1][2] = 1
            adj[2][1] = 1

    This means:
        - At row 1, column 2 → store 1
        - At row 2, column 1 → store 1

    Because both indicate that nodes 1 and 2 are connected.


    --------------------------------------------------------
    FINAL MATRIX FOR OUR GRAPH
    --------------------------------------------------------

        Nodes: 1, 2, 3, 4
        Edges: 1-2, 2-3, 3-4, 1-4

        Matrix (adj):

                1  2  3  4
            ----------------
        1 |    0  1  0  1
        2 |    1  0  1  0
        3 |    0  1  0  1
        4 |    1  0  1  0

    Meaning:
        adj[1][2] = 1  → 1 connected to 2
        adj[2][1] = 1  → 2 connected to 1
        adj[2][3] = 1  → 2 connected to 3
        adj[3][4] = 1  → 3 connected to 4
        adj[1][4] = 1  → 1 connected to 4

    --------------------------------------------------------
    NOTES:
    --------------------------------------------------------
    - Undirected graphs always store edges in BOTH directions.
    - If it were a directed graph:
            u -> v
      then we store ONLY:
            adj[u][v] = 1
      and DO NOT store:
            adj[v][u]

    - This Method of storing is not good since it will have TC of On(nxn)
    - Therefore we use this for small size graph
    - To overcome this we store Graph in a list
*/


/*
    ===========================================================
                STORING A GRAPH USING ARRAYLISTS
                    (Adjacency List Explanation)
    ===========================================================

    Suppose we have an UNDIRECTED GRAPH with nodes:
            1, 2, 3, 4

    And edges:
            1 - 2
            2 - 3
            3 - 4
            1 - 4


    -----------------------------------------------------------
    WHAT IS AN ADJACENCY LIST?
    -----------------------------------------------------------
    Instead of storing every connection in a 2D matrix,
    we store for each node...
            → a list of all the nodes it is connected to.

    * First we will run a loop till n (number of nodes) to make our desired number of List in adj list

                for( int i = 0, i <= n ; i++ ){
                  adj.add( new ArrayList<>() );
                }

    Example:
        Node 1 is connected to 2 and 4
        Node 2 is connected to 1 and 3
        Node 3 is connected to 2 and 4
        Node 4 is connected to 1 and 3


    -----------------------------------------------------------
    JAVA STRUCTURE:
    -----------------------------------------------------------

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        * adj.get(u) gives the list of all nodes connected to u
        * For an edge u - v (undirected):
                adj.get(u).add(v);
                adj.get(v).add(u);


    -----------------------------------------------------------
    HOW EDGE 1 - 2 IS STORED
    -----------------------------------------------------------

        Since 1 is connected to 2:
                adj.get(1).add(2);

        And 2 is connected to 1:
                adj.get(2).add(1);

        So adjacency list becomes:

            1 → [2]
            2 → [1]


    -----------------------------------------------------------
    FINAL ADJACENCY LIST FOR OUR GRAPH
    -----------------------------------------------------------

        Edges: 1-2, 2-3, 3-4, 1-4

        adj[1] = [2, 4]
        adj[2] = [1, 3]
        adj[3] = [2, 4]
        adj[4] = [1, 3]

    Which means:
        - 1 connected to 2 and 4
        - 2 connected to 1 and 3
        - 3 connected to 2 and 4
        - 4 connected to 1 and 3


    -----------------------------------------------------------
    NOTES:
    -----------------------------------------------------------
    - ArrayList adjacency list is very memory-efficient.
    - Perfect for sparse graphs.
    - For a directed graph (u → v), we only store:
            adj.get(u).add(v);
    - No need to add:
            adj.get(v).add(u);
*/

/*
    ==============================================================
                    WEIGHTED GRAPH USING ARRAYLIST
                    (Adjacency List Representation)
    ==============================================================

    Suppose we have 5 nodes:
            1, 2, 3, 4, 5

    And weighted edges:
            1 --(10)-- 2
            1 --(5)--- 3
            2 --(2)--- 4
            3 --(8)--- 4
            4 --(7)--- 5


    --------------------------------------------------------------
    HOW DO WE STORE WEIGHTS?
    --------------------------------------------------------------

    Since each edge has:
            (u) --weight--> (v)

    We cannot store only:
            ArrayList<Integer>

    Instead, we store PAIRS:

            (neighbor, weight)

    Therefore:
        ArrayList<ArrayList<Pair>> adj;

    Where each Pair contains:
            node → the connected node
            weight → weight of that edge


    --------------------------------------------------------------
    HOW EDGE 1 --10--> 2 IS STORED
    --------------------------------------------------------------

        adj.get(1).add(new Pair(2, 10));
        adj.get(2).add(new Pair(1, 10));     // undirected graph


    --------------------------------------------------------------
    FINAL ADJACENCY LIST (Weighted)
    --------------------------------------------------------------

    adj[1] = (2,10), (3,5)
    adj[2] = (1,10), (4,2)
    adj[3] = (1,5),  (4,8)
    adj[4] = (2,2),  (3,8), (5,7)
    adj[5] = (4,7)

    Meaning:
        - Node 1 connected to 2 with weight 10 and to 3 with weight 5
        - Node 2 connected to 1 and 4
        - and so on...


    --------------------------------------------------------------
    WHY WE USE THIS?
    --------------------------------------------------------------

    * Needed for Dijkstra's Algorithm
    * Needed for Prims, Bellman-Ford, etc.
    * Efficient for large weighted graphs
*/


public class a2_Graphs_Representation {
    public static void main(String[] args) {

    }
}
