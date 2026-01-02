package r_Graphs;

import h_OOPS.Interfacee.Extended_interface.A;

import java.util.ArrayList;

public class a19_Bipartite_Graph_DFS {
    public static void main(String[] args) {

    }

    private boolean dfs(
            int node,
            int col,
            int[] color,
            ArrayList<ArrayList<Integer>> adj
    ) {

        color[node] = col;

        ArrayList<Integer> neighbour = new ArrayList<>( adj.get(node) );
        // NORMAL LOOP instead of for-each
        for (int i = 0; i < neighbour.size() ; i++) {

            int it = neighbour.get(i);

            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, adj) == false) {
                    return false;
                }
            }
            else if (color[it] == col) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(
            int V,
            ArrayList<ArrayList<Integer>> adj
    ) {

        int[] color = new int[V];

        // initialize colors
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        // check all components
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, adj) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}
