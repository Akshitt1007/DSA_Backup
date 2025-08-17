package c_Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class c5_ArrayList {

    public static void main( String[] args ){
        Scanner in = new Scanner(System.in);

        /*
        1) An ArrayList in Java internally uses an array to store elements. When the array reaches its capacity,
           the ArrayList automatically resizes itself (typically by 50% of its current size).

        2) You can control the initial capacity when creating an ArrayList using the constructor: new ArrayList<>(initialCapacity).

        Syntax:

        ArrayList<Type> listName = new ArrayList<Type>(initialCapacity);

        ex=> ArrayList<Integer> list = new ArrayList<Integer>( 10 );

        1) list -> is the name of objected created in heap memory
                is a reference variable pointing towards the Arraylist created in the heap memory

        2) <Integer> -> is the datatypes of element that we want to store in the list
                     it can't be of primitive datatype

        3) (10) -> is the initial Capacity that we set our list to

         */

        ArrayList<Integer> list = new ArrayList<Integer>(5);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);


        System.out.println("Array: " + list);

        list.set(0, 69);    // This will change the element at index 0 of the array

        System.out.println("Modified Array: " + list);

        System.out.println("Check: "+ list.contains(10));  // This will check whether the given number is in the array or not

        list.remove(2); // removes the element at the given index
        System.out.println("element at Index 2 removed: " + list);


        // Taking input :
        ArrayList<Integer> list2 = new ArrayList<>(5);

        System.out.println("Enter the element in List: ");
        for( int i = 0 ; i < 5 ; i++ ){
            list2.add( in.nextInt() );
        }

        System.out.println(list2);

        // to get a specific element in the list we cannot access it using the " list[index] " method like we do in array we use => List.Get(index)
        System.out.println(list2.get(3));

        /*

        Working:
            1) This ArrayList have a fixed size internally and this fixed size is given by us in the syntax (initial size)
            2) let the initial size = 3
            3) list = [1,2,3]
            4) when the list is 50% filled it will create another list in the heap memory with double the initial size and will copy the previous list element in it
                list = [1, 2, 3, null, null, null]
            5) after creation of new list of double size the previous list is deleted
            6) This keeps on repeating.

            1) Initial size: Set by the user (e.g., 3).
            2) Size: The number of elements added to the list, which can grow over time.
            3) Resize Trigger: When the list reaches its internal capacity, a new larger array is created (typically double the previous size).
            4) Element Copy: The elements from the old array are copied into the new array.
            5) Old Array Deletion: Once the new array is allocated, the old array is discarded.
            6) Repetition: The resizing and copying process repeats as the list grows.

         */



//        ArrayList<String> bye = new ArrayList<>(2);
//        bye.add("Akshit");
//        bye.add("Abhinav");
//        bye.add("Aryan");
//        bye.add("Aditya");
//
//        System.out.println(bye);

    }
}
