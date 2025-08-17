package j_File_Handling;
import java.io.*;
import java.util.Scanner;

public class z13_Convert_tabs_to_spaces_in_file {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filepath = sc.nextLine();
        printDuplicatesWords(filepath);
    }

    static void printDuplicatesWords(String filepath) {
        try {
            File file = new File(filepath);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split("\\s+");

                for (int i = 0; i < words.length; i++) {
                    int cnt = 1;
                    while (i + 1 < words.length && words[i].equals(words[i + 1])) {
                        cnt++;
                        i++;
                    }
                    if (cnt > 1) {
                        System.out.print(words[i] + "*" + cnt + " ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
