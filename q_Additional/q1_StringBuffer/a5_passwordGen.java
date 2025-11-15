package q_Additional.q1_StringBuffer;

import java.util.Random;
import java.util.Scanner;

public class a5_passwordGen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();

        System.out.print("Length: ");
        int l = sc.nextInt();

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvwxyz"
                + "0123456789"
                + "!@#$%^&*";

        String password = "";

        for (int i = 0; i < l; i++) {
            int index = rand.nextInt(chars.length());

//            password = password + (char)(index);
            // Above line is incorrect because this means convert the index into char
            // but we want the char at that index
            password = password + chars.charAt(index);

        }

        System.out.println("Generated Strong Password: " + password);
    }
}
