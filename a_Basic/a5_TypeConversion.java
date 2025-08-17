package a_Basics;

public class a5_TypeConversion {

//    public static void main(String[] args){
//
//          int num 1 = 30.5;
//          int num 2 = 40.7;

//          this will give error because the datatype is integer, and we are passing the value of float
//          to solve this :
//          int num1 = (int) 30.5; we do this and this is type casting
//          changing the 30.5 into int that is 30;
//
//        System.out.println( num1 + num2 );
//
//    }
    public static void main(String[] args){

        float num1 = 30;  // int 30 is automatically converted to float 30.0
        float num2 = 30;

        /*
        TYPE CONVERSION (Implicit Conversion)

         this will not the give error like above case
         here automatic type conversion takes that automatically converts the value of 'int' into 'float'
         For this automatic typecasting it must meet 2 conditions:

              a) both the datatypes must be compatible with each other it will not work for num1 = 10 and num2 = 'name'

              b) Destination type should be bigger than source type
                  like float > int , float is destination type since we are storing the output in float and int is source type which we are storing
                  float(8) > int(4)

        CASE I: double a = 10;

            -> 10 is an int by default.
            -> Java automatically promotes an int to a double. Why?
            -> Because there's no risk of data loss going from:

                ➤ int → double
                ➤ (from 32-bit whole number to 64-bit floating-point)

            -> Result: This is safe. Works like a charm.

        CASE II: int a = 10.1;

            -> 10.1 is a double by default.
            -> You're trying to store it in an int — that’s like trying to stuff a football into a mailbox.

                ➤ You'd lose the decimal/fractional part.
                ➤ Java says: "Whoa there, cowboy — I’m not doing that without your explicit permission."

            -> So it throws a compile-time error.
        */

        System.out.println( num1 + num2 );

        int number = 'A';   // char size = 1 byte
                            // int size = 4 byte
                            // automatically gets converted into the int since int > char
        System.out.println( number );



        /*
        TYPE CASTING (Explicit Conversion)

        In Java, you cannot directly assign a floating-point value (like 30.5) to an integer variable
        Sometimes it is needed to convert the 'float' into 'int' which can't be done automatically by the ide
        in order to do so we hava to perform TYPE CASTING
        which is also known as NARROWING CONVERSION
                because 'float' is a big value which would be narrowed by removing its discarding its decimal parts to fit into 'int'
         */

//        int num3 = 69.69f; // this would be error since float > int

        int num3 = (int)69.69f;     //This converts 69.69 to 69 (fractional part is discarded).
        // this would not give the error since we are telling to make it into 'int'

        System.out.println(num3);

        char character = 66;    // this does not require Type casting because this value likes within its value that is 0-65535
        char character2 = (char)65536 ; // since this is not lies in range thus requiring the Type casting
        System.out.println(character);
        System.out.println(character2);


        byte b = 42;
        char c = 'a';
        short s = 1024;
        int i = 50000;
        float f = 5.67f;
        double d = .1234;
        double result = (f * b) + (i / c) - (d * s);
        System.out.println((f * b) + " + " + (i / c) + " - " + (d * s));
        System.out.println("result = " + result);

        /*
        Let’s look closely at the type promotions that occur in this line from the program:

        double result = (f * b) + (i / c) - (d * s);

        In the first subexpression, f * b, b is promoted to a float and the result of the subexpression is float.

        Next, in the subexpression i/c, c is promoted to int, and the result is of type int. Then, in d * s, the value of s is
        promoted to double, and the type of the subexpression is double. Finally, these three intermediate values, float, int,
        and double, are considered. The outcome of float plus an int is a float. Then the resultant float minus the last double
        is promoted to double, which is the type for the final result of the expression.
        */
    }
}
