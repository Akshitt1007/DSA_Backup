package r_Graphs;


//1020. Number of Enclaves
//https://leetcode.com/problems/number-of-enclaves/description/

public class a16_Number_of_Enclaves {
    public static void main(String[] args) {

    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){

                if( grid[i][j] == 1 ){

                    if( i == 0 || i == n-1 || j == 0 || j == m-1 ){
                        DFS(grid, visited, i, j );
                    }
                }
            }
        }

        int count = 0;
        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){

                if( grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS( int[][]board, boolean[][] visited, int row, int col ){

        // boundary + visited + non-O check
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                visited[row][col] ||
                board[row][col] != 1) {
            return;
        }

        visited[row][col] = true;

        DFS(board, visited, row - 1, col);
        DFS(board, visited, row + 1, col);
        DFS(board, visited, row, col - 1);
        DFS(board, visited, row, col + 1);
    }

}
