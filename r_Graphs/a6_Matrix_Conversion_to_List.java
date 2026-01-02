package r_Graphs;

import java.util.ArrayList;

public class a6_Matrix_Conversion_to_List {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 0},
                {0, 0, 1, 0}
        };

        ArrayList<ArrayList<Integer>> adjList = convert(matrix);

        // Print adjacency list
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
    }

    public static ArrayList<ArrayList<Integer>> convert(int[][] matrix) {
        int n = matrix.length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        return adjList;
    }
}
