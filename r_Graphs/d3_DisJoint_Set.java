package r_Graphs;

/*
                    DisJoint Sets (Union Find)

            Given two graph components, let say:

                Component 1:
                1 - 2 - 3 - 4

                Component 2:
                5 - 6

            If questioned whether node 1 and node 5 are part of the same graph/component or not,

            Using a normal DFS/BFS approach:
                - We will start DFS/BFS from node 1
                - Traverse all reachable nodes from 1
                - When traversal ends, we check the visited array
                - If both nodes (1 and 5) are marked visited → same component
                - Else → different components

            This approach is correct but not efficient.

                Time Complexity:
                O(V + E) ≈ O(n) for one single query

            If such queries are asked multiple times, DFS/BFS becomes very costly.


            ------------------------------------------------------------
            Here Disjoint Set plays a crucial role.

                - Disjoint Set tells us whether two nodes belong to the same
                  connected component or not.

            But why do we need this in constant time?

                - Because many problems deal with DYNAMIC GRAPHS


                Dynamic Graph:
                    A graph whose structure changes over time
                    (edges are added gradually).

                Example:

                    n = 4
                    edges = [ [1,2], [2,3], [3,4] ]

                    Initially:
                        1    2    3    4
                        (all nodes are isolated)

                    After adding first edge:
                        1 - 2    3    4

                    If asked here:
                        "Are node 1 and node 4 in the same component?"

                    Disjoint Set Answer:
                        NO (in constant time)


                    After adding all edges:
                        1 - 2 - 3 - 4

                    If asked again:
                        "Are node 1 and node 4 in the same component?"

                    Disjoint Set Answer:
                        YES (still in constant time)



        */

import java.util.ArrayList;

public class d3_DisJoint_Set {


    static class disjointSet{

        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();

        // When the constructor is made we will make these empty node
        // and assign them to rank 0 and mark them as their parent itself
        public disjointSet( int n ){
            for( int i=0; i<=n; i++ ){
                rank.add(0);
                parent.add(i);
            }
        }

        // This is Path Compression
        // To get the Ultimate Parent
        public int finding_ultimate_parent( int node ){

            if( node == parent.get(node) ){
                return node;
            }

            int currParent = parent.get( node );
            int ultimateParent = finding_ultimate_parent( currParent );
            parent.set( node, ultimateParent );

            return ultimateParent;
        }

        // This is the making of the tree structure
        public void union_by_Rank( int u, int v ){

            int ultimate_parent_u = finding_ultimate_parent( u );
            int ultimate_parent_v = finding_ultimate_parent( v );

            if( ultimate_parent_u == ultimate_parent_v ){
                return;
            }

            if( rank.get( ultimate_parent_u) < rank.get(ultimate_parent_v) ){
                parent.set(ultimate_parent_u, ultimate_parent_v );
            }
            else if( rank.get( ultimate_parent_u) > rank.get(ultimate_parent_v) ){
                parent.set(ultimate_parent_v, ultimate_parent_u );
            }
            else if( rank.get( ultimate_parent_u) == rank.get(ultimate_parent_v) ){
                parent.set(ultimate_parent_u, ultimate_parent_v );

                int ultimate_parent_rank = rank.get( ultimate_parent_v );
                rank.set(ultimate_parent_v, ultimate_parent_rank + 1 );
            }
        }
    }
    public static void main(String[] args) {

        disjointSet xyz = new disjointSet(7);

        xyz.union_by_Rank( 1, 2 );
        xyz.union_by_Rank( 2, 3 );
        xyz.union_by_Rank( 4, 5 );
        xyz.union_by_Rank( 6, 7 );
        xyz.union_by_Rank( 5, 6 );

        if( xyz.finding_ultimate_parent( 3) == xyz.finding_ultimate_parent( 7) ){
            System.out.println( "Same Component " );
        }
        else{
            System.out.println( "Not Same Component ");
        }

        xyz.union_by_Rank( 3, 7 );

        if( xyz.finding_ultimate_parent( 3) == xyz.finding_ultimate_parent( 7) ){
            System.out.println( "Same Component " );
        }
        else{
            System.out.println( "Not Same Component ");
        }
    }

}

