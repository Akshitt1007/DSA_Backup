package f_Strings;

import java.util.ArrayList;

//  Key Concept: Whenever a String is combined with an object, Java always uses the toString() method of the object—not String.valueOf()
//               in this case, as toString() is directly called on the object.

//  String Concatenation Behavior:
//          i) In Java, when you use the + operator between a String and any object, Java automatically calls the toString() method on the object.
//          ii) This is how Java converts the object into a String for concatenation.
/*
    What Java sees:

        String result = "Hello " + someObject;

        a) It translates this to:

        String result = "Hello " + String.valueOf(someObject);

        b) And String.valueOf() does the following:

        i)  If the object is null → it returns "null".
        ii) If the object is not null → it calls obj.toString().

 */


public class a6_Operators {
    public static void main(String[] args) {

        System.out.println( 'a' + 'b' );
        System.out.println( 'a' - 'b' );
        /*
            'a' and 'b' are characters (primitive char type).
            When you use the + operator on char, they are implicitly converted to their ASCII values and added together:

                ASCII value of 'a' is 97
                ASCII value of 'b' is 98
                97 + 98 = 195
         */

        System.out.println( "a" + "b" );
//        System.out.println( "a" - "b" );  This won't be happening in String case
        /*
            When you add two Strings with +, concatenation occurs.
            "a" and "b" are both String literals, so they are simply joined to form "ab".
         */

        System.out.println( 'a' + 1 );
        /*
            'a' (which is 97 in ASCII) is added to 1.
                97 + 1 = 98.
            Since both operands are numeric (char gets promoted to int), addition occurs rather than concatenation.
         */

        System.out.println( (char)('a' + 1) );
        /*
            'a' is 97 in ASCII, and adding 1 gives 98.
            (char) casts the result back to a character:
            98 corresponds to 'b' in ASCII.
         */

        System.out.println( "a" + 1 );
            /*

                When a String is added to an integer, Java converts the integer to a String using String.valueOf()
                (which internally calls Integer.toString() for primitive types).
                "a" + 1 becomes "a" + "1", resulting in "a1".

                Q/ Why does "a" + 1 produce "a1"?

                    1. String Immutability:

                    a) strings in Java are immutable—once created, their content cannot be changed.
                    b) However, this immutability does not directly affect the addition behavior in "a" + 1. What happens here is more about
                       how Java handles type conversion and overloads the + operator.

                    2. Type Conversion Mechanism:

                    a) In Java, when you use the + operator with a String and a primitive type (like int), the non-string operand is automatically
                       converted into a String.
                    b) this is done by calling String.valueOf() on the int. Internally, this method calls Integer.toString() to convert the integer 1
                       into the string "1".

                    3. String Concatenation:

                    a) Once the integer 1 is converted to "1", Java performs string concatenation—joining the two string
                                representations:
                                "a" + "1" → "a1"

                    Q/ Why not convert "a" to a number?

                    a) Strings cannot be automatically converted to numbers during arithmetic operations in Java.
                    b) Since "a" is already a String, the only valid operation is concatenation—not arithmetic addition.
             */

        System.out.println( "Akshit" + new ArrayList<>() );
        /*
            a) Java never tries to convert a String to another object type during concatenation.
            b) Instead, it always converts the non-String operand into a String using toString().
            c) Since ArrayList is a subclass of Object, its toString() implementation is used.
         */

//        System.out.println( new Integer(30) + new ArrayList<>() );
        /*
            Here there is error in the above line
            This is because in Java the '+' operator is only is there is a primitive datatype or any one of the value is String
         */

        // Instead of "new Integer(30)" we have used "Integer.valueOf(30)"
        System.out.println( Integer.valueOf(30) + " " + new ArrayList<>() );
        /*
            Here it is working because we have added an empty string in between
            Therefore there should be primitive or any one value of string

            and whole output will be in the form of String
         */


        String num = "abc";
        System.out.println( into_ASCII( num ,0));
    }

    static int into_ASCII( String processed , int value){

        if( processed.isEmpty() ){
            return value;
        }

        char ch = processed.charAt(0);
        value = ch + value;

        return into_ASCII( processed.substring(1), value) ;
    }

}
