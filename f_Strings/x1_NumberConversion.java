package f_Strings;

import java.util.Scanner;

public class x1_NumberConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        // Convert using Wrapper class methods
        String binary = Integer.toBinaryString(num);
        String octal = Integer.toOctalString(num);
        String hex = Integer.toHexString(num);

        // Display results
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hex);

        sc.close();
    }
}