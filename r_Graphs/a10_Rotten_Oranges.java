package r_Graphs;

//  994. Rotting Oranges
//  https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=10


import java.util.LinkedList;
import java.util.Queue;

class Pairr{
    int first;
    int second;
    int time ;

    public Pairr(int first, int second, int time ){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

public class a10_Rotten_Oranges {
    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Pairr> q = new LinkedList<>();

        int freshCount = 0;
        for( int i=0 ; i<n ; i++ ){
            for( int j=0 ; j<m; j++ ){

                if( grid[i][j] == 2 ){
                    q.add( new Pairr(i,j,0) );
                    visited[i][j] = true;
                }

                if( grid[i][j] == 1 ){
                    freshCount++;
                }
            }
        }

        int org = 0;
        int gettingBadCount = 0;
        while( !q.isEmpty() ){

            int row = q.peek().first;
            int col = q.peek().second;
            int time = q.peek().time;

            q.remove();

            if( time > org ){
                org = time;
            }

            int[][] direction = { {-1,0}, {0,-1}, {0,1}, {1,0} };

            for( int i=0 ; i<direction.length ; i++ ){
                int rowX = row + direction[i][0];
                int colX = col + direction[i][1];

                if( rowX >= 0 && rowX < n && colX >= 0 && colX < m
                        && grid[rowX][colX] == 1 && visited[rowX][colX] == false ){

                    q.add( new Pairr( rowX, colX, time+1) );
                    grid[rowX][colX] = 2;
                    visited[rowX][colX] = true;
                    gettingBadCount++;
                }
            }
        }

//        for( int x=0 ; x<n ; x++ ){
//            for( int y=0 ; y<m ; y++ ){
//                if( grid[x][y] == 1 ){
//                    return -1;
//                }
//            }
//        }


        // freshCount -> count total fresh oranges
        // gettingBadCount -> number of oranges getting bad
        // so they don't match we will know that there might be some orange left as fresh
        if( freshCount != gettingBadCount ){
            return -1;
        }

        return org;
    }
}
