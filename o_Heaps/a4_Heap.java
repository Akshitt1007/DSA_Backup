package o_Heaps;

import java.util.ArrayList;

// This is same as the a2_Min_Heaps
// This is for all type of Heaps
// The a2_Min_Heap is for only int value

class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;
    public Heap() {
        list = new ArrayList<>();
    }

    // 1. Swapping the parent and child
    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    // 2. To get parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // 3. To get left child index
    private int left(int index) {
        return index * 2 + 1;
    }

    // 4. To get right child index
    private int right(int index) {
        return index * 2 + 2;
    }

    // 5. Adding the element
    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }
    // If any element is not following the condition we have re adjust the structure
    private void upheap(int index) {
        if(index == 0) {
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    // 6. Removing the element from the top
    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);

        T last = list.remove(list.size() - 1);

        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }
    // After removing the element from the top we have to reconstruction the Heap Structure
    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if(min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception{

        ArrayList<T>data = new ArrayList<>();
        while( !list.isEmpty() ){
            data.add(this.remove());
        }
        return data;
    }
}

public class a4_Heap {
    public static void main(String[] args) throws Exception{

        Heap<Integer> h1 = new Heap<>();

        h1.insert( 16 );
        h1.insert( 14 );
        h1.insert( 10 );
        h1.insert( 8 );
        h1.insert( 7 );
        h1.insert( 3 );
        h1.insert( 2 );
        h1.insert( 4 );

        ArrayList list = h1.heapSort();
        System.out.println( list );
    }
}
