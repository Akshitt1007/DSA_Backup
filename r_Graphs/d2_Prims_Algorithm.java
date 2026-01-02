package r_Graphs;


//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
                                    PRIM'S ALGORITHM

    Given:
        - A weighted, connected, undirected graph
        - Source node = 1

    Key Rule of Prim’s Algorithm:
        - At every step, pick the MINIMUM WEIGHT edge
          that connects ANY visited node to ANY unvisited node
        - NOT just edges from the last added node

    Step 1:
        - Start from node 1
        - Mark 1 as visited
        - Push all edges from 1 into Priority Queue (PQ)

    Step 2:
        - Pick smallest edge from PQ → (1 → 4)
        - Add edge to MST
        - Mark 4 as visited
        - sum = 1
        - MST = [1,4]

    Step 3:
        - PQ contains edges from visited nodes (1 and 4)
        - Smallest valid edge is (1 → 2), not (4 → 2)
        - Reason: PQ compares ALL candidate edges
        - Add (1 → 2)
        - sum = 3
        - MST = [1,4], [1,2]

    Step 4:
        - From all visited nodes (1,4,2),
          smallest edge to unvisited node is (2 → 3)
        - Add (2 → 3)
        - sum = 6
        - MST = [1,4], [1,2], [2,3]

    Step 5:
        - Candidates to reach 6:
            (2 → 6) weight = 7
            (3 → 6) weight = 8
        - Pick smaller → (2 → 6)
        - sum = 13
        - MST = [1,4], [1,2], [2,3], [2,6]

    Step 6:
        - Node 5 is unvisited
        - Possible edges:
            (1 → 5)
            (4 → 5)
        - Pick smaller → (1 → 5)
        - sum = 17

    Result:
        - All nodes visited
        - Edges = n - 1
        - No cycles
        - MST formed

    IMPORTANT CLARIFICATION:
        - Prim’s algorithm chooses the globally minimum edge
          from the visited set, not just from the current node
*/

public class d2_Prims_Algorithm {
    public static void main(String[] args){
    }

    class tuple{
        int w;
        int node;
        int parent;
        public tuple( int w, int node, int parent ){
            this.w = w;
            this.node = node;
            this.parent = parent;
        }
    }

