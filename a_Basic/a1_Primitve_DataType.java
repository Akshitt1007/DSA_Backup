package a_Basics;

public class a1_Primitve_DataType {

    // Primitive datatypes are basic building blocks in Java
    // They cannot be further broken down into smaller datatypes.
    // For example, a String (like "Akshit") is NOT a primitive data type
    // because it can be broken into characters ('A', 'k', etc.).

    /*

    There are total of 8 primitive datatypes in java :

    1.  byte:
   - Size: 1 byte (8 bits)
   - Range: -128 to 127
   - Used to save memory in large arrays of numbers.

    2. short:
   - Size: 2 bytes (16 bits)
   - Range: -32,768 to 32,767
   - Useful when memory savings are needed for large arrays.

    3. int:
   - Size: 4 bytes (32 bits)
   - Range: -2^31 to 2^31-1
   - Default type for integers.

    4. long:
   - Size: 8 bytes (64 bits)
   - Range: -2^63 to 2^63-1
   - Used for larger integers.

    5. float:
   - Size: 4 bytes (32 bits)
   - Range: Varies, but can represent decimal numbers.
   - Used for floating-point numbers with less precision.

    6. double:
   - Size: 8 bytes (64 bits)
   - Range: Varies, can represent decimal numbers with higher precision.
   - Default type for decimal numbers.

    7. char:
   - Size: 2 bytes (16 bits)
   - Represents a single 16-bit Unicode character.
   - Can hold any character (e.g., 'a', 'A', '1', etc.).

    8. boolean:
   - Size: 1 bit (though not precisely defined in Java, it's typically 1 bit in practice).
   - Values: `true` or `false`
   - Used for logical operations and decision-making.

     */


    public static void main(String[] args) {

        // 4 bytes: Stores integer values
        int roll_number = 1769;                 // Primitive type
        int million = 2_000_000;        // we cannot write , so instead we use _

        // 8 bytes: Used for larger integer values
        long full_roll_number = 2310991769L;    // 'L' indicates a long literal

        // 2 bytes: Stores single characters
        char letter = 'A';

        // 4 bytes: Stores decimal numbers with smaller precision
        float marks = 6.9f;                     // 'f' indicates a float literal

        // 8 bytes: Stores decimal numbers with higher precision
        double large_numbers = 23109917699087654.0987;

        // 1 byte: Stores true or false values
        boolean check = false;

        // Why do we add 'L' and 'f' for some data types?

        // 1. Float ('f'):
        // By default, all decimal numbers in Java are considered as `double`.
        // To explicitly specify that a number is a `float`, we add 'f' at the end.
        // If we don't want to add 'f', we can use `double` instead of `float`.

        // 2. Long ('L'):
        // By default, all integer literals are treated as `int`.
        // Since `long` can store much larger values than `int`,
        // we add 'L' at the end to explicitly specify that the value is a `long`.
        // Without 'L', the compiler would treat the value as an `int`, leading to errors
        // if the value exceeds the range of `int`.

        // We can write 'l' but it can confuse system so it is recommended to write 'L'.

        // Non-primitive type

        String name = "Akshit Choudhary"; // Strings are NOT primitive types
        // Strings are objects in Java and can be broken into smaller components (e.g., chars).

        int a = 10 ;
        //  here 10 is literal
        //  a literal is a fixed, constant value that is directly written in the source code. It represents the actual value
        //  of data used in your program and does not change during the program's execution.
        System.out.print("Value of a is: " + a );

    }
}
