package n_Binary_Tree;

/*
    Structure of a Binary Tree:

        - Just like we have `int value` and `Node next` in linkedList;

        - We have same things in the Tree also:
            1. int value
            2. Node Left
            3. Node Right

        - Just like in LL these nodes can be anywhere in the Memory similarly in BT these can also exist anywhere in the memory,
          and they point to their left and right child


    Properties:
                                            11 <- root
                                           /  \
                                          6    9
                                         /    / \ <- edge
                                        10   4   2
                                            / \
                                           1   3 <- leaf
                                          /
                                         20

        1. Root -> The topmost Node from where the tree originates

        2. Leaf -> The Node which have no children

        3. Size of a Tree -> The total numbers of Nodes available

        4. Child and Parent -> Any node which further have any node connect downwards, ie their child
                               2 is child of 9,
                               10 is child of 6,
                               9 is parent of 4 and 2,
                               6 is parent of 10.

        5. Siblings -> Any Two nodes coming from a single node are siblings to each other
                       1 and 3 are children of 4 ie, 1 and 3 are siblings
                       4 and 2 are siblings
                       6 and 9 are siblings

        6. Edge -> Two node connected by a line is knows as Edge

        7. Height -> Maximum numbers of edges from that node to the leaf node
                     eg: height of node 11
                         to leaf 10 = 2
                         to leaf 20 = 4
                         to leaf 2 = 2
                         to leaf 3 = 3

                         Therefore, the maximum height is 4.

        8. Levels -> Subtract height of root - height of node
                     Root Level is always 0

        9. Ancestor and Descendant -> if we can find a path from top node to the bottom node
                                      then the top node is Ancestor and below Node are their descendants

 */
