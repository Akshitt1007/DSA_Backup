package j_File_Handling;

import java.io.FileReader;
import java.io.IOException;

/*
    🔹 2. Input from External File

    FileReader rd = new FileReader("note.txt");

    -> Reads character input from an external file (in this case, note.txt).
    -> FileReader is a subclass of InputStreamReader designed for reading character files.
    -> It works on character streams — not byte streams.
    -> That's why we import:
        ➤ import java.io.FileReader;
        ➤ import java.io.IOException;


    FileReader Class :

    -> The purpose of the FileReader class is to simply read character based files.
    -> The FileReader class implements AutoClosable so we can use the try-with-resources type exception handling.
    -> It also interesting to note that the FileReader class does not define or override any public methods,
    -> so it inherits all of its methods from its superclass InputStreamReader; InputStreamReader is a subclass of Reader
       which is a subclass of Object and that describes the class hierarchy.

                        Object -> Reader -> InputStreamReader -> FileReader
 */

public class z4_FileReader {
    public static void main(String[] args) {

        try (FileReader rd = new FileReader("note1.txt")) {
            // Reads characters from an external text file (note.txt)
            // FileReader reads one character at a time — as its Unicode int value (0 to 65535)

            int letter = rd.read(); // 🔹 Step 1: Read the first character as an int (Unicode/ASCII)

            while (rd.ready()) {    // 🔸 Step 2: Check if more characters are available (non-blocking)

                System.out.println(letter);         // Print ASCII/Unicode value
                System.out.println((char) letter);  // Print the actual character

                letter = rd.read(); // 🔹 Step 3: Read the next character
            }

            System.out.println(); // Just adds a newline for clean output
        } catch (IOException e) {
            System.out.println("No file or directory found.");
        }
    }
}

/*
    Reason:
    FileReader.read() returns an int, not a char, for a very important reason:

        public int read() → it returns:

        -> The Unicode value of the character read (0 to 65535)
        -> OR -1 if End of File (EOF) is reached

    Why not use char?
    Because:

        -> char cannot store -1 (minimum value is 0).
        -> So you can’t detect EOF using a char.
        -> That’s why int is used — it safely handles:
               - Valid character values
               - End of file -1
*/
/*
        When we write :
        char letter = (char) fr.read();

        the method fr.read() returns the ASCII (or Unicode) numeric value of the character as an int. By casting it to char,
        we convert this numeric code back into its corresponding character. So, although we store it in a char variable, under the
        hood, it's still the character represented by that ASCII or Unicode value.
 */
