package r_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
        BIPARTITE GRAPH

    DEFINITION:
    -----------
    A graph is called a BIPARTITE GRAPH if its vertices can be divided into
    TWO DISJOINT SETS such that:

        - Every edge connects a vertex from Set A to Set B
        - No edge connects two vertices within the same set
        - In simple words: NO two adjacent vertices have the same color


    COLORING VIEW (Most Important):
    -------------------------------
    A graph is bipartite IF AND ONLY IF it can be colored using ONLY TWO COLORS
    such that no two adjacent nodes have the same color.

    We usually use:
        - Color 1 → Yellow
        - Color 2 → Green


        DIAGRAM (BIPARTITE GRAPH):
        --------------------------

    Set A (Yellow)        Set B (Green)

        (0) ───────── (1)
         |              |
         |              |
        (2) ───────── (3)

    Edges only go BETWEEN sets, never inside a set.

    Valid coloring:
    0 → Yellow
    1 → Green
    2 → Yellow
    3 → Green

        NON-BIPARTITE GRAPH (ODD CYCLE):
        --------------------------------

        (0)
       /   \
      /     \
    (1)───(2)

    Try coloring:
    0 → Yellow
    1 → Green
    2 → Yellow

    But edge (2 → 0) connects two Yellow nodes ❌
    So this graph is NOT bipartite.


    KEY PROPERTY (VERY IMPORTANT):
    ------------------------------
    A graph is BIPARTITE ⇔ it DOES NOT contain an ODD LENGTH CYCLE.

    - Even cycle → Bipartite
    - Odd cycle  → Not Bipartite


 */


class color{
    int node;
    String color;
    public color ( int node, String color ){
        this.node = node;
        this.color = color;
    }
}


public class a18_Bipartite_Graphs_BFS {
    public static void main(String[] args) {
    }

    public static boolean BFS_bipartite( int root, ArrayList<ArrayList<Integer>> adj, int vertices){

        boolean[] visited = new boolean[vertices];

        String[] nodeColor = new String[vertices];
        /*
            nodeColor[] (String array) is used to store the assigned color of each node so that when a node is revisited during BFS,
            we can check whether an adjacent node has the same color; if it does, the graph is not bipartite.
         */

        Queue<color> q = new LinkedList<>();
        q.add( new color( root, "yellow") );
        visited[root] = true;

        nodeColor[root] = "yellow";   // 🔧


        while( !q.isEmpty() ){

            int node = q.peek().node;
            String color = q.peek().color;
            q.remove();


            ArrayList<Integer> neighbour = adj.get(node);

            for ( int i=0 ; i<neighbour.size(); i++ ){

                int currentNode = neighbour.get(i);

                // if not visited → assign opposite color
                if( !visited[currentNode] ){

                    visited[currentNode] = true;

                    if( color.equals("yellow")) {
                        nodeColor[currentNode] = "green";
                        q.add( new color( currentNode, "green") );
                    }

//                  if( color.equals("green")) {}
                    else{
                        nodeColor[currentNode] = "yellow";
                        q.add( new color( currentNode, "yellow") );
                    }
                }

                // if visited → check color conflict
                /*
                if( nodeColor[currentNode].equals(currColor) ){
                    if( color.equals() ){
                        return false;
                    }
                }
                    - here in case of visited node
                    - how we will be able to recall the color of that next node that we have visited
                    - therefore we will create a new string array which will store the node color wrt number
                 */
                else{
//                if( visited[currentNode] ){
                    if( nodeColor[currentNode].equals(color) ){
                        return false;
                    }
                }
            }
        }


        return true;
    }
}


// https://leetcode.com/problems/is-graph-bipartite/
// 785. Is Graph Bipartite?

class Solution {

    public boolean isBipartite(int[][] graph) {

        ArrayList<ArrayList<Integer>> adj = convert(graph);
        int vertices = adj.size();

        boolean[] visited = new boolean[vertices];
        String[] colorNode = new String[vertices];

        // To check for dis-connected graphs
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (!check(i, adj, visited, colorNode)) {
                    return false;
                }
            }
        }
        return true;
    }

    // BFS for ONE connected component
    public boolean check(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited, String[] colorNode){

        Queue<color> q = new LinkedList<>();

        q.add(new color(start, "yellow"));

        visited[start] = true;
        colorNode[start] = "yellow";

        while (!q.isEmpty()) {

            int node = q.peek().node;
            String color = q.peek().color;
            q.remove();

            ArrayList<Integer> neighbour = adj.get(node);

            for (int i = 0; i < neighbour.size(); i++) {

                int currentNode = neighbour.get(i);

                if (!visited[currentNode]) {

                    visited[currentNode] = true;

                    if (color.equals("yellow")) {
                        colorNode[currentNode] = "green";
                        q.add(new color(currentNode, "green"));
                    } else {
                        colorNode[currentNode] = "yellow";
                        q.add(new color(currentNode, "yellow"));
                    }
                }
                else {
                    if (colorNode[currentNode].equals(color)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // LeetCode 785 conversion
    public ArrayList<ArrayList<Integer>> convert(int[][] graph) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        return adj;
    }
}

