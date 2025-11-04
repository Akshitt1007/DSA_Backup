package j_File_Handling;


import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class z9_Reading_n_Writing_in_File {
    public static void main(String[] args) {

        String input = null;

        // Taking input through user
        // Done via read
        try ( BufferedReader br = new BufferedReader( new InputStreamReader(System.in))){

            System.out.println("Enter something to Append in note.txt file: " );
            input = br.readLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Storing the input in file
        // done via Write
        try( FileWriter fw = new FileWriter( "note1.txt",true) ){
            // Creates a FileWriter to write text to the file "note.txt".
            // If the file doesn't exist, it creates it.
            // If it does exist, it overwrites it.

            fw.write( "\n" +  input );
            System.out.println("Successfully written to note.txt");

        } catch (IOException e) {
            System.out.println("File or directory not found");
        }

    }
}

