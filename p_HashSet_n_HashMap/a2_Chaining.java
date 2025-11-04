package p_HashSet_n_HashMap;

/*
    What is Collision?

        A hash table’s purpose is to convert a key into an index (slot)
        using a hash function. However, sometimes two different keys
        are mapped to the same index — this situation is called a *collision*.

        To handle collisions, there are two common techniques:
          1. Chaining (Separate Chaining)
          2. Open Addressing

    1. Chaining (Separate Chaining)

        Basic Idea:
        - If multiple keys are hashed to the same slot,
        - we store them together in a linked list (or chain) at that index.
        - In other words, each slot in the hash table acts as the head
        - of a linked list.

        Example:
        Suppose the hash table size = 5
        and the hash function = key % 5

        Slot    Keys (after hashing)
        ----------------------------
        0       10, 20
        1       6
        2       7, 12
        3       -
        4       9

        Here, both 10 and 20 produce the same remainder (0),
        leading to a collision. Therefore, both keys are stored
        in a linked list at slot 0.

    Advantages:
        - Simple and easy to implement
        - No issue of table overflow — lists can dynamically grow
        - Deletion is straightforward

    Disadvantages:
        - Requires extra memory for linked lists
        - Slightly slower cache performance since list nodes are scattered in memory

    Summary:
        - Chaining handles collisions by maintaining a list of all elements
          that hash to the same slot, keeping the table organized and efficient
          even when multiple collisions occur.
*/

public class a2_Chaining {
}
