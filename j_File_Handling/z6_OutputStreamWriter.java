package j_File_Handling;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
    OutputStreamWriter Class :
    EXTENDS WRITER

    -> Used to write to character streams.
    -> The OutputStreamWriter class implements AutoClosable so we can use the try-with-resources type exception handling.
    -> There are only four public methods in the OutputStreamWriter class: close(), flush(), getEncoding(), and write().
    -> The write() method has three overloaded versions :
            -write(int a) : writes a single character to character stream.
                            Characters being written is contained in 16 lower bits of the ‘char’ integer value,
                            rest of the 16 higher bits are ignored by the method.
            -write(String str)
            -write(char cbuf[])
 */

// OutputStreamWriter is a bridge from char → byte (takes characters and encodes them into bytes using a charset).
public class z6_OutputStreamWriter {
    public static void main(String[] args) {

        OutputStream os = System.out;

        try( OutputStreamWriter osw = new OutputStreamWriter( os ) ) {

            osw.write("Akshit");
            osw.write( 10 );
            osw.write( 97 );
            osw.write( "A" );
            osw.write( "a" );
            osw.write( "\n" );
            char[] arr = "Hello everyone!".toCharArray();
            osw.write( arr );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
