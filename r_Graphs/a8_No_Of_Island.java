package r_Graphs;

import java.util.LinkedList;
import java.util.Queue;


//  https://leetcode.com/problems/number-of-islands/description/
//  200. Number of Islands

public class a8_No_Of_Island {

    private  class Pair{
        int first;
        int second;
        public Pair( int first, int second ){
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

    }
/*
    We are given a grid of '1's and '0's:

        [
          ["1","1","0","0","0"],
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]
        ]

    Each "1" represents land.
    Each "0" represents water.

    To count islands, we explore the grid cell by cell.
    When we find a '1' that has not been visited,
    we start a DFS/BFS and mark every connected land cell.

    For this, we maintain a visited[][] array.
    As we finish exploring the first island, all of its land cells
    are marked as visited = true.

    Later, when our loop encounters these cells again,
    it simply skips over them because they are already visited.
    This prevents counting the same island more than once.

    Whenever we discover a new unvisited '1',
    it means we have found a completely new island.
    We explore it fully and increase our island count.

    In short:
    visited[][] helps us remember where we've already gone,
    so each island is counted exactly once.
*/

    public int numIslands(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for( int i=0 ; i<n ; i++ ){
            for( int j=0 ; j<m ; j++ )

                if( matrix[i][j] == '1' && visited[i][j] == false ){
                    count++;
                    BFS( matrix, visited, i, j );
                }
        }

        return count;
    }

    public void BFS( char[][] matrix, boolean[][] visited, int i, int j ){

        Queue<Pair> q = new LinkedList<>();
        q.add( new Pair(i, j) );

        visited[i][j] = true;

        int n = matrix.length;
        int m = matrix[0].length;

        while( !q.isEmpty() ){

            int row = q.peek().first;           // accessing the first pair
            int col = q.peek().second;          // accessing the second pair

            q.remove();

            // traversing in the neighbour
            for( int deltaRow = -1; deltaRow <= 1 ; deltaRow++ ){
                for( int deltaCol = -1; deltaCol <=1 ; deltaCol++ ){

                    // This would be storing the element from top left neighbour index
                    int nRow = row + deltaRow;
                    int nCol = col + deltaCol;

                    // "To check if that is within the range of matrix" and
                    // "should be a land" and
                    // "should not be visited"
                    if( nRow >= 0 && nRow < n && nCol >= 0 && nCol < m              // condition for range
                            && matrix[nRow][nCol] == '1'                            // to chck if this is land
                            && !visited[nRow][nCol] ){                              // to chck if this is not visited

                        // and when all the above conditions are satisfied
                        // we will mark them as visited and put them in the queue
                        visited[nRow][nCol] = true;
                        q.add( new Pair( nRow, nCol) );
                    }
                }
            }
        }

    }

    /*
        here to find its neighbour
        we see
        there could be total of 8 possibilities

        row-1,col-1          row-1, col            row-1,col+1
                      \           |              /
        row,col-1     -    row,col (org index)  -  row, col+1
                      /           |              \
        row+1, col+1          row+1,col            row+1,col+1


        -> so we can write 8 different lines to get this,

            int tx0 = row-1,col-1;
            int tx1 = row-1,col;
            int tx2 = row-1,col+1;

            int cx0 = row,col-1;
            int cx1 = row,col;
            int cx2 = row,col+1;

            int bx0 = row+1,col-1;
            int bx1 = row+1,col;
            int bx2 = row+1,col+1;

        -> or we can use loop to do so
        we see that the range goes from -1 to 1

            for( int deltaRow = -1; deltaRow <= 1 ; deltaRow++ ){
                    for( int deltaCol = -1; deltaCol <=1 ; deltaCol++ ){

     */

    // Using DFS traversal
    public void DFS (char[][] grid, int row, int col) {

        // to check if any one condition false
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        DFS(grid, row - 1, col);
        DFS(grid, row + 1, col);
        DFS(grid, row, col - 1);
        DFS(grid, row, col + 1);
    }
}
