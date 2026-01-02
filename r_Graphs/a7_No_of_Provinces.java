package r_Graphs;

import java.util.ArrayList;


//547. Number of Provinces
//https://leetcode.com/problems/number-of-provinces/description/


public class a7_No_of_Provinces {
    public static void main(String[] args) {

    }

    // 1. If the given parameter is in the form of adj list
    public static int provincesCount(int node, ArrayList<ArrayList<Integer>> edges ){

        boolean[] visited = new boolean[node];
        int count = 0;

        for( int i=0 ; i < visited.length; i++ ){

            if( !visited[i] ){
                count++;
                DFS( i, edges, visited );
            }
        }
        return count;
    }
    public static void DFS( int node, ArrayList<ArrayList<Integer>> adj , boolean[] visited ){

        visited[node] = true;

        ArrayList<Integer> neighbour = adj.get( node );

        for( int i=0 ; i < neighbour.size() ; i++ ){

            int currentNode = neighbour.get(i);

            if( !visited[currentNode] ){
                DFS( currentNode, adj, visited);
            }
        }
    }


    // 2. If the given parameter is in the form of matrix
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }
    private void dfs(int node, int[][] isConnected, boolean[] visited){
        visited[node] = true;

        for(int j = 0; j < isConnected.length; j++){
            if(isConnected[node][j] == 1 && !visited[j]){
                dfs(j, isConnected, visited);
            }
        }
    }
}