/*
        In Disjoint we have two Arrays

            Rank - To keep record which graph was the highest
            Parent - To keep the track of node parent

            Here we are making a different data structure other than graph
            It is a type of tree structure which helps us to chck component in constant time


        Time Complexity
            - The time Complexity for the Union by rank is
                            o(4α)
            - this 4α which is as good as constant

        Suppose our graph have 7 nodes, edges = [ [1,2],
                                                  [2,3],
                                                  [4,5],
                                                  [6,7],
                                                  [5,6],
                                                  [3,7] ]

        The formation of tree structure is done by Union (on the bases of Rank)

        ------------------------------------------------------------
        At first the nodes would be not be joined before these edges are made

        1     2     3      4     5     6      7

        rank = [ 0, 0, 0, 0, 0, 0, 0 ]      -> this means how many nodes are beneath that node (at first there are is no node beneath anyone => rank = 0 )
                 1  2  3  4  5  6  7

        parent= [ 1, 2, 3, 4, 5, 6, 7 ]     -> each node is parent of itself
                  1  2  3  4  5  6  7

        ------------------------------------------------------------
        After the first edges is formed ( by union() )

        what is union()?
            - This helps to connect edges from one node from another node

        Steps for Union() ?

            1. Find the ultimate parent of u and v ( pu, pv)
            2. find the ranks of pu and pv
            3. connect smaller rank parent to larges rank parent always
            4. In case they are equal join anyone to anyone

        ------------------------------------------------------------
        First Operation -> join node [1, 2], u = 1 and v = 2

        rank = [ 0, 0, 0, 0, 0, 0, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 2, 3, 4, 5, 6, 7 ]
                  1  2  3  4  5  6  7

        We see the parent of u = 1 is 1 itself and same for v = 2
        Therefore  the ultimate parent of u and v are themselves for now

        pu = 1 and pv = 2
        and rank = 0 in both parent

        if they are equal we can connect 1 -> 2 or 2 -> 1 our choice

        therefore we will add 2 to node 1

                    1
                   /
                  2

        Before they both were at equal level but after joining 2 to 1 the height increases from 0 -> 1
        therefore the rank of 1 increase (because now there is one node beneath it)
        and now the parent of 2 is one.

        rank = [ 1, 0, 0, 0, 0, 0, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 3, 4, 5, 6, 7 ]
                  1  2  3  4  5  6  7

        ------------------------------------------------------------
        Second Operation -> join node [2, 3], u = 2 and v = 3

        rank = [ 1, 0, 0, 0, 0, 0, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 3, 4, 5, 6, 7 ]
                  1  2  3  4  5  6  7

        now the ultimate parent of 2 is 1
        and ultimate parent of 3 is itself ie 3

        and rank of 1 is greater than 3
        so we will add 3 to 1


                        1
                       / \
                      2   3

        rank = [ 1, 0, 0, 0, 0, 0, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 5, 6, 7 ]
                  1  2  3  4  5  6  7

        Here the rank is not changed because the height remains same

        ------------------------------------------------------------
        Third Operation -> join node [4, 5], u = 4 and v = 5

        rank = [ 1, 0, 0, 0, 0, 0, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 5, 6, 7 ]
                  1  2  3  4  5  6  7

        Here the parents of 4 and 5 are themselves and rank are also same

        therefore join anyone to anyone

                    1             4
                   / \           /
                  2   3         5

        rank = [ 1, 0, 0, 1, 0, 0, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 4, 6, 7 ]
                  1  2  3  4  5  6  7

        the parent of 5 becomes 4 and rank of 4 changes to 1

        ------------------------------------------------------------
        Fourth Operation -> join node [6, 7], u = 6 and v = 7

        rank = [ 1, 0, 0, 1, 0, 0, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 4, 6, 7 ]
                  1  2  3  4  5  6  7


        Again same for 6 and 7

                    1             4           6
                   / \           /           /
                  2   3         5           7


        rank = [ 1, 0, 0, 1, 0, 1, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 4, 6, 6 ]
                  1  2  3  4  5  6  7

        ------------------------------------------------------------
        Fifth Operation -> join node [5, 6], u = 5 and v = 6


        rank = [ 1, 0, 0, 1, 0, 1, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 4, 6, 6 ]
                  1  2  3  4  5  6  7

        now the ultimate parent of 6 is itself with rank 1
        and the ultimate parent of 5 is 4 with rank 1
        again the rank is same so join 6 to 4


                    1             4
                   / \           / \
                  2   3         5   6
                                     \
                                      7

        now the parent of 6 is now 4
        and the rank of 4 also changes to 2

        rank = [ 1, 0, 0, 2, 0, 1, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 4, 4, 6 ]
                  1  2  3  4  5  6  7

       ------------------------------------------------------------
            - at this time of graph formation if someone ask that whether the node 1 and node 7 are of same component
            - we will simply chck the ultimate parent of each node
            - if they are same then yes they are same component else no they are not

            - parent[1] = 1
            - parent[7] = 6 and parent[6] = 4
            - 1 != 4
            => not same component

        ------------------------------------------------------------
        Sixth Operation -> join node [3, 7], u = 3 and v = 7

        rank = [ 1, 0, 0, 2, 0, 1, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 1, 1, 1, 4, 4, 4, 6 ]
                  1  2  3  4  5  6  7

        the ultimate parent of 3 = 1 with rank 1
        the ultimate parent of 7 is 4 with rank 2
        Therefore the 1 is lesser than 7
        so join 4 -> 7

                             4
                           / | \
                          1  5  6
                         / \     \
                        2   3     7

        rank = [ 1, 0, 0, 2, 0, 1, 0 ]
                 1  2  3  4  5  6  7

        parent= [ 4, 1, 1, 4, 4, 4, 6 ]
                  1  2  3  4  5  6  7

        ------------------------------------------------------------
            - at this time of graph formation if someone ask that whether the node 1 and node 7 are of same component
            - we will simply chck the ultimate parent of each node

            - parent[1] = 4
            - parent[7] = 6 and parent[6] = 4
            - 4 != 4
            => same component
 */
