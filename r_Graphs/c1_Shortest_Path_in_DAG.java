package r_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//  Shortest path in Directed Acyclic Graph
//  https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

public class c1_Shortest_Path_in_DAG {

    private static class Pair{
        int node;
        int weight;
        public Pair( int node, int weight ){
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int vertices = 6;

        int[][] path = {
                {0, 1, 2},
                {0, 4, 1},
                {4, 5, 4},
                {4, 2, 2},
                {1, 2, 3},
                {2, 3, 6},
                {5, 3, 1}
        };

        minStep(vertices, path);
    }

    /*
        SHORTEST PATH IN DIRECTED ACYCLIC GRAPH:
        ---------------------------------------

        (The diagram is given on the left side)

        Goal-> we to find the minimum steps to reach every node from the source node
        ----------------------------------------------------------------------------

        - If our source node is 6

        - then to reach 4 there are two ways
            -> first, direct 6 -> 4, steps = 2
            -> second, 6 -> 5 -> 4, steps = 4
            Therefore the min steps to reach 4 is 2.

        - then to reach 5 there is only one way
            -> Therefore the min steps to reach 5 is 3

        - to reach 0 there are two ways
            -> first from the 6 -> 4 -> 0, steps = 2 ( from 6-4) + 3 (from 4-0) = 5 steps
            -> second from 6 -> 5 -> 4 -> 0, steps = 3 + 1 + 3 = 7 steps
            Therefore min steps to reach 0 is thorough 6 -> 4 -> 0 that is 5 steps

        - to reach 2 there are two ways
          But we know that to reach 2 we have to first reach 4,
          and we already have the best min way to reach it.

          Therefore, to reach 2 is through 6 -> 4 -> 2, steps 3 steps

        - to reach 1 is again one way.
          and we know the min steps already
          through 6 -> 4 -> 0 -> 1, steps = 7 steps

        - to reach 3 there are 2 ways
            -> first from 6 -> 4 -> 0 -> 1 -> 3, steps = 2 + 3 + 2 + 1 = 8 steps
            -> second from 6 -> 4 -> 2 -> 3, steps = 2 + 1 + 3 = 6 steps
            Therefore second path is min, steps = 6 steps

        - int[] distance = [ 5, 7, 3, 6, 2, 3, 0 ]
                             0  1  2  3  4  5  6

            it is distance from 6 to each vertex

     */
    public static int minStep( int vertices, int[][] path ){

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // initializing the list
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        int m = path.length;

        /*               0         1       2         3       4        5        6
            matrix = [[0,1,2], [0,4,1], [4,5,4], [4,2,2], [1,2,3], [2,3,6], [5,3,1]]


            here index[0] = u, the node on which we are
                 index[1] = v, the node that u is connecting to
                 index[2] = weight, the weight between them

                     w
                 u ---> v

            here we to store this in Adj list,
            but we will be taking Pair, pair[0] -> neighbouring edges
                                        pair[1] -> weight
         */
        for( int i=0 ; i<m ; i++ ){

            int u = path[i][0];
            int v = path[i][1];
            int weight = path[i][2];

            adj.get(u).add( new Pair( v, weight ) );

            /*
            - here on adj[0] -> [ 1, 2 ]
            - meaning node 0 is connecting to node 1, with weight 2

            - In the end our list would look like :
                               0          1       2       3         4         5
                list = [[1,2],[4,1]], [[2,3]], [[3,6]], [[]], [[5,4],[2,2]], [[3,1]]


                This list means at list.get(0) means 0 is our current node
                and the nodes present are the edges wrt weight

                neighbour = list.get(0);

                means neighbour = [ [1,2], [4,1] ];

                - here 3 is empty because there is no edge to it
             */

        }

        // To keep chck of visited nodes
        boolean[] visited = new boolean[vertices];

        // To store the order
        Stack<Integer> stack = new Stack<>();

        // STEP 1:
        // - Store the order of the graph( using topological sort here)
        // - If the src is given then use that else we will go from 0

        // We will go to every node till it reached the end node
        // We are given a specific node
        // and there would be some node that will not be reachable which is fine
        for( int i=0 ; i<vertices; i++ ){
            if( !visited[i] ){
                DFS( adj, visited, i, stack );
            }
        }

        // when the above loop will over
        // we will the order in our stack

        // STEP 2:
        // - We will create a distance[] array to store the distance
        // - and mark all the value in distance[] to infinite

        int[] distance = new int[vertices];

        // assigning them to infinite
        for( int i=0; i<distance.length; i++ ){
            distance[i] = Integer.MAX_VALUE;
        }

        // starting from node 0 ( which we have taken as src here)
        // use the given src if provide
        distance[0] = 0;

        // - since we are at the starting node
        // - No steps is required to reach the node we are already on.

        while( !stack.isEmpty() ){

            // Pop the top element from the stack.
            // The stack stores nodes in reverse topological order
            // Popping ensures nodes are processed in correct topological sequence
            int u = stack.pop();

            // Since we get the node
            // we will get its adj nodes(neighbouring nodes)

            ArrayList<Pair> neighbour = adj.get(u);

            for( int i=0 ; i < neighbour.size(); i++ ){

                //    w
                // u ----> v
                int v = neighbour.get(i).node;
                int w = neighbour.get(i).weight;


                // We have the adj node
                // and weight between them


                // STEP 3: Relaxation of distances

                if( distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v] ){

                    distance[v] = distance[u] + w ;
                }
            }
        }


        // Print the distance array showing the shortest distance from the source to each node
        System.out.println(Arrays.toString( distance) );

        return -1;

    }

    public static void DFS( ArrayList<ArrayList<Pair>> adj, boolean[] visited, int node, Stack<Integer> stack  ){

        visited[node] = true;

        // To store is neighbour node
        // u -> v
        // u = node and v = what adj.get(node) holds
        ArrayList<Pair> neighbour = adj.get( node );

        for( int i=0 ; i < neighbour.size(); i++ ){

            // We will be getting whole pair
            // Therefore we have to store it in a pair also

//            Pair neighbourPair = neighbour.get(i);
//            int neighbourNode = neighbourPair.node;

            int neighbourNode = neighbour.get(i).node;

            if( !visited[neighbourNode] ){
                 DFS( adj, visited, neighbourNode, stack );
            }
        }

        stack.push( node );

    }
}
