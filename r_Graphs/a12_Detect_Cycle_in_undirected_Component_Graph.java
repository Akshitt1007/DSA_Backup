package r_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a12_Detect_Cycle_in_undirected_Component_Graph {
    public static void main(String[] args) {

        int nodes = 10;
        boolean[] visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {

            if (!visited[i]) {

                if (CyclicCheck(i, new ArrayList<>() , visited)) {
                    System.out.println("Cycle Found");
                    return;
                }
            }
        }

        System.out.println("No Cycle");
    }

    public static boolean CyclicCheck(int nodes, ArrayList<ArrayList<Integer>> edges, boolean[] visited ){

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