/*
        ----------------------- DISJOINT SET ( UNION FIND ) -----------------------

        In Disjoint Set we maintain two arrays:

            parent[]  - To keep track of the immediate parent of every node
            rank[]    - To roughly represent the HEIGHT of the tree

        IMPORTANT:
            - rank is NOT the number of nodes
            - rank ≈ height (depth) of the tree
            - rank only increases when two trees of SAME rank are merged

        This is NOT a graph.
        This is a special tree-based data structure used to track
        CONNECTED COMPONENTS efficiently.

        It helps us answer:
            "Are node u and node v in the same component?"

        in ALMOST CONSTANT TIME.

        --------------------------------------------------------------------------

        Time Complexity:

            - Union by Rank + Path Compression
            - Amortized Time Complexity = O( α(n) )

            where α(n) is the Inverse Ackermann function
            which grows so slowly that for all practical values:

                α(n) ≤ 4

            => Treated as constant time in real-world problems

        --------------------------------------------------------------------------
        Suppose we have:

            n = 7
            edges = [ [1,2],
                      [2,3],
                      [4,5],
                      [6,7],
                      [5,6],
                      [3,7] ]

        Initially, no nodes are connected.

        --------------------------------------------------------------------------
        Initial State:

            1     2     3     4     5     6     7

            rank   = [ 0, 0, 0, 0, 0, 0, 0 ]
                       1  2  3  4  5  6  7

            parent = [ 1, 2, 3, 4, 5, 6, 7 ]
                       1  2  3  4  5  6  7

            Each node is its own parent.
            Each tree has height 0.

        --------------------------------------------------------------------------
        What is UNION(u, v)?

            Steps:
                1. Find ultimate parent of u → pu
                2. Find ultimate parent of v → pv
                3. Compare rank of pu and pv
                4. Attach smaller rank tree under larger rank tree
                5. If ranks are equal → attach anyone and increase rank

        --------------------------------------------------------------------------
        First Operation -> union(1, 2)

            pu = 1 , pv = 2
            rank[1] = 0 , rank[2] = 0 (equal)

            Attach 2 under 1 (choice is arbitrary when equal)

                    1
                   /
                  2

            rank   = [ 1, 0, 0, 0, 0, 0, 0 ]
            parent = [ 1, 1, 3, 4, 5, 6, 7 ]

            Rank of 1 increases because height increased from 0 → 1

        --------------------------------------------------------------------------
        Second Operation -> union(2, 3)

            ultimate parent of 2 = 1
            ultimate parent of 3 = 3

            rank[1] > rank[3]

            Attach 3 under 1

                        1
                       / \
                      2   3

            rank   = [ 1, 0, 0, 0, 0, 0, 0 ]
            parent = [ 1, 1, 1, 4, 5, 6, 7 ]

            Rank does NOT increase because height remains same.

        --------------------------------------------------------------------------
        Third Operation -> union(4, 5)

            pu = 4 , pv = 5
            rank equal

            Attach 5 under 4

                    4
                   /
                  5

            rank   = [ 1, 0, 0, 1, 0, 0, 0 ]
            parent = [ 1, 1, 1, 4, 4, 6, 7 ]

        --------------------------------------------------------------------------
        Fourth Operation -> union(6, 7)

            pu = 6 , pv = 7
            rank equal

            Attach 7 under 6

                    6
                   /
                  7

            rank   = [ 1, 0, 0, 1, 0, 1, 0 ]
            parent = [ 1, 1, 1, 4, 4, 6, 6 ]

        --------------------------------------------------------------------------
        Fifth Operation -> union(5, 6)

            ultimate parent of 5 = 4 (rank = 1)
            ultimate parent of 6 = 6 (rank = 1)

            Ranks are equal → attach anyone
            Attach 6 under 4

                    4
                   / \
                  5   6
                       \
                        7

            rank   = [ 1, 0, 0, 2, 0, 1, 0 ]
            parent = [ 1, 1, 1, 4, 4, 4, 6 ]

            Rank of 4 increases because height increased.

        --------------------------------------------------------------------------
        Connectivity Check Example:

            Are node 1 and node 7 in the same component?

            find(1) → 1
            find(7) → 4

            1 != 4
            => NOT in same component

        --------------------------------------------------------------------------
        Sixth Operation -> union(3, 7)

            ultimate parent of 3 = 1 (rank = 1)
            ultimate parent of 7 = 4 (rank = 2)

            rank[1] < rank[4]

            Attach tree of 1 under 4

                             4
                           / | \
                          1  5  6
                         / \     \
                        2   3     7

            rank   = [ 1, 0, 0, 2, 0, 1, 0 ]
            parent = [ 4, 1, 1, 4, 4, 4, 6 ]

        --------------------------------------------------------------------------
        Final Connectivity Check:

            find(1) → 4
            find(7) → 4

            4 == 4
            => SAME COMPONENT

        --------------------------------------------------------------------------
        IMPORTANT ADDITION: PATH COMPRESSION

            During find(x), we directly connect x to its ultimate parent.
            This flattens the tree aggressively and guarantees near O(1) time.

            Without path compression → tree can be tall
            With path compression    → tree becomes almost flat

        --------------------------------------------------------------------------
        WHERE DISJOINT SET IS USED:

            - Kruskal’s Minimum Spanning Tree
            - Dynamic connectivity problems
            - Cycle detection in undirected graphs
            - Offline queries
            - Network connectivity systems
*/

