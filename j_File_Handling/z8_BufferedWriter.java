package j_File_Handling;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileWriter;

/*

    BufferedWriter Class :
        -> The BufferedWriter class is used to write text to a character stream.
        -> The BufferedWriter class has three overloaded versions of the write() method.
        -> The BufferedWriter class introduces a method named newLine() which means that you will not have to hardcode in the "\r\n" into your output stream anymore.
        -> The BufferedWriter class implements AutoClosable so we can use the try-with-resources type exception handling.
 */
public class z8_BufferedWriter {
    public static void main(String[] args) {

        // On console
        try ( BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out )) ){

            bw.write( 97 );
            bw.write(  "Akshit Choudhary");
            bw.write( "L" );
            char[] arr = "Rohan".toCharArray();
            bw.write( arr );

        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        // In File
        try ( BufferedWriter bww = new BufferedWriter( new FileWriter( "note1.txt" )) ){

            bww.write( "Hare Krishna");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
