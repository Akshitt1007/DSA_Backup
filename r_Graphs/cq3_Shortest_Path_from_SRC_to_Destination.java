package r_Graphs;

//Shortest Distance in a Binary Maze
//https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1

// same as the cq2 but here given starting node and ending distance node

import java.util.LinkedList;
import java.util.Queue;

public class cq3_Shortest_Path_from_SRC_to_Destination {
    public static void main(String[] args) {

    }

    class Pair{
        int r;
        int c;
        int distance;
        public Pair( int distance, int r, int c ){
            this.distance = distance;
            this.r = r;
            this.c = c;
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        int startRow = source[0];
        int startCol = source[1];

        int endRow = destination[0];
        int endCol = destination[1];

        if( grid[startRow][startCol] == 0 ){
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        q.add( new Pair( 0, startRow, startCol ) );
        visited[startRow][startCol] = true;

        int distance = -1;

        while( !q.isEmpty() ){

            Pair rcd = q.poll();
            int r = rcd.r;
            int c = rcd.c;
            int d = rcd.distance;

            if( r == endRow && c == endCol ){
                return d;
            }

            int[][] direction = { {-1,0}, {0,1}, {1,0}, {0,-1} };

            for( int i=0; i<direction.length; i++ ){

                int xr = direction[i][0] + r;
                int xc = direction[i][1] + c;

                if( xr >= 0 && xc >= 0 && xr < n && xc < m && !visited[xr][xc] && grid[xr][xc] == 1 ){
                    q.add( new Pair(d+1, xr, xc) );
                    visited[xr][xc] = true;
                }
            }
        }

        return -1;
    }
}
