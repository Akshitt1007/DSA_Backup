package j_File_Handling;
import java.io.*;

/*

    File Class :

        Consider this Windows hard coded path represented as a string: "c:\\Java\\BW\\Sample.txt". If a user attempted to run
        your program on a Linux or UNIX OS, your program will fail miserably. That is because the directory separator is '/' in
        UNIX as opposed to '\' in Windows. The file class provides us with several tools to dynamically create our directory
        and file structure.

    Constructors:
        -> File(File parent, String child)
        -> File(String pathname)   // not very useful for multi-platform
        -> File(String parent, String child)
        -> File(URI uri)
 */

public class z10_File {
    public static void main(String[] args) {

        // Creating new file
        try{
            File fo = new File("New_file.txt");
            fo.createNewFile();

            System.out.println( "File creation done");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Writing in file
        try( BufferedWriter bw = new BufferedWriter( new FileWriter("New_File.txt")) ){

            bw.write("Hello everyone");
            bw.newLine();
            bw.write("New file content");
            bw.close();

            System.out.println( "File writing done");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Reading the File
        try ( BufferedReader br = new BufferedReader( new FileReader("New_File.txt")) ) {

            System.out.println("File says:\n");

            while( br.ready() ){
                System.out.println( br.readLine() );
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // Deleting file
        try {
            File fo = new File("random.txt");
            fo.createNewFile();
            if(fo.delete()) {
                System.out.println(fo.getName());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
