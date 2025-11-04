package o_Heaps;

import java.util.ArrayList;

class MaxHeaps {

    public static ArrayList<Integer> heap = new ArrayList<>();

    // 1. Adding Element
    public static void addElement(int num) {

        // Add element at the end
        heap.add(num);

        int index = heap.size() - 1;
        int parent = (index - 1) / 2;

        // Bubble up
        // If element is bigger than parent, swap
        while (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // 2. Swap elements
    public static void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // 3. Remove top element (maximum)
    public static int remove() {

        if (heap.size() == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (heap.size() == 0) {
            return max;
        }

        heap.set(0, lastElement);

        // Bubble down
        int index = 0;
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < size && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == index) break;

            swap(index, largest);
            index = largest;
        }

        return max;
    }

    // 4. Display
    public static void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
    }

    // 5. Get Max
    public static int max() {
        return heap.get(0);
    }

}

public class a3_Max_heaps {
    public static void main(String[] args) {

        MaxHeaps h1 = new MaxHeaps();

        h1.addElement(16);
        h1.addElement(14);
        h1.addElement(10);
        h1.addElement(8);
        h1.addElement(7);
        h1.addElement(3);
        h1.addElement(2);
        h1.addElement(4);

        System.out.println("Heap Elements:");
        h1.display();
        System.out.println();

        System.out.println("Max Element: " + h1.max());

        h1.remove();
        System.out.println("New Max Element after removal: " + h1.max());
    }
}
