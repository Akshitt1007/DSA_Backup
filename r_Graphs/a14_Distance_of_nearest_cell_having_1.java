package r_Graphs;

//  542. 01 Matrix
//  https://leetcode.com/problems/01-matrix/description/



import java.util.LinkedList;
import java.util.Queue;


class xyz{
    int r;
    int c;
    int distance;
    public xyz(int r, int c, int distance ){
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}

public class a14_Distance_of_nearest_cell_having_1 {
    public static void main(String[] args) {

    }

    public static int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] matrix = new int[n][m];

        Queue<xyz> q = new LinkedList<>();


        for( int i=0 ; i<n ; i++ ){
            for( int j=0 ; j<m ; j++ ){
                if( mat[i][j] == 1 ){
                    q.add( new xyz(i, j, 0) );
                    visited[i][j] = true;
                }
            }
        }

        while( !q.isEmpty() ){

            int r = q.peek().r;
            int c = q.peek().c;
            int distance = q.peek().distance;
            q.remove();

            matrix[r][c] = distance;

            int[][] direction = { {-1,0}, {0,1}, {1,0}, {0,-1} };


            for( int k=0 ; k < 4 ; k++ ){

                int rx = r + direction[k][0];
                int cx = c + direction[k][1];

                if( rx >= 0 && rx < n && cx >= 0 && cx < m && visited[rx][cx] == false ){
                    q.add( new xyz( rx, cx, distance+1) );
                    visited[rx][cx] = true;
                }
            }
        }

        return matrix;
    }
}
