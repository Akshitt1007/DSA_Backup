package b_Functions;

import java.util.Scanner;

public class b10_Taking_undefined_Input {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Enter text (press Enter on a blank line to stop):");

        while (true) {
            input = sc.nextLine();  // read full line

            // if user presses Enter without typing anything
            if (input.trim().isEmpty()) {
                break;  // exit loop
            }

            System.out.println("You entered: " + input);
        }

        System.out.println("Input ended.");
        sc.close();

    }
}