/*
        -------------------------- PATH COMPRESSION --------------------------

        Path Compression is an OPTIMIZATION used in the find() operation
        of Disjoint Set.

        Its purpose is simple:

            "Once you find the ultimate parent of a node,
             make all nodes on the path point DIRECTLY to it."

        This avoids doing the same long traversal again and again.

        ----------------------------------------------------------------------

        Suppose the parent array looks like this:

            parent[] = [ 1, 1, 2, 3 ]
                         1  2  3  4

        This represents the following tree structure:

                    1
                     \
                      2
                       \
                        3
                         \
                          4

        Here:
            - 1 is the ultimate parent
            - 4 is at the deepest level

        ----------------------------------------------------------------------
        FIND OPERATION WITHOUT PATH COMPRESSION

        To find the ultimate parent of node 4:

            Step 1:
                node = 4
                parent[4] = 3
                4 != 3  → move up

            Step 2:
                node = 3
                parent[3] = 2
                3 != 2  → move up

            Step 3:
                node = 2
                parent[2] = 1
                2 != 1  → move up

            Step 4:
                node = 1
                parent[1] = 1
                node == parent[node]
                → STOP (ultimate parent found)

        Ultimate parent of 4 = 1

        PROBLEM:
            If we call find(4) again,
            we will repeat ALL these steps again.

        This is wasted work.

        ----------------------------------------------------------------------
        PATH COMPRESSION IDEA

        While returning from recursion,
        update the parent of EVERY node on the path
        to point DIRECTLY to the ultimate parent.

        In short:
            "Don’t remember the path.
             Remember the destination."

        ----------------------------------------------------------------------
        FIND OPERATION WITH PATH COMPRESSION

        Code idea:

            parent[node] = find(parent[node])

        Let’s apply it step by step for find(4):

        ----------------------------------------------------------------------
        Step-by-step execution of find(4):

        Call:
            find(4)

        Since 4 != parent[4] (3),
        we recursively call:

            find(3)

        ----------------------------------------------------------------------
        Call:
            find(3)

        Since 3 != parent[3] (2),
        we recursively call:

            find(2)

        ----------------------------------------------------------------------
        Call:
            find(2)

        Since 2 != parent[2] (1),
        we recursively call:

            find(1)

        ----------------------------------------------------------------------
        Call:
            find(1)

        Since parent[1] == 1,
        this is the ultimate parent.

        Return:
            1

        ----------------------------------------------------------------------
        NOW THE MAGIC HAPPENS (BACKTRACKING PHASE)

        While returning back:

            find(2):
                parent[2] = 1

            find(3):
                parent[3] = 1

            find(4):
                parent[4] = 1

        ----------------------------------------------------------------------
        UPDATED parent[] ARRAY AFTER PATH COMPRESSION

            parent[] = [ 1, 1, 1, 1 ]
                         1  2  3  4

        Tree becomes:

                    1
                  / | | \
                 2  3  4

        The tree is now FLAT.

        ----------------------------------------------------------------------
        BENEFIT AFTER PATH COMPRESSION

        Now if we call:

            find(4)

        Steps:
            parent[4] = 1
            parent[1] = 1
            DONE.

        Time taken: O(1)

        ----------------------------------------------------------------------
        KEY OBSERVATIONS

            - Path compression happens ONLY during find()
            - It does NOT change correctness
            - It drastically reduces tree height
            - Combined with Union by Rank:
                  → Amortized Time = O(α(n))

        ----------------------------------------------------------------------
        FINAL INTUITION

            First find may be slow.
            After that, the structure learns.

            DSU is lazy but smart:
            it remembers answers so it never works hard twice.

            Old path: 4 → 3 → 2 → 1
            New path: 4 → 1

*/

