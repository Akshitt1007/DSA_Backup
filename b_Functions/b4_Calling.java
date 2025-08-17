package b_Functions;

import java.util.Arrays;

public class b4_Calling {
    public static void main(String[] args) {
        /*
        1) Call by Value:

        In Java, when you pass primitive values (like int, float, char, etc.) to a function, the function creates a copy of those values.
        The original variables in the calling function (e.g., main) and the parameters in the called function (add) are entirely separate.

        Key Points:
        1) The function gets copies of the values, not the original variables themselves.
        2) Modifying the parameter values in the function does not affect the original variables in the caller.

         */
        int a = 10;
        int b = 20;

        add(a, b); // Passing values to the add function
        System.out.println("In main, a: " + a + ", b: " + b); // Original variables are unchanged

        /*
        2) Call By reference:

        In Java, when we pass an object reference to a function, the reference itself is passed by value. However,
        this creates the effect of "call by reference," where both the original variable in the caller and the parameter in the
        called function point to the same object in memory.

        How it works:

        1) When you pass an object to a function, the reference (memory address) of that object is copied to the function's parameter.
        2) The copied reference points to the same object in memory.
        3) Changes to the object's fields inside the function are reflected in the caller because the object itself is shared.
        4) However, if you assign a new object to the parameter, it only affects the local copy of the reference and does not change the original reference in the caller.
         */

        int [] arr = {1,2,3,4,5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        change(arr);
        System.out.println("Edited Array: " + Arrays.toString(arr));


        int [] arr1 = {1,2,3,4,5};
        change2(arr1);
        System.out.println("Single element: " + arr1[0]);

        /*
            Passing String:

            In Java, strings are immutable, which means that any operation that modifies a string actually creates a new object rather
            than changing the original string.

            How it Works:
            1) Strings are Immutable: Once a string object is created, its value cannot be changed.
               Any operation that seems to modify a string actually results in the creation of a new string object.

            2) Pass-by-Value for References: When you pass a string to a function, the reference (memory address) to the string object is passed by value.
               The parameter in the function points to the same string object.

            3) Modification Creates a New Object: If you try to modify the string inside the function, a new string object is created, and
               the function's parameter now points to this new object. The original string in the caller remains unchanged.
         */

        String name = "Akshit";
        System.out.println("Before: " + name);
        change_name(name);
        System.out.println("After: " + name);
        // Basically String are immutable in nature and when we pass a string in function its memory location(reference) is passed on to the
        // parameters of the function and they both are now pointing the same array :                              main function -> String <- Function
        // but if we try to change the String it will create a new String instead of editing the original String : main function -> String  Function -> new_String
    }

    private static void change_name(String naam) {
        naam = "Abhinav";
    }

    private static void change2(int[] arr1) {
        //arr1 = new int[]{3, 4, 5, 6, 7};
        arr1[0] = 99 ;
    }

    private static void change(int[] arr) {
        arr[0] = 99 ;
    }

    static void add(int x, int y) {
        // These x and y are the copies of a , b in main function
        x = x + y; // Modifying the copy of x
        y = x - y; // Modifying the copy of y
        System.out.println("In add, x: " + x + ", y: " + y); // Only changes the copies
    }
}
