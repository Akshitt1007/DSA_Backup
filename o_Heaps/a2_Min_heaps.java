package o_Heaps;

import java.util.ArrayList;

class MinHeaps{

    public static ArrayList<Integer> heap = new ArrayList<>();

    // 1. Adding Element
    public static void addElement( int num ){

        // Adding the element in the last
        heap.add( num );

        int index = heap.size()-1;
        int parent = (index - 1) / 2;

        // Bubble up
        // When the element in end does not follow the rule ie it should be greater than the parent then we would be swapping it with parent
        // and there are many cases in which the element added is again smaller than the parent of the parent class so we would be checking until this rule is satisfied
        while( index > 0 && heap.get(index) < heap.get(parent) ){
            swap( index, parent );

            // after swapping we have to check again for the upper parent
            // that's why we have updated the index and parent here again
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // 2. Swapping the element with the parent
    public static void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // 3. Removing from top
    public static int remove() {

        if (heap.size() == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int min = heap.get(0);                                    // store min value to return later
        int lastElement = heap.remove(heap.size() - 1);     // remove last element

        // if it was the last element
        if (heap.size() == 0) {
            return min;
        }

        // Move last element to root
        // Once we have the last element on top
        // We will check it with its left and right child
        // and if it bigger than we will swap until the Min-Heap condition is satisfied
        heap.set(0, lastElement);

        // Bubble down
        int index = 0;
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            // Check left child
            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            // Check right child
            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            // If parent is smaller than both children, heap is valid
            if (smallest == index) {
                break;
            }

            // Otherwise, swap and continue
            swap(index, smallest);
            index = smallest;
        }

        return min;
    }

    // 4. Display
    public static void display(){
        for( int i=0 ; i<heap.size(); i++ ){
            System.out.print( heap.get(i) + " ");
        }
    }

    // 5. Get Min
    public static int min(){
        return heap.get(0);
    }

    // 6. Heap Sort
    public ArrayList heapSort(){

        ArrayList data = new ArrayList<>();
        while( !heap.isEmpty() ){
            data.add(this.remove());
        }
        return data;
    }
    /*
        - Here, we repeatedly remove the top element (min for Min-Heap).
        - Every removal guarantees you get the next smallest element, because that’s how the heap property works.
        - You collect these removed elements in a list → that list is now sorted.
        - The heap itself gets emptied in the process.
        - TC - o( n log n )
     */
}
public class a2_Min_heaps {
    public static void main(String[] args) {

        MinHeaps h1 = new MinHeaps();

        h1.addElement( 16 );
        h1.addElement( 14 );
        h1.addElement( 10 );
        h1.addElement( 8 );
        h1.addElement( 7 );
        h1.addElement( 3 );
        h1.addElement( 2 );
        h1.addElement( 4 );

        h1.display();
        System.out.println();
//
//        System.out.println( h1.min() );
//
//        h1.remove();
//        System.out.println( h1.min() );

        ArrayList list = h1.heapSort();
        System.out.println( list );
    }
}
