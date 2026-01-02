package r_Graphs;

import java.util.ArrayList;

/*

    In Trees:

    You get Inorder, Preorder, Postorder because:
    - A tree has a strict structure: every node has a left child and a right child.
    - That left–root–right pattern gives birth to these three beautiful traversals.
    - Trees never have cycles, so traversal is predictable like an old-school ritual.

    In Graphs:

    - Graphs don’t follow rules. They’re wild, messy, full of cycles, and neighbors have no “left” or “right.”
    - There is NO inorder, NO preorder, NO postorder in general graphs.

    Why?
        Because those orders depend on a left–right arrangement and graphs don’t have any such direction.

 */
public class a5_DFS_Traversal {
    public static void main(String[] args) {
        int n = 8;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(1);
        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(3);
        adj.get(4).add(8);

        adj.get(5).add(2);
        adj.get(6).add(2);
        adj.get(7).add(3);
        adj.get(7).add(8);
        adj.get(8).add(4);
        adj.get(8).add(7);

        int[] visited = new int[n+1];
        ArrayList<Integer> traversal = new ArrayList<>();

        DFS(1, adj, visited, traversal);
    }

    public static ArrayList<Integer> DFS( int node, ArrayList<ArrayList<Integer>> adj , int[] visited , ArrayList<Integer> traversal ){

        // Step 1: Mark current node as visited
        visited[node] = 1;

        // Step 2: Add node to DFS traversal list
        traversal.add(node);

        // Step 3: Get all neighbours of current node
        ArrayList<Integer> neighbours = adj.get(node);

        // Step 4: Visit each unvisited neighbour
        for (int i = 0; i < neighbours.size(); i++) {

            int currentNeighbour = neighbours.get(i);

            // Only visit if not visited already
            if (visited[currentNeighbour] == 0) {
                DFS(currentNeighbour, adj, visited, traversal);
            }
        }

        // Step 5: Return final traversal list
        return traversal;

    }
}
/*
                1
               / \
              2   3 ---- 4
             / \   \     |
            5   6   7 -- 8

        /*
    Depth First Search (DFS) Explanation
    Starting Node: 1

    Adjacency List Representation:

        1 -> {2, 3}
        2 -> {1, 5, 6}
        3 -> {1, 4, 7}
        4 -> {3, 8}
        5 -> {2}
        6 -> {2}
        7 -> {3, 8}
        8 -> {4, 7}

    ---------------------------------------------------------
    DFS PROCESS (Refined, Completed, and Fully Structured)
    ---------------------------------------------------------

    1. First, create a visited array of size n+1 to mark
       which nodes have already been visited during DFS.

       Example:
           visited[n+1] = {false}

    2. Since our starting node is 1, we mark visited[1] = true
       and explore its adjacency list {2, 3}.

    3. The first neighbour of 1 is 2. Since it is unvisited,
       move to node 2 and mark visited[2] = true.

    4. In the adjacency list of 2 → {1, 5, 6}:
         - 1 is already visited, so ignore it.
         - Next is 5.

    5. Move to node 5 and mark visited[5] = true.
       Its adjacency list is {2}, which is already visited.
       No further nodes to explore → backtrack to node 2.

    6. From node 2, after 5, the next neighbour is 6.
       Move to node 6 and mark visited[6] = true.
       Its adjacency is {2} which is already visited.
       No further nodes → backtrack to node 2, then to node 1.

    7. Back at node 1, after completing 2, the next neighbour is 3.
       Move to node 3 and mark visited[3] = true.

    8. Adjacency list of 3 → {1, 4, 7}
         - 1 is visited → ignore
         - Next is 4

    9. Move to node 4 and mark visited[4] = true.
       Adjacency list is {3, 8}
         - 3 is visited → skip
         - Next is 8

   10. Move to node 8 and mark visited[8] = true.
       Adjacency list → {4, 7}
         - 4 is visited → skip
         - Next is 7

   11. Move to node 7 and mark visited[7] = true.
       Adjacency list → {3, 8}
         Both are already visited → dead end.

       Backtrack to 8 → 4 → 3 → 1.

   12. All neighbours have been explored.
       DFS is complete.

    ---------------------------------------------------------
    FINAL DFS TRAVERSAL ORDER:
        1 -> 2 -> 5 -> 6 -> 3 -> 4 -> 8 -> 7
    ---------------------------------------------------------

    This completes the DFS traversal starting from node 1.
*/
