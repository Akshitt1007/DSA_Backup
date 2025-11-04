package o_Heaps;


/*
    What are Heaps?

        A Heap is technically implemented as an array, but visualized as a binary tree — more precisely,
        a complete binary tree (every level is filled except maybe the last, and it’s filled from left to right).

        A Heap is a complete binary tree that also follows the heap property:

        - In a Max-Heap, every parent’s value is greater than or equal to its children.
        - In a Min-Heap, every parent’s value is smaller than or equal to its children.

                50
               /  \
             30    40
            / \    /
           10 20  35


    Why use Heaps?

        - Suppose we have to find the smallest or largest element in an unsorted array of size 100.
        - In an unsorted array, finding min/max requires checking all elements, giving a time complexity of O(n).
        - To get such an element in O(1) time, one idea is to keep the array sorted at all times.
        - This means every time we insert a new element, we’d have to sort or reinsert it in order,
        - which makes the insertion cost O(n log n) (because sorting or maintaining order is expensive).

        To reduce this overhead, we use a Heap, which lets us:
        - Access the smallest/largest element in O(1)
        - Insert or delete elements in O(log n)
        - Build the entire heap from an array in O(n)

    - A heap gives us the power of instant access (O(1)) to the smallest or largest element without the heavy cost of full sorting every time (O(n log n)).


    Structure:
                 0   1   2   3  4  5  6  7  8
        arr[] = [16, 14, 10, 8, 7, 9, 3, 2, 4] -> This is an Array of the form Max-Heap in which we will be getting the maximum number of top
                here, 16 is the root and all the number after are sorted in such a way that will be aligned to their respected parent root


                            16
                           /  \
                         14    10
                        /  \   /  \
                       8    7 9    3
                      / \
                     2   4

        - here 2 has index of 7
        - so 7/2 = 3.5 = 3
        - and index 3 = 8

        - which is the parent of child 2
        - so the array is formed such the way, when the index/2 will be giving their parent index

        Heap Index Formulas:

        For a node at index i:
            Left child → at index 2i + 1
            Right child → at index 2i + 2
            Parent → at index (i - 1) / 2 (integer division)



 */
