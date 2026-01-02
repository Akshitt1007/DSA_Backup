package r_Graphs;


//787. Cheapest Flights Within K Stops
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
    NOTE on LeetCode 787 – Cheapest Flights Within K Stops

    The problem asks for the MINIMUM COST path from src to dst
    using AT MOST K stops.

    Important clarifications:
    1. "Within K stops" means:
           0 ≤ stops ≤ K
       It does NOT mean exactly K stops.

    2. We are allowed to reach the destination using fewer than K stops
       if that path gives a cheaper price.

    3. Stops act only as a CONSTRAINT (upper bound),
       not as an optimization objective.

    4. Among all paths that reach the destination with stops ≤ K,
       we choose the one with the minimum total cost.

    5. Any path that exceeds K stops is invalid and must be ignored,
       even if it is cheaper.

    Summary:
    - Stops decide whether a path is allowed.
    - Price decides which allowed path is optimal.
*/


public class cq5_Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {

    }

    class tuple{
        int steps;
        int price;
        int node;
        public tuple( int steps, int node, int price){
            this.price = price;
            this.node = node;
            this.steps = steps;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<tuple>> adjList = new ArrayList<>();
        for( int i=0; i<n; i++ ){
            adjList.add( new ArrayList<>() );
        }
        for( int i=0; i<flights.length; i++ ){
            int u = flights[i][0];
            int price = flights[i][2];
            int v = flights[i][1];

            adjList.get(u).add( new tuple( 0, v, price) );
        }


        int distance[] = new int[n];
        for( int i=0; i<n ; i++ ){
            distance[i] = Integer.MAX_VALUE;
        }


        Queue<tuple> pq = new LinkedList<>();
    /*
        We are not using a PriorityQueue here because:

        1. The traversal is bounded by the number of stops (K),
           not purely by minimum price.

        2. We explore the graph level by level, where each level
           represents one additional stop (0 → 1 → 2 → ...).

        3. Since the number of stops increases uniformly (like BFS levels),
           a normal Queue is sufficient to control the traversal order.
    */

        pq.add( new tuple( 0, src, 0) );
        distance[src] = 0;


        while( !pq.isEmpty() ){

            int cost = pq.peek().price;
            int u = pq.peek().node;
            int stops = pq.peek().steps;

            pq.remove();


            // There can be a possibility where we can reach our destination in less price more steps.
            // but we don't care about the price, we have to give the min. price with only that exact stops
            // So whenever our stops exceeds our given stops
            // we will not count those path.
            if ( stops > k ){
                continue;
            }

            ArrayList<tuple> neighbour = adjList.get( u );

            for( int i=0; i<neighbour.size() ; i++ ){

                int v = neighbour.get(i).node;
                int newcost = neighbour.get(i).price;

                int totalPrice = cost + newcost;

                if( totalPrice < distance[v] ){
                    distance[v] = totalPrice;
                    pq.add( new tuple( stops+1, v, totalPrice) );
                }

            }
        }

        for( int i=0 ; i<n ; i++ ){
            if( distance[i] == Integer.MAX_VALUE ){
                distance[i] = -1;
            }
        }

        return distance[dst];
    }
}
