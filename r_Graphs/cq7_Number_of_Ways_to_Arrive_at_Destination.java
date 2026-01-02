package r_Graphs;


//1976. Number of Ways to Arrive at Destination
//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

import java.util.ArrayList;
import java.util.PriorityQueue;

public class cq7_Number_of_Ways_to_Arrive_at_Destination {
    public static void main(String[] args) {

    }


    class Pair{
        int node;
        long distance;
        public Pair( long distance, int node ){
            this.distance = distance;
            this.node = node;
        }
    }
    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();

        for( int i=0; i<n; i++ ){
            adjList.add( new ArrayList<>() );
        }

        for( int i=0; i<roads.length; i++ ){
            int u = roads[i][0];
            int v = roads[i][1];
            int distance = roads[i][2];

            adjList.get(u).add( new Pair(distance, v) );
            adjList.get(v).add( new Pair(distance, u) );
        }

        long[] distance = new long[n];
        for( int i=0; i<n ; i++ ){
            distance[i] = Long.MAX_VALUE;
        }

        int[] ways = new int[n];
        for( int i=0; i<n; i++ ){
            ways[i] = 0;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b) -> Long.compare(a.distance, b.distance) );

        pq.add( new Pair( 0, 0));
        distance[0] = 0;
        ways[0] = 1;

        while( !pq.isEmpty() ){

            int u = pq.peek().node;
            long dis = pq.peek().distance;
            pq.remove();

            if (dis > distance[u]) {
                continue;
            }
            /*
            distance[u] always stores the best (shortest) distance we have found so far for u.
            The priority queue may still contain older distances for u that were added before we discovered the shortest one.
            When we pop such an old distance, we ignore (neglect) it.
            */
            ArrayList<Pair> xyz = adjList.get(u);

            for( int i=0; i<xyz.size(); i++ ){

                int v = xyz.get(i).node;
                long w = xyz.get(i).distance;


                if( distance[u] + w < distance[ v ] ){
                    distance[v] = distance[u] + w;
                    pq.add( new Pair( distance[v], v) );
                    ways[v] = ways[u];
                }
                else if( distance[u] + w == distance[v] ){
                    // ways[v] = ways[v] + ways[u];
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n-1];
    }
}
