package r_Graphs;


//130. Surrounded Regions
//https://leetcode.com/problems/surrounded-regions/description/

/*
        [[ X   X   O   X   X   X   X ],
         [ X   O   O   X   O   O   X ],
         [ X   X   O   X   O   O   X ],
         [ X   O   O   X   X   X   X ]]

    1. If any 0 is connected to the boundary it means it cannot be X
       Therefore we will be taking that block in which not even a single index lies on the boundary
 */
public class a15_Surrounded_Regions {
    public static void main(String[] args) {

    }
    /*
        1. First, we check all the boundary (edge) cells of the matrix.

        2. If we find an 'O' on the boundary, we start a DFS from that cell.

        3. The purpose of this DFS is to mark all 'O' cells that are directly or indirectly
           connected to the boundary.

        4. Why do we do this?
           Because any 'O' connected to the boundary can never be surrounded by 'X'
           (there will always be at least one open direction: up, down, left, or right).

        5. After completing DFS from all boundary 'O's, all safe 'O's are marked as visited.

        6. Finally, we traverse the entire matrix again.
           Any 'O' that is not visited must be completely surrounded by 'X',
           so we convert it to 'X'.
    */

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for( int i=0 ; i<board.length; i++ ){
            for( int j=0 ; j<board[0].length; j++ ){
                if( board[i][j] == 'O' ){
                    if( i == 0 || i == n-1 || j == 0 || j == m-1 ){
                        DFS(board, visited, i, j );
                    }
                }
            }
        }

        for( int k=0 ; k<n; k++ ){
            for( int l=0 ; l<m ; l++ ){

                if( board[k][l] == 'O' && visited[k][l] == false ){
                    board[k][l] = 'X';
                }
            }
        }

    }
    public void DFS(char[][] board, boolean[][] visited , int row, int col ){

        // boundary + visited + non-O check
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length ||
                visited[row][col] ||
                board[row][col] != 'O') {
            return;
        }

        visited[row][col] = true;

        DFS(board, visited, row - 1, col);
        DFS(board, visited, row + 1, col);
        DFS(board, visited, row, col - 1);
        DFS(board, visited, row, col + 1);
    }
}
