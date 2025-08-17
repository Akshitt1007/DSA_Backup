package j_File_Handling;

import java.io.FileWriter;
import java.io.IOException;
/*
    FileWriter Class :
    EXTENDS OutputStreamWriter

        -> The purpose of the FileWriter class is to simply write character based files.
        -> The FileWriter class implements AutoClosable so we can use the try-with-resources type exception handling.
        -> FileWriter class does not define or override any public methods, so it inherits all of its methods from its superclass OutputStreamWriter.
 */
public class z7_FileWriter {
    public static void main(String[] args) {

        try( FileWriter fw = new FileWriter( "note1.txt") ){
            // This will just override the content in tht note.txt

            fw.write("Akshit Choudhary");

        } catch (IOException e) {
            System.out.println("File not found");
        }

        try( FileWriter fw = new FileWriter( "note1.txt", true) ){
            // This will just not override and will append all the extra content in the note1.txt

            fw.write("\nextra content");
            System.out.println("Successfully written to note.txt");

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
