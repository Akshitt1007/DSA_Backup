package h_OOPS.Collection_Vector_Enum;

/*
    🔹 Why we need Vector?
        - Arrays are fixed size → can't grow once created.
        - Vector is a dynamic array → auto-expands when full.
        - Helpful for ordered, duplicate-allowed, resizable storage.

    🔹 What is Vector?
        - Legacy class (JDK 1.0), part of Collection Framework.
        - Implements List, RandomAccess, Cloneable, Serializable.
        - Works like ArrayList but methods are synchronized.

    🔹 Key Features:
        - Dynamic resizing (default 10 → doubles when full).
        - Maintains insertion order.
        - Allows duplicates.
        - Thread-safe (synchronized methods).
        - Slower than ArrayList due to locking.

    🔹 Vector vs ArrayList:
        - ArrayList: not synchronized → fast but unsafe in multithreading.
        - Vector: synchronized → safe but slower.
        - Modern way: Collections.synchronizedList(new ArrayList<>()).
 */

import java.util.List;
import java.util.Vector;

public class b1_Vector {
    public static void main(String[] args) {

        List<Integer> vectorList = new Vector<>();

        vectorList.add( 10 );
        vectorList.add( 12 );
        vectorList.add( 13 );
        vectorList.add( 14 );

        System.out.println( vectorList );
    }
}
