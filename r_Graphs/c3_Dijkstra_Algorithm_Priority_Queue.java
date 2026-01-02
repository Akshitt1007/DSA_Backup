package r_Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

/*
    Dijkstra_Algorithm:
        -> It can be used in any graphs to find the Shortest Path
        -> But it cannot be used in graphs that have: i. negative edge weight
                                                      ii. negative cycle


        - Dijkstra’s Algorithm finds the shortest distance from one starting node to every other node in a graph,
          when all edge weights are non-negative.

        - It works best of Undirected and Directed Graphs
        - Weighted graph other than unit weights

        - Not for negative weight graphs

    WHY NOT FOR NEGATIVE WEIGHTS GRAPH ?

        - Because Dijkstra works on a **Greedy Algorithm**.
        - In greedy once we get something we will finalize it and not change every again
        - and if anything contradict in future we will not change it

        - Same happens in Dijkstra Algo
        - Here we are using BFS meaning that we are moving level by levels
        - and every node that we visit would be itself the closet path
        - and we would be storing the shortest path as move forward

        But if in coming edges comes NEGATIVE weight?
        - then we won't be able to move back to change it
        - and we would be stuck in an infinite loop

                   -2
        eg:    1 ----- 2

            dis[] = [∞,∞]

            src = 0
            we don't need any steps to reach somewhere where we are already present

            dis[src] => dis[1] = 0

            now for node 2,    dist[1] + w < ∞
                                0 + -2 < ∞ ----> true
                                therefore, dis[2] = -2

            now node 2 have 1 as neighbouring node
            therefore, dist[2] + w < ∞
                         -2 + -2  < ∞ ------> true
                         again dist[1] = -4

            and we will be stuck in loop because the 1 will again chck for node 2 and 2 for 1.........


        - Dijkstra fails with negative edge weights because it greedily finalizes distances that may later be reduced, leading to incorrect results.
        Negative cycles require Bellman-Ford for detection.
 */
public class c3_Dijkstra_Algorithm_Priority_Queue {

    class Pair{
        int w;
        int node;
        public Pair(int w, int node ){
            this.node = node;
            this.w = w;
        }
    }

    public static void main(String[] args) {
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Step 1: Storing the edges in the form of adj List
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for( int i=0; i<V; i++ ){
            adjList.add( new ArrayList<>() );
        }

        for( int i=0; i<edges.length; i++ ){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adjList.get(u).add( new Pair(w, v) );
            adjList.get(v).add( new Pair(w, u) );
        }

        // Step 2:
        // Initializing the distance array and marking them with ∞
        int[] distance = new int[V];

        for( int i=0; i<V; i++ ){
            distance[i] = Integer.MAX_VALUE;
        }


        // Step 3:
        // We will do this just like BFS
        // But instead of a Queue we will take PriorityQueue
        // Because it will give us the shortest path node first, top of the queue when doing the pop();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w );


        // Marking the starting node as 0
        distance[src] = 0;

        pq.add( new Pair(0,src) );

        while( pq.size() != 0 ){

            int u = pq.peek().node;
            pq.remove();

            // Adding the neighbouring node for the node we just popped.
            ArrayList<Pair> list = adjList.get(u);

            for( int i=0 ; i<list.size(); i++ ){

                int v = list.get(i).node;
                int edgeW = list.get(i).w;

                // Step 4:
                // chck if the distance of that neighbouring node is less than the current node + w
                // if yes, means we have reached through a short path
                // and update it in the distance array
                // and add it in the Queue so that we can work on the other neighbouring node connected to it
                if( distance[u] + edgeW < distance[v] ){
                    distance[v] = distance[u] + edgeW;
                    pq.add( new Pair( distance[v], v) );
                }
            }

        }

        // returning the distance array
        return distance;
    }
}

/*
        Implementation of DIJKSTRA ALGORITHM

        in DIJKSTRA ALGORITHM we can use to data structures to hold the node value
            i. using PriorityQueue
            ii. using Sets.

        -> both the datasets uses almost same TC so its doesn't matter which to use
           because in the Set it sure removes the duplicate node which might sounds good but when we are removing the duplicate
           the sets uses .erasure() which takes log(n) times
           so its matter which to use, both are correct and same

        1. A Priority Queue (Min-Heap):
            - Always keeps the smallest distance element on top
            - Extract-min in O(log V)

            So instead of searching for the smallest,


        Why we need the smallest element on the top and not like in any other queue we just use the neighbouring node that comes first?

        -> because the dijkstra algorithm is a greedy algo, Dijkstra finalizes a node when it is extracted with the minimum distance from the priority queue.
        -> Therefore, we must ensure that the node we are taking should be the smallest among all the other node present in the queue
        -> PQ saves our time, instead of searching for the smallest node
        -> PQ gives the smallest node w on the top
        -> since we get the node that have the smallest w, therefore we know we should work with this rather than the other big weight

        -> If we randomly take neighbours (like BFS or a normal queue):
        -> we may reach a node through a longer path first
        -> later, a shorter path might exist
        -> but Dijkstra will not go back and fix it

        That's why our PQ is made in form of ( weight, node) and not ( node, weight)

        -> If we put (node, weight) pq will chck for which node is smallest which is wrong because they are just numbering
        -> by putting ( weight,node) pq will chck for which weight is smallest to work with first
 */

/*
        WORKING:


 */
