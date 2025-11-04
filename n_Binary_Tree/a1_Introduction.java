package n_Binary_Tree;

/*
    What is a Binary Tree?

        - A Binary Tree is a special type of data structure where:
        - Each node can have at most two children.
        - These children are usually called:
            -> Left child
            -> Right child

              1
             / \
            2   3
           / \
          4   5

    Core Terminology:

        1. Root    → the topmost node (like the CEO).
        2. Parent  → node with children.
        3. Child   → node coming out of a parent.
        4. Leaf    → node with no children.
        5. Height  → max depth of the tree (longest path from root to a leaf).
        6. Subtree → a tree within the tree.

    Why do we need Trees?

        - We can add, delete, find, transverse etc. in  O(log n) times
        - Efficiently Inserting and Deletion
        - The values in Trees are inserted in order
        - Like in Binary Search Tree(BST) - wrt to parent the right would be greater value and left would have lesser values
        - Its cost-efficient

    Limitation:

        - In case on unbalanced Binary tree, we will be having O( n )
        - and have to transverse the whole branch
        - eg:
                1
                 \
                  2
                   \
                    5
                     \
                      10
                       \
                        20
                         \
                          33
                            \
                             55
                              \
                               66

        - This is an unbalanced tree since all the child are on the right side

        - In order to overcome this Limitation
        - we have "SELF BALANCE BINARY TREE"

    Implementation:

        There are two ways to implement a Binary Tree:

        1. By Node like Linked List

        2. Sequential way (Using Array) -> This is less effective since there can be null value which will leave empty spaces in the array
                                           This will be using in algorithm like Heaps etc.
                                           and Complete Binary Tree.
 */




