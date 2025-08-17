package h_OOPS.Collection_Vector_Enum;

/*
         1. Definition:

                - Enum (Enumeration) is a special data type in Java, used to define a fixed set of constants.
                - Example: days of the week, directions, status codes.

         2. Why we need Enums:

                - Without enums, we may use integers or strings to represent constants.
                - Problems:
                    1. Integers: can assign invalid values (e.g., day = 100).
                    2. Strings: prone to typos (e.g., "Mondai").
                - Enums solve this:
                    1. Type safety (only predefined constants allowed).
                    2. More readable, maintainable, and cleaner code.

         3. Syntax:

                enum EnumName { CONSTANT1, CONSTANT2, CONSTANT3, ... }

         4. Extra Features:

                - Enums are implicitly public static final.
                - Can implement interfaces (but cannot extend classes).
                - Can loop using .values():
                    for (Day d : Day.values()) { System.out.println(d); }

 */
public class c1_Enums {

    enum Week{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    public static void main(String[] args) {

        Week day;

        day = Week.Monday;

        System.out.println( day );
        System.out.println();

        // This will tell us the index of which position is enum declared
        System.out.println( day.ordinal() );
        System.out.println();

        for( Week days : Week.values() ){
            System.out.println( days );
        }
        System.out.println();

    }
}
