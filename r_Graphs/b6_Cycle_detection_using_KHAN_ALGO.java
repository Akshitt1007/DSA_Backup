package r_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class b6_Cycle_detection_using_KHAN_ALGO {
    public static void main(String[] args) {

    }

    public static boolean Kahn_Algorithm(int vertices, ArrayList<ArrayList<Integer>> adj ){

        int[] inDegree = new int[vertices];

        // Step 1:
        // Just do dry run you'll know how the indegree is getting stored
        for( int i=0 ; i<vertices; i++ ){

            ArrayList<Integer> neighbour = adj.get(i);

            for( int u = 0 ; u < neighbour.size(); u++ ){

                int v = neighbour.get(u);

                inDegree[v] = inDegree[v] + 1;
            }
        }

        // Step 2:
        // This is to store that node that have 0 inDegree
        Queue<Integer> q = new LinkedList<>();

        // Storing element with 0 inDegree
        for( int i=0 ; i < vertices; i++ ){

            if( inDegree[i] == 0 ){
                q.add( i );
            }
        }

        // Step 3:
        // Removing the node that have 0 inDegree
        // and subtracting that inDegree from its neighbour
        // if  2 <----- 4 ----> 1
        // inDegree for 2 and 1: 1
        // and after removing 4 the
        // 2          1  these node would be left alone and have 0 inDegree
        // and we will again remove them

        ArrayList<Integer> order = new ArrayList<>();

        while( !q.isEmpty() ){

            int node = q.poll();
            order.add(node);

            ArrayList<Integer> neighbour = adj.get(node);

            for ( int i=0 ; i < neighbour.size(); i++ ){

                int currentNode = neighbour.get(i);

                inDegree[currentNode] = inDegree[currentNode] - 1;

                // If any node inDegree gets 0 we add them
                if( inDegree[currentNode] == 0 ){
                    q.add( currentNode );
                }
            }
        }


        // Step 4:

        /*
                 0         2         1         1
                (1) ----> (2) ----> (3) ----> (5)
                           ^         |
                           |         |
                           |         v
                           < ------ (4)
                                     1

                if we remove 1 then

                 2         1         1
                (2) ----> (3) ----> (5)
                           ^         |
                           |         |
                           |         v
                           < ------ (4)
                                     1

                We see there is no other node having inDegree 0
                There our function will stop
                Therefore, order = 1

                since order must have all the nodes
                if( order.size() != vertices )

                -> meaning there might be a cycle somewhere in the graph
                -> Therefore, cycle detected
         */

        if( order.size() != vertices ){
            return true;
        }

        return false;
    }
}

