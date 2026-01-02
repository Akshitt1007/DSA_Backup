package r_Graphs;

//  Number of Distinct Islands
//  https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

import java.util.*;

/*
        grid[][] = [[1, 1, 0, 1, 1],
                    [1, 0, 0, 0, 0],
                    [0, 0, 0, 1, 1],
                    [1, 1, 0, 1, 0]]

                                   (0,0)  (0,1)
              here if we take   -   1       1

                                    1
                                   (1,0)


                        and     -   (2,3)  (2,4)
                                      1      1

                                      1
                                     (3,3)


        To check whether two islands are identical, we normalize their shapes
        by storing each cell's position relative to a chosen base cell.

        For every island:
            1. Pick the first discovered cell as the base (baseRow, baseCol).
            2. Traverse the entire island using DFS/BFS.
            3. For each land cell (r, c), store (r - baseRow, c - baseCol).

        This removes positional dependency and captures only the shape.

        If two islands produce the same collection of relative coordinates,
        they are identical in shape.

        IMPORTANT:
            - Traversal order can differ, so relative coordinates should either
              be sorted before comparison or stored in a Set.
            - Only translation is handled here (not rotation or reflection).
            - ** (row - baseRow, col - baseCol) **


        - for first island:   base = 0,0
                              index 1 = 0,0 - 0,0 = 0,0
                              index 2 = 0,0 - 0,1 = 0,1
                              index 3 = 0,0 - 1,0 = 1,0

                              therefore the set will have = [ (0,0), (0,1), (1,0) ]

         for first island:   base = 2,3
                              index 1 = 2,3 - 2,3 = 0,0
                              index 2 = 2,3 - 2,4 = 0,1
                              index 3 = 2,3 - 3,3 = 1,0

                              therefore the set will have = [ (0,0), (0,1), (1,0) ]

        - Since they both have the same index's arraylist, therefore they are identical
 */
/*
        grid[][] = [[1, 1, 0, 1, 1],
                    [1, 0, 0, 0, 0],
                    [0, 0, 0, 0, 1],
                    [1, 1, 0, 1, 1]]

                                   (0,0)  (0,1)
              here if we take   -   1       1

                                    1
                                   (1,0)


                        and     -          (2,4)
                                             1

                                      1      1
                                     (3,3)  (3,4)

        - for first island:   base = 0,0
                              index 1 = 0,0 - 0,0 = 0,0
                              index 2 = 0,0 - 0,1 = 0,1
                              index 3 = 0,0 - 1,0 = 1,0

                              therefore the set will have = [ (0,0), (0,1), (1,0) ]

         for first island:   base = 2,4
                              index 1 = 2,4 - 2,4 = 0,0
                              index 2 = 2,4 - 3,4 = 1,0
                              index 3 = 2,4 - 3,3 = 1,1

                              therefore the set will have = [ (0,0), (1,0), (1,1) ]

        - Since they don't have the same index's arraylist, therefore they are not identical
 */
public class a17_Number_of_Distinct_Islands {
    public static void main(String[] args) {

    }

    public static int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Set<List<String>> set = new HashSet<>();

        for( int i=0 ; i<n ; i++ ){
            for( int j=0 ; j<m ; j++ ){

                if( grid[i][j] == 1 && !visited[i][j] ){

                    ArrayList<String> currentList = new ArrayList<>();
                    DFS( grid, visited, i, j, i, j, currentList );

                    // After we get an index for an island we will store it in the final Set,
                    // and we get the same index string again the set will not add that since it only have unique elements
                    set.add( currentList );
                }
            }
        }

        return set.size();
    }

    public static void DFS( int[][] grid, boolean[][] visited, int baseRow, int baseCol, int r, int c, ArrayList<String> list ){

        /*

        if ( grid[r][c] == 0 || r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || visited[r][c] ){
            return;
        }

        this "grid[r][c] == 0" should be written after the range check
        if we check for the grid in start then the out of bound error will happen

         */
        if ( r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1 || grid[r][c] == 0 || visited[r][c] ){
            return;
        }

        int finalR = r - baseRow;
        int finalC = c - baseCol;

        // we will pass this to a function that will convert this a string
        list.add( toString(finalR,finalC) );
        visited[r][c] = true;

        DFS( grid, visited, baseRow, baseCol, r-1, c, list );
        DFS( grid, visited, baseRow, baseCol, r, c+1, list );
        DFS( grid, visited, baseRow, baseCol, r+1, c, list );
        DFS( grid, visited, baseRow, baseCol, r, c-1, list );
    }

    public static String toString( int r, int c ){

        return Integer.toString(r) + " " + Integer.toString(c);
    }

}
