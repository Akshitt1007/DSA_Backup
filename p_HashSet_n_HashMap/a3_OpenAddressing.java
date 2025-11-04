package p_HashSet_n_HashMap;


/*
    2. Open Addressing

        Basic Idea:
        - When a collision occurs, we don’t store the new key outside the table (like in chaining).
        - Instead, we keep everything inside the hash table itself.
        - If a slot is already occupied, we search for the next available empty slot and insert the key there.

        Example:
        Table size = 5
        Hash function = key % 5

        Now inserting: 10, 15, 20

        Step   Key   hash(key)   Action
        --------------------------------------------
        1      10       0        Slot 0 empty → put 10
        2      15       0        Slot 0 full → check slot 1 → put 15
        3      20       0        Slot 0 full, slot 1 full → slot 2 empty → put 20

        Resulting Table:
        ----------------
        Index   Value
        0       10
        1       15
        2       20
        3       -
        4       -

        Searching:
        - While searching, follow the same probing sequence.
        - Keep checking subsequent slots until you find the key
          or reach an empty slot (which means the key isn’t present).

        Types of Open Addressing:
        - Linear Probing     → next_slot = current + 1
        - Quadratic Probing  → next_slot = current + 1², +2², +3², ...
        - Double Hashing     → next_slot = (current + i * hash2(key)) % table_size

    Advantages:
        - Space-efficient (no extra linked lists)
        - Cache-friendly since data is stored contiguously in memory

    Disadvantages:
        - Clustering can occur (multiple keys get grouped together)
        - Deletion is more complex and requires special handling

    Summary Comparison:
        Feature            | Chaining                  | Open Addressing
        ---------------------------------------------------------------
        Storage            | Linked list per slot      | All inside the table
        Space              | Extra memory required     | Fixed table size
        Deletion           | Simple and direct         | Complicated
        Performance        | Stable with high load     | Slows down when table fills
        Simplicity         | Easier to code            | Needs careful probing logic

    In One Line:
        - Chaining → “Store outside using a list.”
        - Open Addressing → “Adjust everything inside the table.”

*/

public class a3_OpenAddressing {
}
