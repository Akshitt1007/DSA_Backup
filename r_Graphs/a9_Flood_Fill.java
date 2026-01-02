package r_Graphs;


import java.util.LinkedList;
import java.util.Queue;

//  733. Flood Fill
// https://leetcode.com/problems/flood-fill/description/

class pair{
    int first;
    int second;
    public pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class a9_Flood_Fill {
    public static void main(String[] args) {

    }

    // Using BFS
    public int[][] BFS(int[][] image, int sr, int sc, int color) {

        int org = image[sr][sc];

        // If new color = old color, no need to BFS
        if (org == color) return image;

        Queue<pair> q = new LinkedList<>();
        q.add( new pair( sr, sc ) );

        // mark first cell
        image[sr][sc] = color;

        int n = image.length;
        int m = image[0].length;

        while( !q.isEmpty() ){

            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // Directions: up, left, right, down
            int[][] direction = { {-1,0}, {0,-1}, {0,1}, {1,0} };

            for( int i=0 ; i < direction.length ; i++ ){

                int rowX = row + direction[i][0];
                int colX = col + direction[i][1];

                if( rowX >= 0 && rowX < n && colX >= 0 && colX < m && image[rowX][colX] == org) {

                    image[rowX][colX] = color;
                    q.add( new pair(rowX, colX) );
                }
            }
        }

        return image;
    }




    // Using DFS
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int org = image[sr][sc];

        // ⚔️🔥 This check is very important
        // If the node is same as the color
        // then when we would be doing the DFS we will first go up -> left/right -> down -> right/left
        // The color would be same since the org == color
        // infinite loop
        // stack overflow
        if (org == color) {
            return image;
        }

        DFS( image, sr, sc, color, org );
        return image;
    }
    public void DFS( int[][] image, int sr, int sc, int color, int org ){

        if (sr < 0 || sr > image.length - 1 || sc < 0 || sc > image[0].length - 1 ){
            return;
        }

        if( image[sr][sc] == org  ){
            image[sr][sc] = color;

            DFS( image, sr-1, sc, color, org );
            DFS( image, sr, sc-1, color, org );
            DFS( image, sr, sc+1, color, org );
            DFS( image, sr+1, sc, color, org );
        }
    }
}
