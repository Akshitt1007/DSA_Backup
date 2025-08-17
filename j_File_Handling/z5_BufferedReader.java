package j_File_Handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    1. BufferedReader is a Java class for reading text from input streams efficiently.
    2. It uses a buffer (a memory chunk) to read multiple characters at once.
    3. This avoids reading one character at a time from the source, which is slow.
    4. Supports reading line by line with methods like readLine().
    5. Improves performance, especially for large input.


    🧠 Summary:
        -> Without buffering: Reads char-by-char from disk/keyboard = slow.
        -> With BufferedReader: Grabs a bunch of chars into memory first = fast.
 */
public class z5_BufferedReader {
    public static void main(String[] args) {

        // BufferedReader reads the char value
        // since System.in give the byte value we need to convert that into char value

        // 1. System.in gives us bytes.
        // 2. InputStreamReader turns bytes into characters.
        // 3. BufferedReader takes those characters and lets us read full lines efficiently.
        try( BufferedReader br = new BufferedReader( new InputStreamReader( System.in )) ) {

            System.out.println( "You read: " + br.readLine() );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Instead of taking from keyword
        // we are reading from a file
        try( BufferedReader br = new BufferedReader( new FileReader( "note1.txt" )) ) {

            // br.ready() -> checks if there's data available to be read
            while( br.ready() ){
                System.out.println( "File: " + br.readLine() );
            }

        } catch (IOException e) {
            System.out.println("File not found");
        }

    }
}
/*
    BufferedReader Class : BufferedReader(Reader inputReader)

    IT EXTENDS READER. HENCE HAS IT'S OWN read() which is same as InputStreamReader.
        1. The BufferedReader class is used to read text from a character stream.
        2. The BufferedReader class has the same read() method that both InputStreamReader and FileReader use to read a single byte at a time.
        3. The BufferedReader class introduces a method named readLine() which will read an entire line of text which is a huge improvement.
        4. The BufferedReader class implements AutoClosable so we can use the try-with-resources type exception handling.

    To obtain a character-based stream that is attached to the console, wrap "System.in" in a BufferedReader object.
        InputStreamReader(InputStream inputStream)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    NOTE : new InputStreamReader(System.in) converts byte stream into char stream.
           AND then br is reading that char stream. Which is what we want!
           After this statement executes, br is a character-based stream that is linked to the console through System.in.
 */
