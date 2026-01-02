package r_Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


//https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

/*
        Here we have to return the shortestPath through which we hava reached the endNode

            2       5
        1 ----- 2 ----- 5
        |       |      /
      1 |     4 |     / 1
        |       |    /
        4 ----- 3 --/
            3

        There to reach from 1 -> 5

        Path = 1 - 4 - 3 - 1
        Total weight = 6

 */
public class cq1_Shortest_Path_in_Weighted_undirected_graph {
    public static void main(String[] args) {
    }

    private class Pair{
        int node;
        int weight;
        public Pair( int weight, int node ){
            this.node = node;
            this.weight = weight;
        }
    }

    public List<Integer> shortestPath( int n, int m, int[][] edges ){

        // Step 1: Storing the edges in the form of adj List
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for( int i=0; i<=n; i++ ){
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
        int[] distance = new int[n+1];
        for( int i=1; i<n+1; i++ ){
            distance[i] = Integer.MAX_VALUE;
        }

        // Step 3:
        // To keep track of parent node
        // Here we will store the parent of the node
        // parent[5] = 3
        // means we go to node 5 through 3
        int[] parent = new int[n+1];
        for( int i=1; i<=n; i++ ){
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight );

        pq.add( new Pair(0, 1) );
        distance[1] = 0;

        while ( !pq.isEmpty() ){

            int u = pq.peek().node;
            pq.remove();

            ArrayList<Pair> xyz = adjList.get( u );

            for( int i=0; i<xyz.size(); i++ ){

                int v = xyz.get(i).node;
                int w = xyz.get(i).weight;

                if( distance[u] + w < distance[v] ){
                    distance[v] = distance[u] + w ;
                    pq.add( new Pair( distance[v], v) );

                    /*
                        This will now assign the parent of the node

                        Parent[] = 1, 2, 3, 4, 5

                        1.  for u = 1,
                            v = 2, 4
                            when we add (2) in pq
                            when add (4) in pq

                            we see the node 4 is coming from node 1
                            and node 2 is coming from 1

                            Therefore, parent[4] = 1

                            => parent[v] = u

                            parent[] = 1, 1, 3, 1, 5

                        2.  since pq = ( (1,4), (2,2) )
                            distance 1 < 2

                            u = 4
                            for u, v = 1, 3

                            we won't add 1 again in the pq
                            and when adding node 3 in pq

                            we will update its parent.
                            parent[v] = u

                            parent[3] = 4


                            Parent[] = 1, 1, 4, 1, 5


                        3.  In the end after the all the distance is stored

                            Parent[] = 1, 1, 4, 1, 3
                                       1  2  3  4  5

                            meaning 1 is coming from 1
                                    2 is coming from 1
                                    3 is coming from 4
                                    4 is coming from 1
                                    5 is coming from 3
                     */
                    parent[v] = u;
                }
            }
        }

        // If we are not able to reach the endPoint
        // meaning there is no possible path
        // Hence, we will direct return-1
        if( distance[n] == Integer.MAX_VALUE ){
            return List.of(-1);
        }


        // Storing the path through which we reached endPoint
        ArrayList<Integer> path = new ArrayList<>();

        int curr = n;

        // This while loop will run till we reached the src node
        // because the parent of starting node it itself
        while( parent[curr] != curr ){

            path.add(0, curr );
            curr = parent[curr];

        }
        /*
                         Parent[] = 1, 1, 4, 1, 3
                                    1  2  3  4  5

            Our endPoint is n
            ie. 5

            Therefore, to get the parent of 5 we will just fo parent[5]
            and store it and again repeat this.
         */

        // To add the src node
        path.add(0, 1 );

        // To add the total weight to reach the end Node
        path.add( 0, distance[n] );


        return path;
    }
}
