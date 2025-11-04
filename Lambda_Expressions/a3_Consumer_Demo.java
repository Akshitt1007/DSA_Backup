package h_OOPS.Lambda_Expressions;
/*
    Lambda Expression with Consumer Interface - Notes

    1. Purpose:
       - To store a lambda function (behavior) in a variable, so it can be reused later.
       - Consumer<T> is a functional interface from java.util.function that represents
         an operation that takes one argument (of type T) and returns no result.

    2. Syntax:
       Consumer<Integer> store = (item) -> System.out.println(item * 2);
       - "store" holds the lambda expression.
       - (item) is the parameter.
       - The body defines what to do with the parameter.

    3. How it works:
       - The variable 'store' stores a reference to the lambda function.
       - Printing 'store' only shows the object reference, not the output.
       - The function runs only when its accept() method is called directly
         OR when passed to another method (e.g., arr.forEach(store)).

    4. Benefits:
       - Avoids writing the same lambda multiple times.
       - Makes code cleaner and reusable.
       - Allows passing behavior (function) like a variable.

    5. Example Flow:
       - arr.forEach(store);
         → forEach() calls store.accept(item) for each element in arr.
         → The lambda prints item * 2 for every element.

    6. Key Point:
       - Lambdas are objects that implement functional interfaces.
       - In this case, 'store' is an object that implements Consumer<Integer>
         and executes the provided logic when accept() is called.

    7. Memory diagram:

        [ Main Thread Stack ]         [ Heap Memory ]
        -------------------------------------------------------
        store  ---------------------> Lambda Object
                                      implements Consumer<Integer>
                                      accept(item):
                                        System.out.println(item*2)

        arr ------------------------> ArrayList object
                                       ├── Integer(1)
                                       ├── Integer(2)
                                       ├── Integer(3)
                                       ├── Integer(4)
                                       └── Integer(5)
*/



public class a3_Consumer_Demo {
    public static void main(String[] args) {

        a3_Consumer_Demo myCalculator = new a3_Consumer_Demo();

        Operation sum = (a, b) ->  a + b ;
        Operation sub = (a, b) ->  a - b ;
        Operation prod = (a, b) ->  a * b ;

        System.out.println( myCalculator.operate( 5, 5, sum ));
        System.out.println( myCalculator.operate( 5, 5, sub ));
        System.out.println( myCalculator.operate( 5, 5, prod ));
    }

    private int operate( int a, int b, Operation op ){
        return op.operation(a, b );
    }
}

interface Operation{
    int operation( int a, int b );
}
