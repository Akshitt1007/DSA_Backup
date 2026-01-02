package r_Graphs;

import java.util.ArrayList;
import java.util.List;

//802. Find Eventual Safe States
//https://leetcode.com/problems/find-eventual-safe-states/description/


/*
       [0] ---> [1]
        |  \   / |
        |    X   |
        v  /   \ v
       [2]      [3]           [6]
        |
        |
        v
       [5] <--- [4]


       - terminal node -> These are node that have no outgoing edges
       - here 5 and 6 are terminal nodes

       - Safe node -> these are node from where all the possible path connects to the terminal node

       - so in above diagram
       - if we take node 1
       - possible path:     1 -> 3 -> 0 -> 2 -> 5
                            1 -> 2 -> 0 -> 1
       - there not all path link to the terminal
       - there this is not a safe node

       - safe node are 5 and 6 itself
       - and 2 and 4


       ** CONCLUSION **
       - anyone who is a part of a cycle cannot be the safe node
       - anyone who leads to a cycle cannot be a safe node
 */
public class b2_Find_Eventual_Safe_States {
    public static void main(String[] args) {

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int V = adj.size();

        List<Integer> list = new ArrayList<>();

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        // To store the safe node
        boolean[] safe = new boolean[V];

        for( int i=0 ; i<V; i++ ){
            if( !visited[i] ){
                DFS(adj, visited, pathVisited, safe, i );
            }
        }

        // Storing those index that are safe
        for( int i=0 ; i<safe.length; i++ ){
            if( safe[i] ){
                list.add( i );
            }
        }

        return list;
    }

    public static boolean DFS( ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited, boolean[] safe, int node ){

        visited[node] = true;
        pathVisited[node] = true;

        ArrayList<Integer> neighbour = new ArrayList<>( adj.get(node) );
        for( int i=0 ; i<neighbour.size(); i++ ){

            int neighbourNode = neighbour.get(i);

            // If not visited, explore
            if( !visited[neighbourNode] ){

                boolean chck = DFS( adj, visited, pathVisited, safe, neighbourNode );
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
        safe[node] = true;
        return false;
    }
}
