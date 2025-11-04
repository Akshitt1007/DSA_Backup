package j_File_Handling;

import java.io.*;

public class z11_Append_Content_File_at_end_of_Another_file {
    public static void main(String[] args) {

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("note2.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("note3.txt", true));

            String line;

            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader1.close();
            BufferedReader reader2 = new BufferedReader(new FileReader("note1.txt"));

            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader2.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
