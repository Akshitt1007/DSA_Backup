package r_Graphs;

import h_OOPS.Interfacee.Extended_interface.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
            Breadth First Search traversal (BFS)

    * It is the same kind of BFS traversal that we have done in Trees
    * We will be using this when we to traverse the tree from top to bottom level wise
    * But this will be different from the tree one
    * Here we have to check for the 1. Cycle
                                    2. Self-Loop
                                    3. Disconnected components



                                    1       - lvl 0            <- this is 1-index based graph ( the index is starting from 1 )
                                   / \
                                  2   3     - lvl 1
                                 / \ /  \
                                4   5    6  - lvl 2

                      - If the Starting Node is 1
                      - Then the traversal will go same as in the tree
                      - [1] [ 2, 3 ] [ 4, 5, 6 ]
                         1     2         3          <- levels

                                    1
                                   / \
                                  2   3
                                 / \ /  \
                                4   5    6

                        - If the Starting Node is 3
                        - Then 3 becomes level 0 by itself
                        - We do NOT keep 2 at the same level as 3
                        - We only check how far each node is from this starting node

                        - Nodes reachable with 1 edge from 3 = [1, 5, 6]
                          -> These are at level 1

                        - Node reachable with 2 edges from 3 = [2]
                          -> Path: 3 -> 1 -> 2
                          -> So this is level 2

                        - Node reachable with 3 edges from 3 = [4]
                          -> Path: 3 -> 1 -> 2 -> 4
                          -> So this is level 3

                        - Final BFS Level Order from node 3:
                          [3] [1, 5, 6] [2] [4]
                            0      1      2    3

 */
public class a4_BFS_Traversal {

    public static void main(String[] args) {

        // TOTAL 6 NODES (1 to 6)
        int nodes = 6;

        // Create adjacency list
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        // Add empty lists for each node
        for (int i = 0; i < nodes; i++) {
            edges.add(new ArrayList<>());
        }

        // Build the graph (0-based index)
        // 1 -> 2, 3
        edges.get(0).add(1);
        edges.get(0).add(2);

        // 2 -> 1, 4, 5
        edges.get(1).add(0);
        edges.get(1).add(3);
        edges.get(1).add(4);

        // 3 -> 1, 5, 6
        edges.get(2).add(0);
        edges.get(2).add(4);
        edges.get(2).add(5);

        // 4 -> 2
        edges.get(3).add(1);

        // 5 -> 2, 3
        edges.get(4).add(1);
        edges.get(4).add(2);

        // 6 -> 3
        edges.get(5).add(2);

        ArrayList<Integer> BFS = new ArrayList<>( traversal(nodes, edges) );
        System.out.println( BFS );
    }


    // nodes -> total numbers of nodes in the graph
    // Edges -> All the edges in the graphs
    public static ArrayList<Integer> traversal(int nodes, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<Integer> traversal = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        // To have the record of visited nodes
        boolean[] visited = new boolean[nodes];

        q.add(0);
        visited[0] = true;
        // Since we added the first node
        // we will mark it as true so that we don't visit that again

        while (!q.isEmpty()) {

            Integer currentNode = q.poll();
            traversal.add(currentNode);

            // Loop through all neighbours of currentNode
            // We will add all the adj node in this List
            // and chck if have not visited them we will add them in the queue
            ArrayList<Integer> neighbours = edges.get(currentNode);

            for (int i = 0; i < neighbours.size(); i++) {

                int adjNode = neighbours.get(i);

                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }

        return traversal;
    }

}



/*
    If my graph is:

        1
       / \
      2   3
     / \ / \
     4  5   6

    - and I traverse from node 1, first I store all the edges in an adjacency list.

    - Then I put node 1 in the queue and mark it visited.

        Queue = [1]

    - Next, I pop 1 and push its neighbors 2 and 3.

        Queue = [2, 3]
        visited = {1, 2, 3}

    - Now I pop 2.
    - 2 has neighbors 1, 4, 5 — but 1 is already visited,
    - so I only add 4 and 5.

        Queue = [3, 4, 5]

    * This happens because in a graph we use a visited list.
    * Each time we add a node into the queue, we immediately mark it visited,
    * so we don't add it again later and create cycles.


    -------------------------------
    BFS DRY RUN TABLE
    -------------------------------

    | Step | Current Node | Queue After Operation | Newly Added Neighbors | Visited Set        |
    |------|--------------|-----------------------|------------------------|---------------------|
    | 1    | -            | [1]                   | 1                     | {1}                |
    | 2    | 1            | [2, 3]                | 2, 3                  | {1, 2, 3}          |
    | 3    | 2            | [3, 4, 5]             | 4, 5                  | {1, 2, 3, 4, 5}    |
    | 4    | 3            | [4, 5, 6]             | 6                     | {1,2,3,4,5,6}      |
    | 5    | 4            | [5, 6]                | - (only neighbor 2 visited) | {1,2,3,4,5,6} |
    | 6    | 5            | [6]                   | - (neighbors 2 & 3 visited) | {1,2,3,4,5,6} |
    | 7    | 6            | []                    | - (neighbor 3 visited) | {1,2,3,4,5,6}     |

    Order of BFS traversal = **1, 2, 3, 4, 5, 6**
*/

