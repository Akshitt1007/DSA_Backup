package r_Graphs;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
/*
                Bellman Ford Algorithm

        - It is also used to find the shortest path from a given src to a dst
        - Where it has more TC as compared too Dijkstra
        - So we prefer this over Dijkstra When there graphs have 1. Negative edges
                                                                 2. Negative cycle weight

 */
/*
                Implementation:

                           0  1  2  3  4  5
        int[] distance = [ 0, ∞, ∞, ∞, ∞, ∞ ]

                     u  v  wt
        adjList = [ [3, 2, 6],
                    [5, 3, 1],
                    [0, 1, 5],
                    [1, 5, -3],
                    [1, 2, -2],
                    [3, 4, -1],
                    [2, 4, 3] ]

        Steps to find the Shortest Path in a negative weight graph

            1. Relax all Edges ** n-1 ** times sequentially
            2. Relaxation: If while moving from node u to node v with edge weight w,
                           we find a cheaper path to reach v, then we update the distance.

                            Condition:
                                dis[u] + w < dis[v]

                            Where:
                                u = source node (we are coming from)
                                v = destination node (we are going to)
                                w = weight of the edge u → v

                            Initially, dis[v] = ∞ because no path to v is known.
                            When a path through u is found:
                                dis[u] + w < ∞
                            So the new shortest known path to v becomes via u.
 */
/*
        Why n-1 Iterations only ?


 */
public class c4_Bellman_Ford_Algorithm {
    public static void main(String[] args) {

    }

    // Solving Directly with int[][]
    public int[] bellmanFord_II(int V, int[][] edges, int src) {

        int[] distance = new int[V];

        // Step 1: Initialize distances
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < edges.length; j++) {

                int u  = edges[j][0];
                int v  = edges[j][1];
                int wt = edges[j][2];

                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {

                    distance[v] = distance[u] + wt;
                }
            }
        }

        // Step 3: Check for negative cycle
        for (int j = 0; j < edges.length; j++) {

            int u  = edges[j][0];
            int v  = edges[j][1];
            int wt = edges[j][2];

            if (distance[u] != Integer.MAX_VALUE &&distance[u] + wt < distance[v]) {

                return new int[]{-1}; // Negative cycle exists
            }
        }

        return distance;
    }

}
/*
    Bellman–Ford Algorithm Dry Run
    ----------------------------------------------

    Nodes:
        0   1   2   3   4   5

    Initial distance array:
        distance = [ 0, ∞, ∞, ∞, ∞, ∞ ]

    Edge List (u, v, wt):
        [3, 2, 6]
        [5, 3, 1]
        [0, 1, 5]
        [1, 5, -3]
        [1, 2, -2]
        [3, 4, -1]
        [2, 4, 3]

    Total vertices = 6
    Total relaxations = V - 1 = 5


    ------------------------------------------------
    Iteration 1:
    ------------------------------------------------

        Edge 3 → 2 (wt = 6)
            dis[3] = ∞
            ∞ + 6 = ∞
            ∞ < ∞ → false
            No update

        Edge 5 → 3 (wt = 1)
            dis[5] = ∞
            ∞ + 1 = ∞
            ∞ < ∞ → false
            No update

        Edge 0 → 1 (wt = 5)
            dis[0] = 0
            0 + 5 = 5 < ∞
            Update: dis[1] = 5

        Edge 1 → 5 (wt = -3)
            dis[1] = 5
            5 + (-3) = 2 < ∞
            Update: dis[5] = 2

        Edge 1 → 2 (wt = -2)
            dis[1] = 5
            5 + (-2) = 3 < ∞
            Update: dis[2] = 3

        Edge 3 → 4 (wt = -1)
            dis[3] = ∞
            ∞ + (-1) = ∞
            ∞ < ∞ → false
            No update

        Edge 2 → 4 (wt = 3)
            dis[2] = 3
            3 + 3 = 6 < ∞
            Update: dis[4] = 6

        Distance after Iteration 1:
            [ 0, 5, 3, ∞, 6, 2 ]


    ------------------------------------------------
    Iteration 2:
    ------------------------------------------------

        Edge 3 → 2 (wt = 6)
            dis[3] = ∞
            ∞ + 6 = ∞
            No update

        Edge 5 → 3 (wt = 1)
            dis[5] = 2
            2 + 1 = 3 < ∞
            Update: dis[3] = 3

        Edge 0 → 1 (wt = 5)
            0 + 5 = 5 == dis[1]
            No update

        Edge 1 → 5 (wt = -3)
            5 + (-3) = 2 == dis[5]
            No update

        Edge 1 → 2 (wt = -2)
            5 + (-2) = 3 == dis[2]
            No update

        Edge 3 → 4 (wt = -1)
            dis[3] = 3
            3 + (-1) = 2 < 6
            Update: dis[4] = 2

        Edge 2 → 4 (wt = 3)
            3 + 3 = 6 > 2
            No update

        Distance after Iteration 2:
            [ 0, 5, 3, 3, 2, 2 ]


    ------------------------------------------------
    Iteration 3:
    ------------------------------------------------

        Edge 3 → 2 (wt = 6)
            3 + 6 = 9 > 3
            No update

        Edge 5 → 3 (wt = 1)
            2 + 1 = 3 == dis[3]
            No update

        Edge 0 → 1 (wt = 5)
            0 + 5 = 5 == dis[1]
            No update

        Edge 1 → 5 (wt = -3)
            5 + (-3) = 2 == dis[5]
            No update

        Edge 1 → 2 (wt = -2)
            5 + (-2) = 3 == dis[2]
            No update

        Edge 3 → 4 (wt = -1)
            3 + (-1) = 2 == dis[4]
            No update

        Edge 2 → 4 (wt = 3)
            3 + 3 = 6 > 2
            No update

        Distance after Iteration 3:
            [ 0, 5, 3, 3, 2, 2 ]


    ------------------------------------------------
    Iteration 4:
    ------------------------------------------------

        No edge can be relaxed.
        All dis[u] + w ≥ dis[v].

        Distance remains:
            [ 0, 5, 3, 3, 2, 2 ]


    ------------------------------------------------
    Iteration 5:
    ------------------------------------------------

        No relaxation possible.
        Shortest paths are finalized.

        Distance remains:
            [ 0, 5, 3, 3, 2, 2 ]


    ------------------------------------------------
    Final Result:
    ------------------------------------------------

        Shortest distances from source node 0:
            Node:     0   1   2   3   4   5
            Distance: 0   5   3   3   2   2


    Key Note:
        If dis[u] = ∞, then dis[u] + w = ∞.
        Hence, edges starting from unreachable nodes
        cannot produce a valid relaxation.
*/
