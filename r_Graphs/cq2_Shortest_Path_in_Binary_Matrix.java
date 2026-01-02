package r_Graphs;


//1091. Shortest Path in Binary Matrix
//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

// Same as what we do in rotten oranges

import java.util.LinkedList;
import java.util.Queue;

public class cq2_Shortest_Path_in_Binary_Matrix {
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
    public int shortestPathBinaryMatrix(int[][] grid) {

        if( grid[0][0] == 1 ){
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Pair> q = new LinkedList<>();

        q.add( new Pair( 1, 0,0) );
        visited[0][0] = true;

        int distance = -1;

        while( !q.isEmpty() ){

            Pair rcd = q.poll();
            int r = rcd.r;
            int c = rcd.c;
            int d = rcd.distance;

            if( r == n-1 && c == m-1 ){
                return d;
            }

            int[][] direction = { {-1,0}, {0,1}, {1,0}, {0,-1}, {-1,-1}, {-1,1}, {1,1}, {1,-1} };

            for( int i=0; i<direction.length; i++ ){

                int xr = direction[i][0] + r;
                int xc = direction[i][1] + c;

                if( xr >= 0 && xc >= 0 && xr < n && xc < m && !visited[xr][xc] && grid[xr][xc] == 0 ){
                    q.add( new Pair(d+1, xr, xc) );
                    visited[xr][xc] = true;
                }
            }
        }

        return -1;
    }

}
