package n_Binary_Tree;

/*
    Types of Binary Tress;

        1. Complete Binary Tree

            - All the levels in these Trees are full
            - apart from the last level
            - but last level is full from left to right

                        11          <- Complete Binary tree
                       /  \
                      6    9
                     /    / \
                    10   4   2
                   /  \
                  1    3

                        11          <- This is not a complete BT since in the last level the left most Node is not completely full
                       /  \            and the 4 is having a node to
                      6    9
                     /    / \
                    10   4   2
                   /    /
                  1    3


        2. Full Binary tree or Strict Binary tree

            - When every Node have either 0 children or 2 children

                        11          <- Full Binary tree
                       /  \
                      6    9
                          / \
                         4   2
                        / \
                       2   4

                        11          <- Not a full Binary Tree since 2 is having a one node
                       /  \
                      6    9
                          / \
                         4   2
                        / \   \
                       2   4   99


        3. Perfect Binary Tree

            - When Every Node have 2 Children
            - And every node is on the same level

                           1        <- Perfect Binary Tree (4 levels)
                        /     \
                      2         3
                    /  \      /   \
                   4    5    6     7
                  / \  / \  / \   / \
                 8  9 10 11 12 13 14 15


        4. Height Balance Binary Tree

            - Average Height of O( log n )
            - Famous example: AVL Tree (self-balancing BST).

                         10
                        /  \
                       5    15
                      / \   /
                     2   7 12

            - Node 10: left height = 2, right height = 2 → ✅
            - Node 5: left height = 1, right height = 1 → ✅
            - Node 15: left height = 1, right height = 0 → ✅


        5. Skewed Binary Tree

            - a tree that’s leaning entirely to one side like a tower about to fall over.
            - A binary tree is skewed if all nodes have only one child (either all left or all right).
                a) Left-skewed → each node has only a left child.
                b) Right-skewed → each node has only a right child.

             Right skewed BT:                                    Left skewed BT:

                1                                                        1
                 \                                                      /
                  2                                                    2
                   \                                                  /
                    3                                                3
                     \                                              /
                      4                                            4



        6. Ordered Binary Tree

            - Every node have some property with them
            - Example: Binary Search Tree

 */
