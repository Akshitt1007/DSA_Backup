package r_Graphs;

//1631. Path With Minimum Effort
//https://leetcode.com/problems/path-with-minimum-effort/description/

import java.util.ArrayList;
import java.util.PriorityQueue;

public class cq4_Path_with_minimum_efforts {
    public static void main(String[] args) {
    }

    class Pair{
        int r;
        int c;
        int efforts;
        public Pair( int efforts, int r, int c ){
            this.efforts = efforts;
            this.r = r;
            this.c = c;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        ArrayList<ArrayList<Integer>> TotalPath = new ArrayList<>();

        int[][] distance = new int[n][m];

        for( int i=0; i<n; i++ ){
            for( int j=0; j<m; j++ ){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b) -> a.efforts - b.efforts );

        pq.add( new Pair(0, 0, 0) );
        distance[0][0] = 0;


        while( !pq.isEmpty() ){

            int r = pq.peek().r;
            int c = pq.peek().c;
            int currEff = pq.peek().efforts;

            pq.remove();

            int[][] directions = { {-1,0}, {0,1}, {1,0}, {0,-1} };

            for( int i=0; i< directions.length; i++ ){

                int xr = directions[i][0] + r ;
                int xc = directions[i][1] + c ;

                if( xr >= 0 && xc >= 0 && xr < n && xc < m ){

                    int val = heights[r][c];
                    int currVal = heights[xr][xc];
                    int diff = Math.abs( val - currVal );

                    int newEff ;

                    if( currEff > diff ){
                        newEff = currEff;
                    }
                    else{
                        newEff = diff;
                    }

                    if( newEff < distance[xr][xc] ){
                        pq.add( new Pair( newEff, xr, xc ) );
                        distance[xr][xc] = newEff;
                    }

                }
            }
        }


        return distance[n-1][m-1];
    }
}
/*
    ================================================================================
    NOTE TO FUTURE ME – MINIMUM EFFORT PATH (DIJKSTRA ON GRID)
    ================================================================================

    PROBLEM SUMMARY:
    Grid of heights.
    Start = (0,0), End = (n-1,m-1).
    Effort of a path = maximum absolute difference between consecutive cells.
    Goal = minimize this effort.

    This is NOT sum-based shortest path.
    This is MINIMIZE THE MAXIMUM EDGE problem.

    ================================================================================
    MY ORIGINAL (WRONG) THINKING:
    --------------------------------
    I thought:
    "If the current step difference (diff) is small,
    then the path must be better."

    So I wrote:

        if (diff < distance[next]) {
            bigger = max(diff, currentEffort);
            update
        }

    This looks logical, BUT IT IS WRONG.

    ================================================================================
    MY WRONG CODE LOGIC (IMPORTANT PART):
    ------------------------------------
    int diff = abs(height[curr] - height[next]);

    if (diff < distance[next]) {
        if (diff > d) bigger = diff;
        else bigger = d;

        distance[next] = bigger;
        push into PQ
    }

    THE MISTAKE:
    I compared `diff` with `distance[next]`.

    diff  = pain of THIS STEP
    distance[next] = pain of ENTIRE PATH so far

    These two are NOT comparable.

    ================================================================================
    WRONG DRY RUN (WHERE EVERYTHING BREAKS):
    ----------------------------------------
    Grid:
    1 2 2
    3 8 2
    5 3 5

    Key cells:
    (0,2) = 2
    (1,2) = 2

    STEP-BY-STEP (WRONG LOGIC):

    1) Reach (0,2) with effort = 1
       distance[0][2] = 1

    2) From (0,2) go to (1,2):
       diff = |2-2| = 0
       distance[1][2] = INF

       0 < INF → UPDATE
       bigger = max(1,0) = 1
       distance[1][2] = 1

    3) From (1,2) go BACK to (0,2):
       diff = 0
       distance[0][2] = 1

       0 < 1 → UPDATE AGAIN ❌
       bigger = max(1,0) = 1

    4) From (0,2) again go to (1,2):
       SAME THING HAPPENS

    RESULT:
    (0,2) ↔ (1,2) keeps updating each other.
    Up → Down → Up → Down.

    This creates:
    - repeated PQ insertions
    - fake low-effort paths
    - sometimes effort becomes 0
    - logical infinite loop behavior

    ROOT CAUSE:
    I allowed updates even when the TOTAL PATH was NOT better.

    ================================================================================
    THE CORRECT THINKING:
    ---------------------
    This problem cares about:
    "Worst jump I have seen in my entire journey so far"

    So the correct value to compare is:
        newEffort = max(previousEffort, stepDiff)

    NOT stepDiff alone.

    RULE:
    Only update a cell if the ENTIRE PATH becomes strictly better.

    ================================================================================
    CORRECT CODE LOGIC:
    -------------------
    int diff = abs(height[curr] - height[next]);

    int newEffort;
    if (diff > d) newEffort = diff;
    else newEffort = d;

    if (newEffort < distance[next]) {
        distance[next] = newEffort;
        push into PQ
    }

    KEY FIX:
    Comparison uses `newEffort`, NOT `diff`.

    ================================================================================
    CORRECT DRY RUN (WHY IT WORKS):
    --------------------------------
    Same grid.

    Start:
    distance[0][0] = 0

    Key moments:

    Reach (0,2):
    distance[0][2] = 1

    Reach (1,2):
    distance[1][2] = 1

    Now from (1,2) → (0,2):
    diff = 0
    newEffort = max(1,0) = 1

    Check:
    1 < distance[0][2] (=1) → FALSE

    So:
    NO UPDATE
    NO BACKWARD LOOP
    NO PING-PONG

    Algorithm moves forward only.

    Eventually best path found:
    (0,0) → (1,0) → (2,0) → (2,1) → (2,2)

    All jumps = 2
    Maximum effort = 2


    ================================================================================
    END OF NOTE – READ THIS BEFORE RECODING THIS PROBLEM AGAIN
    ================================================================================
    */
