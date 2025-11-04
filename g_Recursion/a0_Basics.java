/*

    📌 Void Return Type (No Answer Returned)

    What happens:

    1) Child call finishes → Returns nothing → Parent call continues
    2) Parent's variables stay exactly the same
    3) Parent makes its next recursive call with unchanged variables
    4) Results are collected in the shared list

    -> In void return type:

    a) No values are returned.

    b) Each recursive call just executes, maybe printing or modifying a shared structure.

    c) The parent doesn't store or receive anything back — it just calls the child, and that's it.


    📌 Value Return Type (Answer Returned)

    What happens:

    1) Parent calls two children (let’s say ans1 = left_child(), ans2 = right_child())
    2) Each child returns its answers upward
    3) Parent collects, combines, and returns to its parent
    4) This process bubbles up until the topmost call has the full answer

    -> In Return type:

    a) Each child call returns a value

    b) The parent call makes a local variable (e.g., left, right) to store what it gets from each child

    c) Then the parent combines those values and returns it to its parent
 */