    class pair{
        int u;
        int weight;
        public pair( int u, int weight ){
            this.u = u;
            this.weight = weight;
        }
    }
    public int spanningTree(int V, int[][] edges) {

        // 1. Storing edges in the form of AdjList
        ArrayList<ArrayList<pair>> adjList = new ArrayList<>();
        for( int i=0; i<V; i++ ){
            adjList.add( new ArrayList<>() );
        }
        for( int i=0; i<edges.length; i++ ){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adjList.get(u).add( new pair(v, w ));
            adjList.get(v).add( new pair(u, w ));
        }

        // 2. boolean array to keep the track of element we have visited
        boolean[] visited = new boolean[V];

        // 3. This is to store the graph
        ArrayList<int[]> mst = new ArrayList<>();

        // 4. PriorityQueue so that we can get the least weight first
        PriorityQueue<tuple> pq = new PriorityQueue<>( (a, b) -> a.w - b.w );

        // 5. adding the src element we are starting from
        pq.add( new tuple( 0,0,-1) );

        // 6. to keep the track of the sum of minimum spanning tree
        int sum = 0;

        while( !pq.isEmpty() ){

            int w = pq.peek().w;
            int node = pq.peek().node;
            int parent = pq.peek().parent;

            pq.remove();

            /*
            if( !visited[node ] ){
                sum = sum + w;
                visited[node] = true;
                mst.add( new int[]{parent, node} );
            }


                        IMPORTANT NOTE: Why we should NOT add neighbors


        if the current node is already visited

        Problem situation:
            - In Prim’s algorithm, we use a PriorityQueue (min-heap)
            - The same node can be pushed into the PQ multiple times
              with different weights

            Example:
            - Node 2 is first added with weight = 10
            - Later, node 2 is added again with weight = 3

            PQ now contains:
                (10, 2)
                (3, 2)

        What happens when we pop from PQ?

            - We pop (3, 2) first
            - Mark node 2 as visited
            - Add its neighbors to the PQ

        Later:
            - We pop (10, 2)
            - But node 2 is ALREADY visited

        If we still process its neighbors:
            - We will again push neighbors of node 2 into PQ
            - This creates:
                - duplicate entries
                - unnecessary PQ growth
                - extra comparisons and removals

        Correct approach:
            - As soon as we pop a node from PQ
            - If it is already visited:
                → skip it completely
                → do NOT add its neighbors
*/


            if (visited[node]) continue;
/*
        This ensures:
            - Each node’s neighbors are added only once
            - PriorityQueue stays small
            - Algorithm remains efficient
*/
            ArrayList<pair> xyz = adjList.get( node );

            for( int i=0; i<xyz.size(); i++ ){

                int v = xyz.get(i).u;
                int weight = xyz.get(i).weight;

                if( !visited[v] ){
                    pq.add( new tuple( weight, v, node) );
                }

            }
        }

        return sum;
    }
}
/*
        DETAILED DRY RUN OF PRIM’S ALGORITHM
        (with Priority Queue state at every step)

    Given:
        Graph as shown in diagram
        Source node = 1

    Notation used:
        PQ entry = (weight, node, parent)
        MST edge = parent -> node

    ----------------------------------------------------

    INITIAL STATE:

        visited = [false for all nodes]
        sum = 0
        MST = []

        PQ = []
        Add source:
            PQ.add( (0, 1, -1) )

        PQ:
            [(0,1,-1)]

    ----------------------------------------------------

    STEP 1: poll from PQ

        poll() → (0,1,-1)

        visited[1] = true
        sum += 0

        MST unchanged (parent = -1)

        Add neighbors of 1 to PQ:
            (1 → 4, w=1)
            (1 → 2, w=2)
            (1 → 5, w=4)

        PQ now:
            [(1,4,1), (2,2,1), (4,5,1)]

    ----------------------------------------------------

    STEP 2: poll from PQ

        poll() → (1,4,1)

        visited[4] = true
        sum = 1

        MST:
            [1,4]

        Add neighbors of 4:
            (4 → 1) → skipped (visited)
            (4 → 2, w=3)
            (4 → 5, w=5)
            (4 → 3, w=6)

        PQ now:
            [(2,2,1), (3,2,4), (4,5,1), (5,5,4), (6,3,4)]

    ----------------------------------------------------

    STEP 3: poll from PQ

        poll() → (2,2,1)

        visited[2] = true
        sum = 3

        MST:
            [1,4], [1,2]

        Add neighbors of 2:
            (2 → 1) → skipped
            (2 → 4) → skipped
            (2 → 3, w=3)
            (2 → 6, w=7)

        PQ now:
            [(3,2,4), (3,3,2), (4,5,1),
             (5,5,4), (6,3,4), (7,6,2)]

    ----------------------------------------------------

    STEP 4: poll from PQ

        poll() → (3,2,4)

        Node 2 is already visited
        → SKIP (do nothing)

        PQ now:
            [(3,3,2), (4,5,1),
             (5,5,4), (6,3,4), (7,6,2)]

    ----------------------------------------------------

    STEP 5: poll from PQ

        poll() → (3,3,2)

        visited[3] = true
        sum = 6

        MST:
            [1,4], [1,2], [2,3]

        Add neighbors of 3:
            (3 → 4) → skipped
            (3 → 2) → skipped
            (3 → 6, w=8)

        PQ now:
            [(4,5,1), (5,5,4),
             (6,3,4), (7,6,2), (8,6,3)]

    ----------------------------------------------------

    STEP 6: poll from PQ

        poll() → (4,5,1)

        visited[5] = true
        sum = 10

        MST:
            [1,4], [1,2], [2,3], [1,5]

        Add neighbors of 5:
            (5 → 1) → skipped
            (5 → 4) → skipped

        PQ now:
            [(5,5,4), (6,3,4),
             (7,6,2), (8,6,3)]

    ----------------------------------------------------

    STEP 7: poll from PQ

        poll() → (5,5,4)

        Node 5 already visited
        → SKIP

        PQ now:
            [(6,3,4), (7,6,2), (8,6,3)]

    ----------------------------------------------------

    STEP 8: poll from PQ

        poll() → (6,3,4)

        Node 3 already visited
        → SKIP

        PQ now:
            [(7,6,2), (8,6,3)]

    ----------------------------------------------------

    STEP 9: poll from PQ

        poll() → (7,6,2)

        visited[6] = true
        sum = 17

        MST:
            [1,4], [1,2], [2,3], [1,5], [2,6]

        All nodes visited → STOP

    ----------------------------------------------------

    FINAL RESULT:

        MST edges:
            1 → 4
            1 → 2
            2 → 3
            1 → 5
            2 → 6

        Total MST weight = 17

    ----------------------------------------------------

    KEY OBSERVATIONS:

        - PQ contains duplicate nodes with different weights
        - Only the FIRST (minimum) time a node is polled matters
        - visited[] prevents cycles
        - Prim’s chooses global minimum edge from visited set
*/

