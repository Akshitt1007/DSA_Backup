package j_File_Handling;
import java.io.*;

public class z12_Check_Empty_Lines {
    public static void main(String[] args) {

        try{
            BufferedReader bf = new BufferedReader( new FileReader("New_File.txt"));
            int totalline = 0;
            int blankline = 0;

            String line;

            while( ( line = bf.readLine()) != null ){
                totalline++;
                if ( line.isEmpty() ){
                    blankline++;
                }
            }
            bf.close();
            System.out.println(totalline + " " + blankline );
        }
        catch ( IOException e ){
            e.printStackTrace();
        }
    }
}
