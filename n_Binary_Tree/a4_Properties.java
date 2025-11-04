package n_Binary_Tree;

/*

    Properties:

        1. In a Perfect Binary Tree of height h;
           the total number of nodes are =  2 ^ ( height + 1 ) - 1;

        2. Total number of leaf nodes in a Perfect Binary Tree:
            =   2 ^ height

        3. Total number of internal nodes in a Perfect Binary Tree:
            =  [ 2 ^ ( height + 1 ) - 1 ] - [ 2 ^ height ] ie, =>  2 ^ height - 1

        4. If we have n number of leaves then, we have:
            = log (n + 1) , at least levels

        5. If we have n number of nodes then, we have:
            = log (n + 1) , minimum levels

        6. In strict Binary tree, if we have n leaf nodes, we have
            = n-1 , Internals nodes

            and if n internal nodes, then
            = n+1, Leaf Nodes

        7. For every node in the tree,
           the difference in the height of left subtree and right subtree of that node should be -1,0,1
           - such tree are known as Balanced Trees
 */
