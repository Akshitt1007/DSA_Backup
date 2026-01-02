package r_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class b5_Topological_Sort_BFS_or_Kahn_Algorithm {
    public static void main(String[] args) {

    }

    public static void Kahn_Algorithm(int vertices, ArrayList<ArrayList<Integer>> adj ){

//        boolean[] visited = new boolean[vertices];

        // Step 1:
        // This is to store all the inDegree of each node
        // index 0 -> the value present at index 0 is the inDegree for that index(0 here).
        int[] inDegree = new int[vertices];

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
//            visited[node] = true;

            ArrayList<Integer> neighbour = adj.get(node);

            // After removing the node with 0 indegree we will also subject the edges that are connected to it
            for ( int i=0 ; i < neighbour.size(); i++ ){

                int currentNode = neighbour.get(i);

                inDegree[currentNode] = inDegree[currentNode] - 1;

                // If any node inDegree gets 0 we add them
                if( inDegree[currentNode] == 0 ){
                    q.add( currentNode );
                }
            }

            /*
            This step can be removed
            we can do directly where we are removing the indegree after the node is getting removed
            This save us time and space, since we don't need visited[]

            // Step 4:
            // After removing the node and maintaining the inDegree of other nodes whose edges might connect to above deleted node
            // We will see if any other node's inDegree gets 0
            // If happen so, we will add it in the queue.
            for( int i=0 ; i < inDegree.length; i++ ){

                // Visited check because we can accidentally add the node again which we have removed earlier
                if( !visited[i] && inDegree[i] == 0 ){
                    q.add( i );
                }
            }

             */
        }




    }
}
