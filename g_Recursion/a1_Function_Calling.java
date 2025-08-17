package g_Recursion;

public class a1_Function_Calling {
    public static void main(String[] args) {

        number1( 1 );
    }

    static void number1( int n ){
        System.out.println( n );
        number2(2);
    }
    static void number2( int n ){
        System.out.println( n );
        number3(3);
    }
    static void number3( int n ){
        System.out.println( n );
    }
}

/*
    1) While the function is not completely finished it will remain the stack

    2) And when the function is done completing its work it will be removed from the stack and will go back to the place form where it is called .
 */

/*
    How Function Calling Works (Step-by-Step with Stack Trace):

        1) Program starts with main()
            When we run the program, the main() method is the first to be executed and added to the stack.

                Stack:
                - main

        2) main() calls number1(1)
            Instead of closing main, Java jumps to number1, pushing it onto the stack.


                Stack:
                - number1
                - main

        3) Inside number1()
            It prints 1 and then calls number2(2).

                Stack:
                - number2
                - number1
                - main

        4) Inside number2()
            It prints 2 and calls number3(3).

                Stack:
                - number3
                - number2
                - number1
                - main

        5) Inside number3()
            It prints 3. There are no more calls, so number3 finishes and is removed from the stack.

                Stack:
                - number2
                - number1
                - main

        6) Back to number2()
            After number3 completes, control returns to number2, which now also finishes and is popped off.

                Stack:
                - number1
                - main

        7) Back to number1()
            Same thing—number1 has no further work, so it's removed.

                Stack:
                - main

        8) Finally, back to main()
            It finishes execution, and the stack is now empty.

                Stack:
                (empty)
 */
