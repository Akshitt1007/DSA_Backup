package j_File_Handling;

import java.io.IOException;
import java.io.InputStreamReader;

/*
        1. Input from External Device (Keyboard)

        InputStreamReader isr = new InputStreamReader(System.in);

            -> Reads character input from the console (keyboard).
            -> Since System.in is a byte stream, we wrap it with InputStreamReader to convert it into a character stream.
            -> For this, we import:

        import java.io.InputStreamReader;
 */

// InputStreamReader is a bridge from byte → char (reads byte data and decodes it into characters using a charset).
public class z3_InputStreamReader {
    public static void main(String[] args) {

        // converting byte stream into character stream
        // Keyboard (bytes) → System.in (byte stream) → InputStreamReader (byte-to-char decoder) → isr.read() (char-by-char input)
        try (InputStreamReader isr = new InputStreamReader(System.in)) {
            // This will take input from an external device
            // ie keyword here
            // that's why we used .Input.StreamReader

            System.out.print("Enter some letters:");

            int letters = isr.read(); // 🔹 Step 1: Read the first character (as an int — ASCII)

            while (isr.ready()) {     // 🔸 Step 2: While more input is available (without blocking)

                // The loop while (isr.ready()):
                //Checks if there’s more data in the stream that can be read without blocking.
                //It's kind of a soft check — once all the user input (including newline) is consumed, it becomes false.

                System.out.println(letters);        // print ASCII value
                System.out.println((char) letters); // print actual character
                letters = isr.read();               // 🔹 Step 3: Read the next character
            }

            System.out.println(); // Just to add a newline
        } catch (IOException e) {
            System.out.println(e.getMessage()); // handle IO exception
        }

    }
}

/*
    | '1' | '2' | '3' | '\n' |
       ^      (waiting to be read)

    -> isr.read() reads just one character (e.g. '1').
    -> Converts it to ASCII and stores in letters.
    -> Rest of the string ("23") is left in the input stream for the next read()s.


    read() reads (consumes) the next character from the input, while ready() checks whether there is input available to read without blocking.

 */
