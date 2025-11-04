package c_Arrays;

import java.util.Scanner;

public class x12_Digit_subtractionn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a 4-digit number: ");
        int number = scanner.nextInt();

        if (number < 1000 || number > 9999) {
            System.out.println("Invalid input. Enter a number between 1000 and 9999.");
            return;
        }

        String numStr = String.valueOf(number);
        String result = "";

        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';  // Convert char to digit

            if (digit == 0) {
                digit = 9;  // Wrap 0 to 9
            } else {
                digit -= 1;  // Subtract 1
            }

            result += digit;  // Add to result string
        }

        System.out.println("Output: " + result);
    }
}
