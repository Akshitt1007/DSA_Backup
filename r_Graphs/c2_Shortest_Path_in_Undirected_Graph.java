package r_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//  https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
//  Shortest Path in Undirected Graph

public class c2_Shortest_Path_in_Undirected_Graph {

    private class Pair{
        int node;
        int w;
        public Pair(int node, int w ){
            this.node = node;
            this.w = w;
        }
    }

    public static void main(String[] args) {
    }

    public int[] shortestPath(int V, int[][] edges, int src) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build undirected graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 3: Distance array (also works as visited array)
        int[] distance = new int[V];

        for (int i = 0; i < V; i++) {
            distance[i] = -1;
        }

        // Step 4: BFS using normal while loop
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        distance[src] = 0;

        while (!q.isEmpty()) {

            int current = q.poll();

            // Normal for-loop over neighbors
            for (int i = 0; i < adj.get(current).size(); i++) {

                int neighbour = adj.get(current).get(i);

                /*
                    In BFS (Breadth-First Search), nodes are explored level by level.

                    Since all edges have equal weight (unit distance),
                    the first time we reach a node is guaranteed to be
                    the shortest possible path from the source.

                    Therefore, once a node is visited and its distance is set,
                    it never needs to be updated again.
                */

                // If not visited
                if (distance[neighbour] == -1) {
                    distance[neighbour] = distance[current] + 1;
                    q.add(neighbour);
                }
            }
        }

        return distance;
    }

    public int[] shortestPath_Wrong(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for( int i=0; i<V; i++ ){
            adjList.add( new ArrayList<>() );
        }


        for( int i=0; i<edges.length; i++ ){
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.get(u).add( new Pair(v, 1) );
            adjList.get(v).add( new Pair(u, 1) );
        }


        ArrayList<Integer> stack = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for( int i=src; i<V; i++ ){

            if( !visited[src] ){
                order( adjList, visited, stack, i );
            }
        }

        int[] distance = new int[V];

        for( int i=0; i<V; i++ ){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;

/*
       💡 Important (Undirected Shortest Path)

        In an undirected graph, every edge works both ways:
                    u -> v and v -> u

        - While finding the shortest path (BFS / Dijkstra),
        - once a node’s shortest distance is finalized,
        - we must mark it as visited.

        If we don’t do this, the algorithm may:
            - Go from u to v
            - Then immediately come back from v to u
            - And repeat this unnecessarily

        - distanceVisited[] ensures that each node is
        - processed only once after its shortest distance
        - is determined, preventing redundant cycles
        - and infinite back-and-forth traversal.

 */
        boolean[] distanceVisited = new boolean[V];

        while( !stack.isEmpty() ){

            int u = stack.get(0);
            stack.removeFirst();
            distanceVisited[u] = true;

            ArrayList<Pair> neighbourPair = adjList.get(u);

            for( int i=0; i<neighbourPair.size() ; i++ ){
                int v = neighbourPair.get(i).node;
                int w = neighbourPair.get(i).w;

                if( distance[u] != Integer.MAX_VALUE && !distanceVisited[v] &&  distance[u] + w < distance[v] ){
                    distance[v] = distance[u] + w;
                }
            }
        }

        for( int i=0; i<V; i++ ){
            if( distance[i] == Integer.MAX_VALUE ){
                distance[i] = -1;
            }
        }

        return distance;
    }
    public void order(ArrayList<ArrayList<Pair>>adj, boolean[] visited, ArrayList<Integer> traversal, int node ){

        /*

        💡 Why used BFS and not BFS ?

        1️⃣ Nature of BFS:
            - BFS explores the graph level by level.
            - All nodes at distance 'd' are processed before nodes at distance 'd + 1'.

        2️⃣ Shortest Path Guarantee:
            - In an undirected graph with equal edge weights (usually weight = 1),
            the first time BFS reaches a node, it is guaranteed to be the
            shortest possible path to that node.

        3️⃣ Why DFS Fails:
            - DFS goes deep into one path before exploring others.
            - It may reach a node using a longer path first.
            - DFS does NOT guarantee the shortest distance.

        4️⃣ Example:
            0 -- 1 -- 2
             \        /
               ---- 3

            - DFS might go: 0 → 1 → 2 → 3  (distance = 3)
            - BFS will go: 0 → 3          (distance = 1)

         visited[node] = true;
         traversal.add(node);

         ArrayList<Pair> neighbour = adj.get(node);
         for( int i=0 ; i<neighbour.size(); i++ ){

             int xyz = neighbour.get(i).node;
             if( !visited[xyz] ){
                 order( adj, visited, stack, xyz );
             }
         }
         */

        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {

            Integer currentNode = q.poll();
            traversal.add(currentNode);

            ArrayList<Pair> neighbours = adj.get(currentNode);

            for (int i = 0; i < neighbours.size(); i++) {

                int adjNode = neighbours.get(i).node;

                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }


    }
}
