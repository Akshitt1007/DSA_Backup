package r_Graphs;

import java.util.ArrayList;

class y{
    int node;
    int parent;
    public y( int node, int parent ){
        this.node = node;
        this.parent = parent;
    }
}

public class a13_Detect_Cycle_Using_DFS {
    public static void main(String[] args) {

    }

    public static boolean DFS( y nodes, ArrayList<ArrayList<Integer>> edges, boolean[] visited ){

        int node = nodes.node;
        int parent = nodes.parent;

        visited[node] = true;

        ArrayList<Integer> neighbours = edges.get(node);

        for( int i=0 ; i<neighbours.size(); i++ ){

            int neighbourElement = neighbours.get(i);

            if(!visited[neighbourElement]){
                if(DFS(new y(neighbourElement, node), edges, visited)){

                    return true;   // ✅ PASS CYCLE UP
                }
                /*
                    Even if a deeper recursion finds a cycle and returns true
                    → You don’t pass it upward
                    → And at the end, you always return false
                 */
            }
            else if( visited[neighbourElement]  && parent != neighbourElement ){
                return true;
            }
        }

        return false;
    }
}
