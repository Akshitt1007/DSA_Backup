package r_Graphs;
import java.util.ArrayList;
import java.util.List;



//Number Of Islands
//https://www.geeksforgeeks.org/problems/number-of-islands/1

public class dq2_Number_Of_Islands_II {

    // Using Normal DFS
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        int[][] grid = new int[rows][cols];
        List<Integer> total = new ArrayList<>();

        for( int k = 0; k < operators.length; k++ ){

            int x = operators[k][0];
            int y = operators[k][1];

            grid[x][y] = 1;

            boolean[][] vstd = new boolean[rows][cols];

            int num = 0;

            for( int i=0; i<rows; i++ ){
                for( int j=0; j<cols; j++ ){
                    if( !vstd[i][j] && grid[i][j] == 1){
                        DFS(i,j, vstd, grid, rows, cols);
                        num++;
                    }
                }
            }

            total.add( num );
        }

        return total;
    }
    public void DFS( int r, int c, boolean[][] vstd, int[][]grid, int n, int m ){

        if( r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != 1 || vstd[r][c] ){
            return;
        }

        vstd[r][c] = true;

        DFS( r-1, c, vstd, grid, n, m );
        DFS( r, c+1, vstd, grid, n, m );
        DFS( r+1, c, vstd, grid, n, m );
        DFS( r, c-1, vstd, grid, n, m );
    }



    // Using DSU
}
