package h_OOPS.Lambda_Expressions;

import java.util.ArrayList;
import java.util.function.Consumer;

/*
        - Lambda expressions, introduced in Java 8, provide a concise way to represent anonymous functions.
        They are essentially unnamed methods that can be treated as values and passed as arguments to other methods,
        enabling a more functional programming style in Java.

        A lambda function in Java is basically:
           -  A method without a name (anonymous function).
           -  Can be written directly where you need it (inside main or anywhere) instead of creating a separate method.
           -  Lets you pass behavior (code) as data — for example, into methods like forEach().
           -  Makes code shorter and more readable when the operation is simple.

        We can do complex stuff inside a lambda… but :
            - If it’s short → use a lambda
            - If it’s long & messy → use the old method

        Syntax:
            (parameter1, parameter2, ..., parameterN) -> { statements; }
 */

public class a1_Lambda_Functions {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        for ( int i = 0 ; i < 5 ; i++ ){
            arr.add( i+1 );
        }

        /*
             What does forEach do?
                - forEach is a method from Java’s Iterable interface.
                - It loops over each element in the collection.
                - You give it a lambda function (short function) to tell it what to do for each element.
         */
        arr.forEach( (item) -> System.out.println( item*2) );
        /*
            The Lambda
                - (item) = parameter representing each element of arr in the loop.
                - System.out.println(item * 2) = the action to perform.
                - This means: take the element, multiply it by 2, and print it.
         */


        // -> Storing it in a Consumer
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i=0 ; i<5 ; i++ ){
            arr2.add( i+3 );
        }

        Consumer<Integer> store = (item) -> System.out.println( item*2 );

        System.out.println( store );    // This object will store a reference to a function(Lambda)
        arr2.forEach( store );
        // So instead of writing again lambda function
        // we will use its address stored in the Consumer store;

        // Consumer<Integer> store → holds the behavior (function) to execute
        // Printing 'store' only shows its object reference, not its output
        // The stored function runs only when 'accept()' is called (e.g., in arr.forEach)
    }
}

